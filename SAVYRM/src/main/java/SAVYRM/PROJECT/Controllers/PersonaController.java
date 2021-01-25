package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.PersistentData;
import SAVYRM.PROJECT.Entities.Persona;
import SAVYRM.PROJECT.Entities.TipoPersona;
import SAVYRM.PROJECT.Entities.TipoUsuario;
import SAVYRM.PROJECT.Entities.Usuario;
import SAVYRM.PROJECT.Respositories.PersonaRepository;
import SAVYRM.PROJECT.Respositories.UsuarioRepository;
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
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
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
    public Persona AddClient(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("AddClient()<-" + allParamss.size() + "-" +  allParamss.values());
        
        // Set Tipo Documento
        String tipoDocumento;
        if (allParamss.get("tipoDocumento").equals("2")) {
            tipoDocumento = PersistentData.RUC_TAG;
        }
        else
        {
            tipoDocumento = PersistentData.DNI_TAG;
        }
        
        // Set Tipo Persona
        int tipoPersona;
        if (allParamss.get("tipoPersona").equals("2")) {
            tipoPersona = PersistentData.PERSONA_JURIDICA_ID;
        }
        else
        {
            tipoPersona = PersistentData.PERSONA_NATURAL_ID;
        }
        
        System.out.println("TipoPersona to add " + tipoPersona );
        
        // Set tipo usuario cliente by default
        TipoPersona tipoPers = new TipoPersona();
        tipoPers.setIdTipoPersona(tipoPersona);
        
        Persona persona = new Persona();
        persona.setNombrePersona(allParamss.get("nombres"));
        persona.setApellidoPaternoPersona(allParamss.get("apellidoPaterno"));
        persona.setApellidoMaternoPersona(allParamss.get("apellidoMaterno"));
        persona.setDocumentoIdentidadPersona(tipoDocumento);
        persona.setNumeroDocumentoPersona(allParamss.get("numeroDocumento"));
        persona.setNumeroTelefonoPersona(allParamss.get("telefono"));
        persona.setCorreoPersona(allParamss.get("correo"));
        persona.setDireccionPersona(allParamss.get("dirrecion"));
        persona.setTipoPersona(tipoPers);        
        
        TipoUsuario tipoUsu = new TipoUsuario();
        tipoUsu.setIdTipoUsuario(PersistentData.TIPOUSUARIO_CLIENTE_ID);
        
        Persona clientAdded = personaRepository.save(persona);
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(allParamss.get("nombreUsuario"));
        usuario.setContrasenhaUsuario(allParamss.get("contrasenhaUsuario"));
        usuario.setTipoUsuario(tipoUsu);
        usuario.setPersona(clientAdded);
        usuarioRepository.save(usuario);
                
        return clientAdded;
    }
}
