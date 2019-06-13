package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.ProductoSeccion;
import SAVYRM.PROJECT.Entities.Servicio;
import SAVYRM.PROJECT.Respositories.ProductoSeccionRepository;
import java.util.List;
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
@RequestMapping(path="/ProductoSeccion") 
public class ProductoSeccionController {
    @Autowired
    private ProductoSeccionRepository productoSeccionRepository;
    
    @GetMapping(path="/GetAllProductoSeccion")
    public @ResponseBody Iterable<ProductoSeccion> GetAllProductoSeccion()
    {
        System.out.println("GetAllProductoSeccion()<-");
        System.out.println("GetAllProductoSeccion()->");
        return productoSeccionRepository.findAll();
    }
    
    @PostMapping(path="/GetAllInventarioBySeccion")
    @ResponseBody
    public Iterable<ProductoSeccion> GetAllInventarioBySeccion(@RequestBody Map<String,List> allParamss)
    {
        System.out.println("GetAllInventarioBySeccion()<-" + allParamss.size() + "-" +  allParamss.get("idSecciones"));
        System.out.println("GetAllInventarioBySeccion()->");
        //Should be replaced to get ID from data base
        return productoSeccionRepository.findAllBySeccionIdSeccionIn((Iterable<Integer>)allParamss.get("idSecciones"));
    }
}
