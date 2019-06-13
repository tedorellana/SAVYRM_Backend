package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Persona;
import SAVYRM.PROJECT.Respositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/Persona") 
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping(path="/GetPersona")
    public @ResponseBody Iterable<Persona> GetAllPersona()
    {
        System.out.println("GetPersona()<-");
        System.out.println("GetPersona()->");
        return personaRepository.findAll();
    }
}
