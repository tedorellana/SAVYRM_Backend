package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/ServicioProducto") 
public class ServicioProductoController {
    @Autowired
    private ServicioProductoRepository servicioProductoRepository;
    
    @GetMapping(path="/GetServicioProducto")
    public @ResponseBody Iterable<ServicioProducto> GetAllServicioProducto()
    {
        System.out.println("GetServicioProducto()<-");
        System.out.println("GetServicioProducto()->");
        return servicioProductoRepository.findAll();
    }
}
