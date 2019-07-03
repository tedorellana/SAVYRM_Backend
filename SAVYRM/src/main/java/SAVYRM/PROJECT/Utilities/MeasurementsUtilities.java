package SAVYRM.PROJECT.Utilities;

import SAVYRM.PROJECT.Entities.ProductoFormula;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class MeasurementsUtilities {
    //base measurement gram
    final double gram = 1.0;
    final double liter = 1000.0;
    final double milliliters = 1;
    final double kilogram = 1000.0;
    
    
    public MeasurementsUtilities() {
    }
    
    ///TODO:This part should be reviwed in order to shown a real percent
    public static List<ProductoFormula> CalculatePercentOfProdudctsInvoledInFormula(ArrayList<ProductoFormula> productsInvolved, ProductoFormula productAdded){
        System.out.println("CalculatePercentOfProdudctsInvoledInFormula<-");
        List<ProductoFormula> result = new ArrayList<ProductoFormula>();
        double oldTotal = 0.0;
        double newTotal = 0.0;
        
        try
        {
            System.out.println("Reviewing old total" + productsInvolved.size());
            //for (ProductoFormula productInvolved : productsInvolved) {
            //ObjectMapper om = new ObjectMapper();
            
            for (int i = 0; i < productsInvolved.size(); i++) {
                System.out.println("Element: " + i);
                System.out.println("\t->" + productsInvolved.getClass() );
                System.out.println("\t->" + productsInvolved.get(i).getCantidad());
                //oldTotal += productsInvolved.get(i).getCantidad();
            }
            
            System.out.println("Old total:" + oldTotal);
            
            newTotal = oldTotal + productAdded.getCantidad();
            System.out.println("Adding new product to list");
            productsInvolved.add(productAdded);
            
            for (ProductoFormula productInvolved : productsInvolved) {
                ProductoFormula tempProductoFormula = new ProductoFormula();
                tempProductoFormula.setIdProductoFormula(productInvolved.getIdProductoFormula());
                tempProductoFormula.setCantidad(productInvolved.getCantidad());
                tempProductoFormula.setPorcentaje(productInvolved.getCantidad()*100/newTotal);
                result.add(tempProductoFormula);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
        
        System.out.println("CalculatePercentOfProdudctsInvoledInFormula<-" + result.size());
        return result;
    }
            
            
//    public enum 

    
}
