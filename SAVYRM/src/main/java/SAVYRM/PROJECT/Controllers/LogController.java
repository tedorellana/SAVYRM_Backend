package SAVYRM.PROJECT.Controllers;

import SAVYRM.PROJECT.Entities.Log;
import SAVYRM.PROJECT.Respositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/Log") 
public class LogController {
    @Autowired
    private LogRepository logRepository;
    
    @GetMapping(path="/GetLog")
    public @ResponseBody Iterable<Log> GetAllUsers()
    {
        System.out.println("GetLog()<-");
        System.out.println("GetLog()->");
        return logRepository.findAll();
    }
}
