package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Usuario;
import SAVYRM.PROJECT.Respositories.UsuarioRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Usuario") 
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping(path="/GetUsuario")
    public @ResponseBody Iterable<Usuario> GetAllUsuario()
    {
        System.out.println("GetAllUsuario()<-");
        System.out.println("GetAllUsuario()->");
        return usuarioRepository.findAll();
    }
    
    @PostMapping(path="/IniciarSesion")
    @ResponseBody
    public Optional<Usuario> IniciarSesion(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("IniciarSesion()<-" + allParamss.size() + "-" +  allParamss.get("nombreUsuario").getClass());
        System.out.println("IniciarSesion()->");
        return usuarioRepository.findUsuarioByNombreUsuarioAndContrasenhaUsuario(allParamss.get("nombreUsuario"), allParamss.get("contrasenhaUsuario"));
    }
    
    @GetMapping(path="/GetIniciarSesion")
    public @ResponseBody String GetIniciarSesion(@RequestParam String nombreUsuario, @RequestParam String contrasenhaUsuario)
    {
        System.out.println("IniciarSesion()<-" + nombreUsuario + "-" +  contrasenhaUsuario);
        System.out.println("IniciarSesion()->");
        return "funciona";
        //return usuarioRepository.findAll();
    }
}
