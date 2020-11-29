package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.PersistentData;
import SAVYRM.Containers.SalesReport;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Controller
@RequestMapping(path="/Report") 
public class ReportController {
    @Autowired
    private ServicioProductoRepository servicioProductoRepository;
    
    @GetMapping(path="/GetServicioProducto")
    public @ResponseBody Iterable<ServicioProducto> GetAllServicioProducto()
    {
        System.out.println("GetServicioProducto()<-");
        System.out.println("GetServicioProducto()->");
        return servicioProductoRepository.findAll();
    }
    
    @GetMapping(path="/GetAllSales")
    public @ResponseBody Iterable<SalesReport> GetAllSales()
    {
        System.out.println("GetAllSales()");
        return servicioProductoRepository.findAllSales(PersistentData.VENTA_IDSERVICIO);
    }
    
    @GetMapping(path="/GetRevenuePerDay")
    public @ResponseBody Iterable<SalesReport> GetRevenuePerDay()
    {
        System.out.println("GetRevenuePerDay()");
        return servicioProductoRepository.findRevenuePerDay(PersistentData.VENTA_IDSERVICIO);
    }
    
    @GetMapping(path="/GetRevenuePerProduct")
    public @ResponseBody Iterable<SalesReport> GetRevenuePerProduct()
    {
        System.out.println("GetRevenuePerProduct()");
        return servicioProductoRepository.findRevenuePerProduct(PersistentData.VENTA_IDSERVICIO);
    }
    
    @GetMapping(path="/GetSalesAtendedPerEmployee")
    public @ResponseBody Iterable<SalesReport> GetSalesAtendedPerEmployee()
    {
        System.out.println("GetSalesAtendedPerClient()");
        return servicioProductoRepository.findSalesAtendedPerEmployeee(PersistentData.VENTA_IDSERVICIO);
    }
    
}
