/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.Containers;

import java.util.List;

/**
 *
 * @author TORELLANA
 */
public class CarritoDeCompraWrapper {
    List<CarritoDeCompra> carritoDeCompras;
    
    DetallesServicio detallesServicio;
    
    public List<CarritoDeCompra> getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(List<CarritoDeCompra> carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public DetallesServicio getDetallesServicio() {
        return detallesServicio;
    }

    public void setDetallesServicio(DetallesServicio detallesServicio) {
        this.detallesServicio = detallesServicio;
    }
}
