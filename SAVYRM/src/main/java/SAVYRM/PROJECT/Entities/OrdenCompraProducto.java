package SAVYRM.PROJECT.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdenCompraProducto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idOrdercompraproducto;
    private String fechaEntregaPrevistaOrdenCompraProducto;
    private String fechaEntregaOrdenCompraProducto;
    private Double precioOrdenCompraProducto;
    private Double cantidadOrdenCompraProducto;
    private Double cantidadDisponibleOrdenCompraProducto;
    
    @ManyToOne
    @JoinColumn(name="fk_idProducto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="fk_idOrdenCompra")
    private OrdenCompra ordenCompra;
    
    public OrdenCompraProducto() {}

    public Integer getIdOrdercompraproducto() {
        return idOrdercompraproducto;
    }

    public void setIdOrdercompraproducto(Integer idOrdercompraproducto) {
        this.idOrdercompraproducto = idOrdercompraproducto;
    }

    public String getFechaEntregaPrevistaOrdenCompraProducto() {
        return fechaEntregaPrevistaOrdenCompraProducto;
    }

    public void setFechaEntregaPrevistaOrdenCompraProducto(String fechaEntregaPrevistaOrdenCompraProducto) {
        this.fechaEntregaPrevistaOrdenCompraProducto = fechaEntregaPrevistaOrdenCompraProducto;
    }

    public String getFechaEntregaOrdenCompraProducto() {
        return fechaEntregaOrdenCompraProducto;
    }

    public void setFechaEntregaOrdenCompraProducto(String fechaEntregaOrdenCompraProducto) {
        this.fechaEntregaOrdenCompraProducto = fechaEntregaOrdenCompraProducto;
    }

    public Double getPrecioOrdenCompraProducto() {
        return precioOrdenCompraProducto;
    }

    public void setPrecioOrdenCompraProducto(Double precioOrdenCompraProducto) {
        this.precioOrdenCompraProducto = precioOrdenCompraProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Double getCantidadOrdenCompraProducto() {
        return cantidadOrdenCompraProducto;
    }

    public void setCantidadOrdenCompraProducto(Double cantidadOrdenCompraProducto) {
        this.cantidadOrdenCompraProducto = cantidadOrdenCompraProducto;
    }

    public Double getCantidadDisponibleOrdenCompraProducto() {
        return cantidadDisponibleOrdenCompraProducto;
    }

    public void setCantidadDisponibleOrdenCompraProducto(Double cantidadDisponibleOrdenCompraProducto) {
        this.cantidadDisponibleOrdenCompraProducto = cantidadDisponibleOrdenCompraProducto;
    }
}
