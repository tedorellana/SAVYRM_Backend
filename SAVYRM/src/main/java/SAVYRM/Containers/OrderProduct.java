/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.Containers;

/**
 *
 * @author TORELLANA
 */
public class OrderProduct {
    int idProducto;
    String nombreProducto;
    String unidadMedida;
    String fechaEntregaPrevistaOrdenCompraProducto;
    Double cantidadOrdenCompraProducto;
    Double precioOrdenCompraProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getFechaEntregaPrevistaOrdenCompraProducto() {
        return fechaEntregaPrevistaOrdenCompraProducto;
    }

    public void setFechaEntregaPrevistaOrdenCompraProducto(String fechaEntregaPrevistaOrdenCompraProducto) {
        this.fechaEntregaPrevistaOrdenCompraProducto = fechaEntregaPrevistaOrdenCompraProducto;
    }

    public Double getCantidadOrdenCompraProducto() {
        return cantidadOrdenCompraProducto;
    }

    public void setCantidadOrdenCompraProducto(Double cantidadOrdenCompraProducto) {
        this.cantidadOrdenCompraProducto = cantidadOrdenCompraProducto;
    }

    public Double getPrecioOrdenCompraProducto() {
        return precioOrdenCompraProducto;
    }

    public void setPrecioOrdenCompraProducto(Double precioOrdenCompraProducto) {
        this.precioOrdenCompraProducto = precioOrdenCompraProducto;
    }
    
    
}
