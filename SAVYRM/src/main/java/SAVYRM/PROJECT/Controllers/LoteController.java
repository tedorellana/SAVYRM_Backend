package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Lote;
import SAVYRM.PROJECT.Respositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/Lote") 
public class LoteController {
    @Autowired
    private LoteRepository loteRepository;
    
    @GetMapping(path="/GetAllLote")
    public @ResponseBody Iterable<Lote> GetAllLote()
    {
        System.out.println("GetAllLote()<-");
        System.out.println("GetAllLote()->");
        return loteRepository.findAll();
    }
}
