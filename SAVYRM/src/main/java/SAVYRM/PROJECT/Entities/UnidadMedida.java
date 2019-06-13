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
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUnidadMedida;
    private String nombre;
    private Integer tipo;
    private String abreviacion;
    
    @ManyToOne
    @JoinColumn(name = "fk_idUnidadmedida")
    private UnidadMedida unidadMedidaBase;
    
    @JsonIgnore
    @OneToMany(mappedBy = "unidadMedidaBase", cascade = CascadeType.ALL)
    private Set<UnidadMedida> unidadMedida;
    
    @JsonIgnore
    @OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL)
    private Set<Producto> producto;
    
    public UnidadMedida(){}

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public UnidadMedida getUnidadMedidaBase() {
        return unidadMedidaBase;
    }

    public void setUnidadMedidaBase(UnidadMedida unidadMedidaBase) {
        this.unidadMedidaBase = unidadMedidaBase;
    }

    public Set<UnidadMedida> getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Set<UnidadMedida> unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    
}
