package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.TipoProducto;
import SAVYRM.PROJECT.Respositories.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/TipoProducto") 
public class TipoProductoController {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    
    @GetMapping(path="/GetAllTipoProducto")
    public @ResponseBody Iterable<TipoProducto> GetAllTipoProducto()
    {
        System.out.println("GetAllTipoProducto()<-");
        System.out.println("GetAllTipoProducto()->");
        return tipoProductoRepository.findAll();
    }
}
