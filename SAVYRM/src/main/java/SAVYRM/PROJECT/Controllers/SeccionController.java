package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Entities.Seccion;
import SAVYRM.PROJECT.Respositories.SeccionRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
@RequestMapping(path="/Seccion") 
public class SeccionController {
    @Autowired
    private SeccionRepository seccionRepository;
    
    @GetMapping(path="/GetAllSeccion")
    public @ResponseBody Iterable<Seccion> GetAllSeccion()
    {
        System.out.println("GetAllSeccion()<-");
        System.out.println("GetAllSeccion()->");
        return seccionRepository.findAll();
    }
    
    @PostMapping(path="/GetAllSeccionByAlmacen")
    @ResponseBody
    public Iterable<Seccion> GetAllSeccionByAlmacen(@RequestBody Map<String,List> allParamss)
    {   
        System.out.println("GetAllSeccionByAlmacen()->"+ allParamss.size());
        System.out.println("GetAllSeccionByAlmacen()<-"  + "-" +  allParamss.get("idAlmacenes"));
        return seccionRepository.findAllByAlmacenIdAlmacenIn((Iterable<Integer>)allParamss.get("idAlmacenes"));
    }
    
    @PostMapping(path="/GetSeccionByAlmacen")
    @ResponseBody
    public Iterable<Seccion> GetSeccionByAlmacen(@RequestBody Map<String,Integer> allParamss)
    {   
        System.out.println("GetSeccionByAlmacen()->"+ allParamss.size());
        System.out.println("GetSeccionByAlmacen()<-"  + "-" +  allParamss.get("idAlmacen"));
        return seccionRepository.findAllByAlmacenIdAlmacen(allParamss.get("idAlmacen"));
    }
    
    @PostMapping(path="/SaveSeccion")
    @ResponseBody
    public Integer SaveSeccion(@RequestBody Map<String,String> allParams)
    {   
        System.out.println("GetSeccionByAlmacen()->"+ allParams.size());
        Seccion newSeccion = new Seccion();
        newSeccion.setCodigoSeccion(allParams.get("codigoSeccion"));
        newSeccion.setCapacidadSeccion(Double.parseDouble(allParams.get("capacidadSeccion")));
        newSeccion.setDetalle(allParams.get("detalle"));
        Almacen almacenRelated = new Almacen();
        almacenRelated.setIdAlmacen(Integer.parseInt(allParams.get("fk_idAlmacen")));
        newSeccion.setAlmacen(almacenRelated);
        
        System.out.println("Saving seccion");
        newSeccion = seccionRepository.save(newSeccion);
        int result = newSeccion != null ? 1:0;
        System.out.println("GetSeccionByAlmacen()<-"  + result);
        return result;
    }
}
