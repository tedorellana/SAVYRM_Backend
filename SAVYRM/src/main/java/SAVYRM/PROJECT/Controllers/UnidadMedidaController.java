package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.UnidadMedida;
import SAVYRM.PROJECT.Respositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/UnidadMedida") 
public class UnidadMedidaController {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    
    @GetMapping(path="/GetAllUnidadMedida")
    public @ResponseBody Iterable<UnidadMedida> GetAllUnidadMedida()
    {
        System.out.println("GetAllUnidadMedida()<-");
        System.out.println("GetAllUnidadMedida()->");
        return unidadMedidaRepository.findAll();
    }
}
