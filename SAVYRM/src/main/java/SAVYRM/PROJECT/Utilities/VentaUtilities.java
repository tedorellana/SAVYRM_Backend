/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.PROJECT.Utilities;

/**
 *
 * @author TORELLANA
 */
public class VentaUtilities {
    
    // Calculate the new store after sell some units
    public static double CalculateNewStock(double currentStock, double unitsToSell)
    {
        if (currentStock < unitsToSell)
        {
            System.out.println("current stock is less than unitsToSell: " + currentStock + " : " + unitsToSell);
            return 0; // TODO: Should thrown an error
        }
        
        return currentStock - unitsToSell;
    }
    
    // Calculate the price per units sell
    public static double CalculatePrice(double unitsToSell, double price)
    {
        return unitsToSell * price;
    }
}
