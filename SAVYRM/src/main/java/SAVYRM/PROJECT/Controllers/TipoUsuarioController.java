package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.TipoUsuario;
import SAVYRM.PROJECT.Respositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/TipoUsuario") 
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    
    @GetMapping(path="/GetTipoUsuario")
    public @ResponseBody Iterable<TipoUsuario> GetAllTipoUsuario()
    {
        System.out.println("GetTipoUsuario()<-");
        System.out.println("GetTipoUsuario()->");
        return tipoUsuarioRepository.findAll();
    }
}
