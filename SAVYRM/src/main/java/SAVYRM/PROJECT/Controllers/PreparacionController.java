package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Preparacion;
import SAVYRM.PROJECT.Respositories.PreparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Preparacion") 
public class PreparacionController {
    @Autowired
    private PreparacionRepository preparacionRepository;
    
    @GetMapping(path="/GetPreparacion")
    public @ResponseBody Iterable<Preparacion> GetAllPreparacion()
    {
        System.out.println("GetPreparacion()<-");
        System.out.println("GetPreparacion()->");
        return preparacionRepository.findAll();
    }
}
