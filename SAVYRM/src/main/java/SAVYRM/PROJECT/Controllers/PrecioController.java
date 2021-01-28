package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.PersistentData;
import SAVYRM.PROJECT.Entities.Precio;
import SAVYRM.PROJECT.Entities.Producto;
import SAVYRM.PROJECT.Respositories.PrecioRepository;
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
@RequestMapping(path="/Precio") 
public class PrecioController {
    @Autowired
    private PrecioRepository precioRepository;
    
    @GetMapping(path="/GetPrecio")
    public @ResponseBody Iterable<Precio> GetAllPrecio()
    {
        System.out.println("GetPrecio()<-");
        System.out.println("GetPrecio()->");
        return precioRepository.findAll();
    }
    
    @PostMapping(path="/FindPrecioByProducto")
    @ResponseBody
    public Iterable<Precio> FindPrecioByProducto(@RequestBody String idProducto)
    {  
        System.out.println("FindPrecioByProducto()");
        return precioRepository.findByProductoIdProductoOrderByFechaInicioPrecioDesc(Integer.parseInt(idProducto));
    }
    
    @PostMapping(path="/AddPrice")
    @ResponseBody
    public void AddPrice(@RequestBody Map<String, String> allParams)
    {  
        System.out.println("AddPrice()");
        
        // Set product
        Producto producto = new Producto();
        producto.setIdProducto(Integer.parseInt(allParams.get("idProduct")));
        
        // Set price
        Precio precio = new Precio();
        precio.setFechaInicioPrecio(allParams.get("inicioVigencia"));
        precio.setUnitarioPrecio(Double.parseDouble(allParams.get("productopriceToAdd")));
        precio.setVigentePrecio(PersistentData.PRECIO_VIGENTE_ID); // Vigente
        precio.setProducto(producto);
        System.out.println("Set new price price()");
        precioRepository.save(precio);
        
        // Validate if exist previous price
        if (Integer.parseInt(allParams.get("idPrecioVigente")) == 0 ) {
            System.out.println("NO previous price to update");
            return;
        }
        
        // Set precio to replace
        Precio previousPrice = precioRepository.findById(Integer.parseInt(allParams.get("idPrecioVigente"))).get();
        previousPrice.setFechaFinPrecio(allParams.get("inicioVigencia"));
        previousPrice.setVigentePrecio(PersistentData.PRECIO_NO_VIGENTE_ID); // Vigente
        System.out.println("Alter previos price()");
        precioRepository.save(previousPrice);
    }
}
