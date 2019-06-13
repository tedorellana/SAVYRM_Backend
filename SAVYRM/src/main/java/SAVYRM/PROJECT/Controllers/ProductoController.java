package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Entities.Producto;
import SAVYRM.PROJECT.Entities.Seccion;
import SAVYRM.PROJECT.Entities.TipoProducto;
import SAVYRM.PROJECT.Entities.UnidadMedida;
import SAVYRM.PROJECT.Respositories.ProductoRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Producto") 
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    
    @GetMapping(path="/GetProducto")
    public @ResponseBody Iterable<Producto> GetAllProducto()
    {
        System.out.println("GetProducto()<-");
        System.out.println("GetProducto()->");
        return productoRepository.findAll();
    }
    
    @GetMapping(path="/GetAllProducto")
    public @ResponseBody Iterable<Producto> GetAllProducto(@RequestBody Map<String,String> allParams)
    {   
        System.out.println("GetAllProducto()->");
        System.out.println("Params:"+ allParams.size());
        System.out.println("GetAllProducto()<-");
        return productoRepository.findAll();
    }
    
    @PostMapping(path="/GetAllProductoWhereEstadoIsActivado")
    @ResponseBody
    public Iterable<Producto> GetAllProductoWhereEstadoIsActivado(@RequestBody Map<String,String> allParams)
    {   
        System.out.println("GetAllProductoWhereEstadoIsActivado()->");
        System.out.println("Patams size:" + allParams.size());
        System.out.println("Params:" + allParams.values());
        System.out.println("GetAllProductoWhereEstadoIsActivado()<-");
        return productoRepository.findAllByEstadoProducto(Integer.parseInt(allParams.get("activado")));
    }
    
    @PostMapping(path="/SaveProducto")
    @ResponseBody
    public Integer SaveProducto(@RequestBody Map<String,String> allParams)
    {   
        System.out.println("SaveProducto()->");
        System.out.println("Patams size:" + allParams.size());
        System.out.println("Params:" + allParams.values());
        
        Producto newProducto = new Producto();
        TipoProducto tipoProducto = new TipoProducto();
        UnidadMedida unidadMedida = new UnidadMedida();
        
        System.out.println("Preparing 'producto'");
        newProducto.setNombreProducto(allParams.get("nombreProducto"));
        newProducto.setCodigoProducto(allParams.get("nombreProducto"));
        newProducto.setEstadoProducto(1);
        tipoProducto.setIdTipoProducto(Integer.parseInt(allParams.get("fk_idTipoProducto")));
        unidadMedida.setIdUnidadMedida(Integer.parseInt(allParams.get("fk_idUnidadMedida")));
        newProducto.setTipoProducto(tipoProducto);
        newProducto.setUnidadMedida(unidadMedida);
        
        System.out.println("Saving 'producto'");
        newProducto = productoRepository.save(newProducto);
        
        System.out.println("SaveProducto()<-");
        return newProducto != null ? 1:0;
    }
    
    @GetMapping(path="/getAllProductoNoFinalesActivos")
    public @ResponseBody Iterable<Producto> getAllProductoNoFinalesActivos()
    {   
        System.out.println("getAllProductoNoFinalesActivos()->");
        //System.out.println("Params:"+ allParams.size());
        System.out.println("getAllProductoNoFinalesActivos()<-");
        int estadoProducto, idTipoProductoFINAL; // this values should be populated dinamically
        estadoProducto = 1;
        idTipoProductoFINAL = 1;
        //return productoRepository.findAllByEstadoProductoDistinctTipoProductoIdTipoProducto(estadoProducto, idTipoProductoFINAL);
        return productoRepository.findByEstadoProductoAndTipoProductoIdTipoProductoNot(estadoProducto, idTipoProductoFINAL);
    }
}
