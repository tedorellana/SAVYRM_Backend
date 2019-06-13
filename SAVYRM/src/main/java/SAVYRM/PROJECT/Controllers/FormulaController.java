package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Formula;
import SAVYRM.PROJECT.Respositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/Formula") 
public class FormulaController {
    @Autowired
    private FormulaRepository formulaRepository;
    
    @GetMapping(path="/GetFormula")
    public @ResponseBody Iterable<Formula> GetAllFormula()
    {
        System.out.println("GetFormula()<-");
        System.out.println("GetFormula()->");
        return formulaRepository.findAll();
    }
}
