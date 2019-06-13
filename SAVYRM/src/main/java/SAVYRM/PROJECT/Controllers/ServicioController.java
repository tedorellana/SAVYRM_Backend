package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Servicio;
import SAVYRM.PROJECT.Entities.Usuario;
import SAVYRM.PROJECT.Respositories.ServicioRepository;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Servicio") 
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;
    
    @GetMapping(path="/GetServicio")
    public @ResponseBody Iterable<Servicio> GetAllServicio()
    {
        System.out.println("GetServicio()<-");
        System.out.println("GetServicio()->");
        return servicioRepository.findAll();
    }
    
    @GetMapping(path="/FindByID")
    public @ResponseBody Optional<Servicio> FindByID()
    {
        System.out.println("FindByID()<-");
        System.out.println("FindByID()->");
        return servicioRepository.findById(1);
    }
    
    @GetMapping(path="/findByHoraFinServicio")
    public @ResponseBody Iterable<Servicio> findByHoraFinServicio()
    {
        System.out.println("findByHoraFinServicio()<-");
        
        List<Servicio> servicios =  servicioRepository.findByHoraFinServicio("2017-07-02 22:04:55.753000");
        
        for (Servicio serv : servicios){
            System.out.println(serv.getIdServicio());
        }
        
        System.out.println("findByHoraFinServicio()->");
        return servicioRepository.findAll();
    }
    
    @PostMapping(path="/GetVentasPorPersona")
    @ResponseBody
    public List<Servicio> GetVentasPorPersona(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("GetVentasPorPersona()<-" + allParamss.size() + "-" +  allParamss.values());
        System.out.println("GetVentasPorPersona()->");
        //Should be replaced to get ID from data base
        int idVentas = 2;
        return servicioRepository.findByTipoServicioIdTipoServicio(idVentas);
    }
}
