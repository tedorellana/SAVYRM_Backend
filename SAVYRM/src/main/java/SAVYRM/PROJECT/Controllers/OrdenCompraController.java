package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.ProductoBase;
import SAVYRM.Containers.ProductoSeccionPrecio;
import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Entities.OrdenCompra;
import SAVYRM.PROJECT.Entities.OrdenCompraProducto;
import SAVYRM.PROJECT.Entities.Producto;
import SAVYRM.PROJECT.Entities.ProductoFormula;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import SAVYRM.PROJECT.Entities.Seccion;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Entities.TipoProducto;
import SAVYRM.PROJECT.Entities.UnidadMedida;
import SAVYRM.PROJECT.Respositories.OrdenCompraProductoRepository;
import SAVYRM.PROJECT.Respositories.OrdenCompraRepository;
import SAVYRM.PROJECT.Respositories.ProductoRepository;
import SAVYRM.PROJECT.Respositories.ProductoSeccionRepository;
import SAVYRM.PROJECT.Utilities.MeasurementsUtilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/OrdenCompraProducto") 
public class OrdenCompraController {
    @Autowired
    private OrdenCompraProductoRepository ordenCompraProductoRepository;
    
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    
    @PostMapping(path="/OrdersPerProduct")
    @ResponseBody
    public Iterable<OrdenCompraProducto> OrdersPerProduct(@RequestBody String OrdersPerProduct)
    {   
        System.out.println("OrdersPerProduct()->" + OrdersPerProduct);
        return ordenCompraProductoRepository.findByProductoIdProductoOrderByFechaEntregaPrevistaOrdenCompraProductoDesc(Integer.parseInt(OrdersPerProduct));
    }
    
    @GetMapping(path="/GetAllOrders")
    public @ResponseBody Iterable<OrdenCompra> GetAllOrders()
    {
        System.out.println("GetAllOrders()");
        return ordenCompraRepository.findAll();
    }
    
    @PostMapping(path="/FindOrderProductoByOrderId")
    @ResponseBody
    public Iterable<OrdenCompraProducto> FindOrderProductoByOrderId(@RequestBody String idOrder)
    {   
        System.out.println("FindOrderProductoByOrderId()<-");
        
        if (idOrder == null) {
            System.out.println("idOrder is missing");
            return null;
        }
    
        return ordenCompraProductoRepository.findByOrdenCompraIdOrdencompra(Integer.parseInt(idOrder));
    }
    
    @GetMapping(path="/GetAllOrdersProducto")
    public @ResponseBody Iterable<OrdenCompraProducto> GetAllOrdersProducto()
    {
        System.out.println("GetAllOrdersProducto()");
        return ordenCompraProductoRepository.findAll();
    }
}
