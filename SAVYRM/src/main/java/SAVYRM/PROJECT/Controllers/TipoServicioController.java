package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.TipoServicio;
import SAVYRM.PROJECT.Respositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/TipoServicio") 
public class TipoServicioController {
    @Autowired
    private TipoServicioRepository tipoServicioRepository;
    
    @GetMapping(path="/GetTipoServicio")
    public @ResponseBody Iterable<TipoServicio> GetAllTipoServicio()
    {
        System.out.println("GetTipoServicio()<-");
        System.out.println("GetTipoServicio()->");
        return tipoServicioRepository.findAll();
    }
}
