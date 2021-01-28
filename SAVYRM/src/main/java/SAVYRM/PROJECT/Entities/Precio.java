package SAVYRM.PROJECT.Entities;

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

@Entity
public class Precio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPrecio;
    private Double unitarioPrecio;
    private String fechaInicioPrecio;
    private String fechaFinPrecio;
    private Double mayoriaPrecio;
    private Integer vigentePrecio;
    private Double cantidadMayoriaPrecio;
    
    @ManyToOne
    @JoinColumn(name="fk_idProducto")
    private Producto producto;
    
    public Precio(){}

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Double getUnitarioPrecio() {
        return unitarioPrecio;
    }

    public void setUnitarioPrecio(Double unitarioPrecio) {
        this.unitarioPrecio = unitarioPrecio;
    }

    public String getFechaInicioPrecio() {
        return fechaInicioPrecio;
    }

    public void setFechaInicioPrecio(String fechaInicioPrecio) {
        this.fechaInicioPrecio = fechaInicioPrecio;
    }

    public String getFechaFinPrecio() {
        return fechaFinPrecio;
    }

    public void setFechaFinPrecio(String fechaFinPrecio) {
        this.fechaFinPrecio = fechaFinPrecio;
    }

    public Double getMayoriaPrecio() {
        return mayoriaPrecio;
    }

    public void setMayoriaPrecio(Double mayoriaPrecio) {
        this.mayoriaPrecio = mayoriaPrecio;
    }

    public Integer getVigentePrecio() {
        return vigentePrecio;
    }

    public void setVigentePrecio(Integer vigentePrecio) {
        this.vigentePrecio = vigentePrecio;
    }

    public Double getCantidadMayoriaPrecio() {
        return cantidadMayoriaPrecio;
    }

    public void setCantidadMayoriaPrecio(Double cantidadMayoriaPrecio) {
        this.cantidadMayoriaPrecio = cantidadMayoriaPrecio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
