package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.ProductoFormula;
import SAVYRM.PROJECT.Respositories.ProductoFormulaRepository;
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
@RequestMapping(path="/ProductoFormula") 
public class ProductoFormulaController {
    @Autowired
    private ProductoFormulaRepository productoFormulaRepository;
    
    @GetMapping(path="/GetProductoFormula")
    public @ResponseBody Iterable<ProductoFormula> GetAllProductoFormula()
    {
        System.out.println("GetProductoFormula()<-");
        System.out.println("GetProductoFormula()->");
        return productoFormulaRepository.findAll();
    }
    
    @PostMapping(path="/GetAllProductoFormulaByIdProducto")
    @ResponseBody
    public Iterable<ProductoFormula> GetAllProductoFormulaByIdProducto(@RequestBody Map<String,String> allParamss)
    {
        System.out.println("GetAllProductoFormulaByIdProducto()<-");
        System.out.println("GetAllProductoFormulaByIdProducto()<-" + allParamss.size() + "-" +  allParamss.values());
        System.out.println("GetAllProductoFormulaByIdProducto()->");
        return productoFormulaRepository.findAllByProductoElaboradoIdProducto(  Integer.parseInt(allParamss.get("idProducto")));
    }
}
