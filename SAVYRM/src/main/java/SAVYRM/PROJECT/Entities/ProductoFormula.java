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
public class ProductoFormula {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idProductoFormula;
    private Double porcentaje;
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name = "fk_idProductoElaborado")
    private Producto productoElaborado;
    
    @ManyToOne
    @JoinColumn(name = "fk_idProductoInsumo")
    private Producto productoInsumo;
    
    @ManyToOne
    @JoinColumn(name = "fk_idFormula")
    private Formula formula;
    
    public ProductoFormula(){}

    public Integer getIdProductoFormula() {
        return idProductoFormula;
    }

    public void setIdProductoFormula(Integer idProductoFormula) {
        this.idProductoFormula = idProductoFormula;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductoElaborado() {
        return productoElaborado;
    }

    public void setProductoElaborado(Producto productoElaborado) {
        this.productoElaborado = productoElaborado;
    }

    public Producto getProductoInsumo() {
        return productoInsumo;
    }

    public void setProductoInsumo(Producto productoInsumo) {
        this.productoInsumo = productoInsumo;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
    
    
    
}
