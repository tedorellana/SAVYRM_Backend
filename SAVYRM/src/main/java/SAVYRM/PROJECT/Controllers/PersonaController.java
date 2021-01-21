package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.PersistentData;
import SAVYRM.PROJECT.Entities.Persona;
import SAVYRM.PROJECT.Respositories.PersonaRepository;
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
@RequestMapping(path="/Persona") 
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping(path="/GetPersona")
    public @ResponseBody Iterable<Persona> GetAllPersona()
    {
        System.out.println("GetPersona()");
        return personaRepository.findAll();
    }
    
    @GetMapping(path="/GetAllClients")
    public @ResponseBody Iterable<Persona> GetAllClients()
    {
        System.out.println("GetAllClients()");
        return personaRepository.findByUsuarioTipoUsuarioIdTipoUsuario(PersistentData.CLIENT_TYPE_ID);
    }
    
    @ResponseBody
    @PostMapping(path="/AddClient")
    public void AddClient(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("AddClient()<-" + allParamss.size() + "-" +  allParamss.values());
    }
}
