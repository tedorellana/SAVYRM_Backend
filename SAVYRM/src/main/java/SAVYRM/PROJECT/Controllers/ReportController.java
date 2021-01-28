package SAVYRM.PROJECT.Controllers;

import SAVYRM.Containers.DashboardStatus;
import SAVYRM.Containers.DataForComparedGraphic;
import SAVYRM.Containers.GraphicNode;
import SAVYRM.Containers.PersistentData;
import SAVYRM.Containers.LabelAndNodeReport;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import SAVYRM.PROJECT.Respositories.ServicioProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody Iterable<LabelAndNodeReport> GetAllSales(@RequestBody Map<String,String> allParams)
    {
        System.out.println("GetAllSales()");
        return servicioProductoRepository.findAllSales(PersistentData.VENTA_IDSERVICIO);
    }
    
    @GetMapping(path="/GetRevenuePerDay")
    public @ResponseBody Iterable<LabelAndNodeReport> GetRevenuePerDay()
    {
        System.out.println("GetRevenuePerDay()");
        return servicioProductoRepository.findRevenuePerDay(PersistentData.VENTA_IDSERVICIO, "2015-07-02 22:04:47.153000", "2021-07-02 22:04:47.153000");
    }
    
    @GetMapping(path="/GetRevenuePerProduct")
    public @ResponseBody Iterable<LabelAndNodeReport> GetRevenuePerProduct()
    {
        System.out.println("GetRevenuePerProduct()");
        return servicioProductoRepository.findRevenuePerProduct(PersistentData.VENTA_IDSERVICIO);
    }
    
    @GetMapping(path="/GetSalesAtendedPerEmployee")
    public @ResponseBody Iterable<LabelAndNodeReport> GetSalesAtendedPerEmployee()
    {
        System.out.println("GetSalesAtendedPerClient()");
        return servicioProductoRepository.findSalesAtendedPerEmployeee(PersistentData.VENTA_IDSERVICIO);
    }
    
    // Get the revenue per day compared with the average
    @GetMapping(path="/RevenueStatusCompared")
    public @ResponseBody DataForComparedGraphic RevenueStatusCompared()
    {
        System.out.println("RevenueStatusCompared()");
        DataForComparedGraphic result = new DataForComparedGraphic();
        
        List<LabelAndNodeReport> graphicCurrentNodes = servicioProductoRepository.findRevenuePerDay(PersistentData.VENTA_IDSERVICIO, "2015-07-02 22:04:47.153000", "2021-07-02 22:04:47.153000");
        result.setCurrentLine(graphicCurrentNodes);
        
        ArrayList<GraphicNode> graphicAverageNodes = new ArrayList<>();
        
        if (graphicCurrentNodes.isEmpty()) {
            System.out.println("baseLine for graphics cannot be empty");
            return null;
        }
        
        // Calculate average
        double summatory = 0.0;
        double average = 0.0;
        
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            summatory += sr.getY();
        }
        average = summatory / graphicCurrentNodes.size();
        System.out.println("average -> " + average);
        
        // Prepare base line with the average value
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
            GraphicNode gn = new GraphicNode();
            gn.setLabel(sr.getLabel());
            gn.setY(average);
            graphicAverageNodes.add(gn);
        }
        System.out.println("graphicAverageNodes size: " + graphicAverageNodes.size());
        
        // Setting the average to print in the graphic an horizontal line to compare
        result.setBaseLine(graphicAverageNodes);
        
        return result;
    }
    
    @GetMapping(path="/SalesStatusCompared")
    public @ResponseBody DataForComparedGraphic SalesStatusCompared()
    {
        System.out.println("SalesStatusCompared()");
        DataForComparedGraphic result = new DataForComparedGraphic();
        
        List<LabelAndNodeReport> graphicCurrentNodes = servicioProductoRepository.findSalesAveragePerDay(PersistentData.VENTA_IDSERVICIO);
        result.setCurrentLine(graphicCurrentNodes);
        
        ArrayList<GraphicNode> graphicAverageNodes = new ArrayList<>();
        
        if (graphicCurrentNodes.isEmpty()) {
            System.out.println("baseLine for graphics cannot be empty");
            return null;
        }
        
        // Calculate average
        double summatory = 0.0;
        double average = 0.0;
        
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            summatory += sr.getY();
        }
        average = summatory / graphicCurrentNodes.size();
        System.out.println("average -> " + average);
        
        // Prepare base line with the average value
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
            GraphicNode gn = new GraphicNode();
            gn.setLabel(sr.getLabel());
            gn.setY(average);
            graphicAverageNodes.add(gn);
        }
        System.out.println("graphicAverageNodes size: " + graphicAverageNodes.size());
        
        // Setting the average to print in the graphic an horizontal line to compare
        result.setBaseLine(graphicAverageNodes);
        
        return result;
    }
    
    // Get the sale status compared in 2 node: current and expected
    @GetMapping(path="/SimpleSalesStatusCompared")
    public @ResponseBody DashboardStatus SimpleSalesStatusCompared()
    {
        System.out.println("SimpleSalesStatusCompared()");
        DashboardStatus result = new DashboardStatus();
        
        List<LabelAndNodeReport> graphicCurrentNodes = servicioProductoRepository.findSalesAveragePerDay(PersistentData.VENTA_IDSERVICIO);
                
        if (graphicCurrentNodes.isEmpty()) {
            System.out.println("baseLine for graphics cannot be empty");
            return null;
        }
        
        // Calculate average
        double summatory = 0.0;
        double average = 0.0;
        
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            summatory += sr.getY();
        }
        average = summatory / graphicCurrentNodes.size();
        System.out.println("average -> " + average);
        
        // Get the the today's node
        LabelAndNodeReport sr = graphicCurrentNodes.get(graphicCurrentNodes.size() - 1);
        System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
        GraphicNode gn = new GraphicNode();
        gn.setLabel(sr.getLabel());
        gn.setY(sr.getY());
        result.setCurrent(gn);
        
        // Prepare base line with the average value
        sr = graphicCurrentNodes.get(0);
        System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
        gn = new GraphicNode();
        gn.setLabel(sr.getLabel());
        gn.setY(average);
        result.setExpected(gn);      
        
        return result;
    }
    
    // Get the sale status compared in 2 node: current and expected
    @GetMapping(path="/SimpleRevenueStatusCompared")
    public @ResponseBody DashboardStatus SimpleRevenueStatusCompared()
    {
        System.out.println("SimpleRevenueStatusCompared()");
        DashboardStatus result = new DashboardStatus();
        
        List<LabelAndNodeReport> graphicCurrentNodes = servicioProductoRepository.findRevenuePerDay(PersistentData.VENTA_IDSERVICIO, "2015-07-02 22:04:47.153000", "2021-07-02 22:04:47.153000");
                
        if (graphicCurrentNodes.isEmpty()) {
            System.out.println("baseLine for graphics cannot be empty");
            return null;
        }
        
        // Calculate average
        double summatory = 0.0;
        double average = 0.0;
        
        for (LabelAndNodeReport sr : graphicCurrentNodes){
            summatory += sr.getY();
        }
        average = summatory / graphicCurrentNodes.size();
        System.out.println("average -> " + average);
        
        // Get the the today's node
        LabelAndNodeReport sr = graphicCurrentNodes.get(graphicCurrentNodes.size() - 1);
        System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
        GraphicNode gn = new GraphicNode();
        gn.setLabel(sr.getLabel());
        gn.setY(sr.getY()); 
        result.setCurrent(gn);
        
        // Prepare base line with the average value
        sr = graphicCurrentNodes.get(0);
        System.out.println("sr label -> " + sr.getLabel() + " Y ->" + sr.getY());
        gn = new GraphicNode();
        gn.setLabel(sr.getLabel());
        gn.setY(average);
        result.setExpected(gn);      
        
        return result;
    }
}
