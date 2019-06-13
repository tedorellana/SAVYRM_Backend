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
public class Seccion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSeccion;
    private String codigoSeccion;
    private Double capacidadSeccion;
    private String detalle;
    
    @JsonIgnore
    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private Set<ProductoSeccion> productoSeccion;
    
    @ManyToOne
    @JoinColumn(name = "fk_idAlmacen")
    private Almacen almacen;
    
    public Seccion(){}

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public Double getCapacidadSeccion() {
        return capacidadSeccion;
    }

    public void setCapacidadSeccion(Double capacidadSeccion) {
        this.capacidadSeccion = capacidadSeccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Set<ProductoSeccion> getProductoSeccion() {
        return productoSeccion;
    }

    public void setProductoSeccion(Set<ProductoSeccion> productoSeccion) {
        this.productoSeccion = productoSeccion;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    
    
}
