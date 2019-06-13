package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.TipoPersona;
import SAVYRM.PROJECT.Respositories.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/TipoPersona") 
public class TipoPersonaController {
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;
    
    @GetMapping(path="/GetTipoPersona")
    public @ResponseBody Iterable<TipoPersona> GetAllTipoPersona()
    {
        System.out.println("GetTipoPersona()<-");
        System.out.println("GetTipoPersona()->");
        return tipoPersonaRepository.findAll();
    }
}
