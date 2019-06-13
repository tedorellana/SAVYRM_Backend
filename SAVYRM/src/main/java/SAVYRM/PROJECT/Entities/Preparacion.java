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
public class Preparacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPreparacion;
    private String nombrePreparacion;
    private String fechaCreacionPreparacion;
    private String detalleAdicionalPreparacion;
    
    @ManyToOne
    @JoinColumn(name="fk_idProducto")
    private Producto producto;
    
    @JsonIgnore
    @OneToMany(mappedBy = "preparacion", cascade = CascadeType.ALL)
    private Set<Indicacion> indicacion; 
    
    public Preparacion(){}

    public Integer getIdPreparacion() {
        return idPreparacion;
    }

    public void setIdPreparacion(Integer idPreparacion) {
        this.idPreparacion = idPreparacion;
    }

    public String getNombrePreparacion() {
        return nombrePreparacion;
    }

    public void setNombrePreparacion(String nombrePreparacion) {
        this.nombrePreparacion = nombrePreparacion;
    }

    public String getFechaCreacionPreparacion() {
        return fechaCreacionPreparacion;
    }

    public void setFechaCreacionPreparacion(String fechaCreacionPreparacion) {
        this.fechaCreacionPreparacion = fechaCreacionPreparacion;
    }

    public String getDetalleAdicionalPreparacion() {
        return detalleAdicionalPreparacion;
    }

    public void setDetalleAdicionalPreparacion(String detalleAdicionalPreparacion) {
        this.detalleAdicionalPreparacion = detalleAdicionalPreparacion;
    }

    public Set<Indicacion> getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(Set<Indicacion> indicacion) {
        this.indicacion = indicacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
