package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Precio;
import SAVYRM.PROJECT.Respositories.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    
//    @GetMapping(path="/GetPrecio")
//    public @ResponseBody Iterable<Precio> GetAllPrecio()
//    {
//        System.out.println("GetPrecio()<-");
//        System.out.println("GetPrecio()->");
//        return precioRepository.findAll();
//    }
}
