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
public class Indicacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idIndicacion;
    private Integer ordenIndicacion;
    private String detalleIndicacion;
    
    @ManyToOne
    @JoinColumn(name="fk_idPreparacionIndicacion")
    private Preparacion preparacion;

    public Indicacion(){}
    
    public Indicacion(Integer idIndicacion, Integer ordenIndicacion, String detalleIndicacion){
        this.idIndicacion = idIndicacion;
        this.ordenIndicacion = ordenIndicacion;
        this.detalleIndicacion = detalleIndicacion;
    }
    
    public Preparacion getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(Preparacion preparacion) {
        this.preparacion = preparacion;
    }
    
    public Integer getIdIndicacion() {
        return idIndicacion;
    }

    public void setIdIndicacion(Integer idIndicacion) {
        this.idIndicacion = idIndicacion;
    }

    public Integer getOrdenIndicacion() {
        return ordenIndicacion;
    }

    public void setOrdenIndicacion(Integer ordenIndicacion) {
        this.ordenIndicacion = ordenIndicacion;
    }

    public String getDetalleIndicacion() {
        return detalleIndicacion;
    }

    public void setDetalleIndicacion(String detalleIndicacion) {
        this.detalleIndicacion = detalleIndicacion;
    }
    
    
}
