package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.CarritoDeCompras;
import SAVYRM.Containers.ElementosDelCarrito;
import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Entities.Persona;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import SAVYRM.PROJECT.Entities.Servicio;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Entities.TipoServicio;
import SAVYRM.PROJECT.Respositories.ProductoSeccionRepository;
import SAVYRM.PROJECT.Respositories.SeccionRepository;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    @PostMapping(path="/RegistrarVenta")
    @ResponseBody
    public void RegistrarVenta(@RequestBody CarritoDeCompras carritoDeCompras)
    {   
        System.out.println("RegistrarVenta()");
        
        //TODO: Debe jalar valor de la BD
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setIdTipoServicio(2);
        
        Persona empleado = new Persona();
        empleado.setIdPersona(1); // TODO: poblar id de manera dinámica
        
        Persona cliente = new Persona();
        cliente.setIdPersona(1); // TODO: poblar id de manera dinámica
        
        Servicio venta = new Servicio();
        venta.setHoraInicioServicio("");
        venta.setHoraFinServicio("");
        venta.setTipoServicio(tipoServicio); 
        venta.setTipoServicio(tipoServicio);
        
        System.out.println("RegistrarVenta 2");
        System.out.println("Elementos: " + carritoDeCompras.toString());
        System.out.println("Elementos: " + carritoDeCompras.getElementos() );
    
        for (int i = 0; 0 < carritoDeCompras.getElementos().size(); i++) {
             System.out.println("registrando elemento");
            ProductoSeccion productoSeccion = new ProductoSeccion();
            productoSeccion.setIdProductoSeccion(carritoDeCompras.getElementos().get(i).getIdProductoSeccion());
        
            ServicioProducto servicioProducto = new ServicioProducto();
            servicioProducto.setCantidadServicioProducto(carritoDeCompras.getElementos().get(i).getCantidad());
            servicioProducto.setCostoTotal(100.00); // TODO: debe ser calculado y no tomado por la vista
            servicioProducto.setServicio(venta);
            servicioProducto.setProductoSeccion(productoSeccion);
            System.out.println("saving servicioProductoRepository ->" + carritoDeCompras.getElementos().get(i).getCantidad());
            servicioProductoRepository.save(servicioProducto);
        }
    }
}
