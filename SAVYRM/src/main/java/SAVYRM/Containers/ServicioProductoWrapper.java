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
public class ServicioProductoWrapper {
    private Integer idServicioProductoSeccion;
    private Double costoTotal;
    private Double cantidadServicioProducto;
    private Boolean entregado;
    private String fechaEntrega;

    public Integer getIdServicioProductoSeccion() {
        return idServicioProductoSeccion;
    }

    public void setIdServicioProductoSeccion(Integer idServicioProductoSeccion) {
        this.idServicioProductoSeccion = idServicioProductoSeccion;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getCantidadServicioProducto() {
        return cantidadServicioProducto;
    }

    public void setCantidadServicioProducto(Double cantidadServicioProducto) {
        this.cantidadServicioProducto = cantidadServicioProducto;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
}
