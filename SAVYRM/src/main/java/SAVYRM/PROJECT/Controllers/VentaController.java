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
import SAVYRM.PROJECT.Respositories.ProductoSeccionRepository;
import SAVYRM.PROJECT.Respositories.SeccionRepository;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import SAVYRM.PROJECT.Respositories.ServicioRepository;
import SAVYRM.PROJECT.Utilities.DateTimeUtilities;
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
    private ServicioRepository servicioRepository;
    
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
        System.out.println("Establece empleado.");
        Persona empleado = new Persona();
        empleado.setIdPersona(carritoDeCompraWrapper.getDetallesServicio().idEmpleado);
        
        // Establece cliente
        System.out.println("Establece cliente.");
        Persona cliente = new Persona();
        cliente.setIdPersona(carritoDeCompraWrapper.getDetallesServicio().idEmpleado);
        
        // Establece la venta 
        System.out.println("Establece servicio.");
        Servicio venta = new Servicio();
        venta.setHoraInicioServicio(carritoDeCompraWrapper.getDetallesServicio().getDateTimeServiceBegin());
        venta.setHoraFinServicio(DateTimeUtilities.GetCurrentDateTime());
        venta.setPersonaEmpleado(cliente);
        venta.setPersonaAtendida(empleado);
        venta.setTipoServicio(tipoServicio); 
        venta.setTipoServicio(tipoServicio);
        
        // Guarda el servicio
        venta = servicioRepository.save(venta);
        
        for (CarritoDeCompra prod : carritoDeCompraWrapper.getCarritoDeCompras()) {
            // Establece productoSeccion
            ProductoSeccion productoSeccion = new ProductoSeccion();
            productoSeccion.setIdProductoSeccion(prod.getIdProductoSeccion());
            
            // Establece servicioProducto
            ServicioProducto servicioProducto = new ServicioProducto();
            servicioProducto.setCantidadServicioProducto(prod.getCantidad());
            servicioProducto.setCostoTotal(100.00); // TODO: debe ser calculado y no tomado por la vista
            servicioProducto.setServicio(venta);
            servicioProducto.setProductoSeccion(productoSeccion);
            
            System.out.println("guarda ServicioProducto: " + prod.getNombreProducto());
            // Guarda la producto
            servicioProductoRepository.save(servicioProducto);
        }
    }
}
