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
public class PurchaseOrderWrapper {
    
    Integer proveedorId;
    
    String fechaRegistroOrdencompra;
    
    Double precioTotalOrdencompra;
    
    List<OrderProduct> productosNewOrderList;

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getFechaRegistroOrdencompra() {
        return fechaRegistroOrdencompra;
    }

    public void setFechaRegistroOrdencompra(String fechaRegistroOrdencompra) {
        this.fechaRegistroOrdencompra = fechaRegistroOrdencompra;
    }

    public Double getPrecioTotalOrdencompra() {
        return precioTotalOrdencompra;
    }

    public void setPrecioTotalOrdencompra(Double precioTotalOrdencompra) {
        this.precioTotalOrdencompra = precioTotalOrdencompra;
    }

    public List<OrderProduct> getProductosNewOrderList() {
        return productosNewOrderList;
    }

    public void setProductosNewOrderList(List<OrderProduct> productosNewOrderList) {
        this.productosNewOrderList = productosNewOrderList;
    }
}
