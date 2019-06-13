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
public class Formula {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idFormula;
    private String nombreFormula;
    private String detalleFormula;
    
    @JsonIgnore
    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL)
    private Set<ProductoFormula> productoFormula;

    public Set<ProductoFormula> getProductoFormula() {
        return productoFormula;
    }

    public void setProductoFormula(Set<ProductoFormula> productoFormula) {
        this.productoFormula = productoFormula;
    }
    
    public Formula(Integer idFormula, String nombreFormula, String detalleFormula, ProductoFormula... productoFormula){
        this.idFormula = idFormula;
        this.nombreFormula = nombreFormula;
        this.detalleFormula = detalleFormula;
        this.productoFormula = Stream.of(productoFormula).collect(Collectors.toSet());
        this.productoFormula.forEach(x -> x.setFormula(this));
    }
    
    public Formula(){}

    public Integer getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(Integer idFormula) {
        this.idFormula = idFormula;
    }

    public String getNombreFormula() {
        return nombreFormula;
    }

    public void setNombreFormula(String nombreFormula) {
        this.nombreFormula = nombreFormula;
    }

    public String getDetalleFormula() {
        return detalleFormula;
    }

    public void setDetalleFormula(String detalleFormula) {
        this.detalleFormula = detalleFormula;
    }
    
    
}
