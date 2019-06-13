package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Indicacion;
import SAVYRM.PROJECT.Respositories.IndicacionRepository;
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
@RequestMapping(path="/indicacionController") 
public class IndicacionController {
    @Autowired
    private IndicacionRepository indicacionRepository;
    
    @GetMapping(path="/GetIndicacion")
    public @ResponseBody Iterable<Indicacion> GetIndicacion()
    {
        System.out.println("GetIndicacion()<-");
        System.out.println("GetIndicacion()->");
        return indicacionRepository.findAll();
    }
    
        
    @PostMapping(path="/GetAllIndicacionByProductoIdProdcuto")
    @ResponseBody
        public Iterable<Indicacion> GetAllIndicacionByProducto(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("GetAllIndicacionByProductoIdProdcuto()<-");
        System.out.println("GetAllIndicacionByProductoIdProdcuto()<-" + allParamss.size() + "-" +  allParamss.values());
        System.out.println("GetAllIndicacionByProductoIdProdcuto()->");
        return indicacionRepository.findByPreparacionProductoIdProducto(Integer.parseInt(allParamss.get("idProducto")));
        //return indicacionRepository.findAll();
    }
}
