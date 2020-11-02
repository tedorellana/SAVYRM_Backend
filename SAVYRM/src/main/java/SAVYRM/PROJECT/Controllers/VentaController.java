package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.CarritoDeCompraWrapper;
import SAVYRM.Containers.CarritoDeCompra;
import SAVYRM.Containers.PersistentData;
import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Entities.Persona;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import SAVYRM.PROJECT.Entities.Servicio;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Entities.TipoServicio;
import SAVYRM.PROJECT.Respositories.PrecioRepository;
import SAVYRM.PROJECT.Respositories.ProductoSeccionRepository;
import SAVYRM.PROJECT.Respositories.SeccionRepository;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import SAVYRM.PROJECT.Respositories.ServicioRepository;
import SAVYRM.PROJECT.Utilities.DateTimeUtilities;
import SAVYRM.PROJECT.Utilities.VentaUtilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Venta") 
public class VentaController {
    @Autowired
    private ServicioProductoRepository servicioProductoRepository;
    
    @Autowired
    private ProductoSeccionRepository productoSeccionRepository;
    
    @Autowired
    private ServicioRepository servicioRepository;
    
    @Autowired
    private PrecioRepository precioRepository;
    
    @PostMapping(path="/RegistrarVenta")
    @ResponseBody
    public void RegistrarVenta(@RequestBody CarritoDeCompraWrapper carritoDeCompraWrapper)
    {   
        System.out.println("RegistrarVenta()");
        
        if (carritoDeCompraWrapper.getDetallesServicio() == null) {
            System.out.println("ERROR: Detalles del servicio es NULL.");
            return;
        }
                
        //TODO: Debe jalar valor de la BD
        System.out.println("Establece tipo servicio.");
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setIdTipoServicio(PersistentData.VENTA_IDSERVICIO);
        
        // Establece empleado
        System.out.println("Set employe.");
        Persona empleado = new Persona();
        empleado.setIdPersona(carritoDeCompraWrapper.getDetallesServicio().idEmpleado);
        
        // Establece cliente
        System.out.println("Ser Client.");
        Persona cliente = new Persona();
        cliente.setIdPersona(carritoDeCompraWrapper.getDetallesServicio().idEmpleado);
        
        // Establece la venta 
        System.out.println("set Service.");
        Servicio venta = new Servicio();
        venta.setHoraInicioServicio(carritoDeCompraWrapper.getDetallesServicio().getDateTimeServiceBegin());
        venta.setHoraFinServicio(DateTimeUtilities.GetCurrentDateTime());
        venta.setPersonaEmpleado(cliente);
        venta.setPersonaAtendida(empleado);
        venta.setTipoServicio(tipoServicio);
        
        // Guarda el servicio
        venta = servicioRepository.save(venta);
        
        for (CarritoDeCompra prod : carritoDeCompraWrapper.getCarritoDeCompras()) {
            // Establece productoSeccion
            System.out.println("Set ProductoSeccion.");
            ProductoSeccion productoSeccion = new ProductoSeccion();
            productoSeccion = productoSeccionRepository.findById(prod.getIdProductoSeccion()).get(); // Get the first one occurence.
            productoSeccion.setCantidadProductoSeccion(VentaUtilities.CalculateNewStock(productoSeccion.getCantidadProductoSeccion() ,prod.getCantidad()));
            System.out.println("ProductoSeccion id to be updates: " + productoSeccion.getIdProductoSeccion());
            productoSeccionRepository.save(productoSeccion);
            
            System.out.println("Get precio for producto: " + productoSeccion.getProducto().getIdProducto());
            double currentPrice = precioRepository.findByProductoIdProductoAndVigentePrecio(productoSeccion.getProducto().getIdProducto(), PersistentData.VIGENTE_PRECIO).iterator().next().getUnitarioPrecio();
            System.out.println("Get precio for producto (currentPrice): " + currentPrice);
            
            System.out.println("Set servicioProducto");
            // Establece servicioProducto
            ServicioProducto servicioProducto = new ServicioProducto();
            servicioProducto.setCantidadServicioProducto(prod.getCantidad());
            servicioProducto.setCostoTotal(VentaUtilities.CalculatePrice(prod.getCantidad(), prod.getPrecioTotalProducto())); // TODO: debe ser calculado y no tomado por la vista
            servicioProducto.setFechaEntrega(prod.getFechaEntrega());
            System.out.println("prod.getEntregado()-> " + prod.getEntregado());
            servicioProducto.setEntregado(prod.getEntregado());
            servicioProducto.setServicio(venta);
            servicioProducto.setProductoSeccion(productoSeccion);
            
            System.out.println("save ServicioProducto: " + prod.getNombreProducto());
            // Guarda la producto
            servicioProductoRepository.save(servicioProducto);
        }
    }
}
