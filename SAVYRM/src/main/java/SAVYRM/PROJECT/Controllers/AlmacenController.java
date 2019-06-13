package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Almacen;
import SAVYRM.PROJECT.Respositories.AlmacenRepository;
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
@RequestMapping(path="/Almacen") 
public class AlmacenController {
    @Autowired
    private AlmacenRepository almacenRepository;
    
    @GetMapping(path="/GetAllAlmacen")
    public @ResponseBody Iterable<Almacen> GetAllAlmacen()
    {
        System.out.println("GetAllAlmacen()<-");
        System.out.println("GetAllAlmacen()->");
        return almacenRepository.findAll();
    }
    
    @PostMapping(path="/SaveAlmacen")
    @ResponseBody
    public Integer SaveAlmacen(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("SaveAlmacen()<-" + allParamss.size() + "-" +  allParamss.values());
        Almacen nuevoAlmacen = new Almacen();
        nuevoAlmacen.setNombreAlmacen(allParamss.get("nombreAlmacen"));
        nuevoAlmacen.setDireccion(allParamss.get("direccion"));
        nuevoAlmacen.setCapacidad(Double.parseDouble(allParamss.get("capacidad")));
        
        System.out.println("Saving almacen");
        nuevoAlmacen = almacenRepository.save(nuevoAlmacen);
        System.out.println("SaveAlmacen()->");
        return nuevoAlmacen != null ? 1:0;
    }
}
