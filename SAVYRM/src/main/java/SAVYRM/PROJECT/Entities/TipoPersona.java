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
public class TipoPersona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTipoPersona;
    private String nombreTipoPersona;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tipoPersona", cascade = CascadeType.ALL)
    private Set<Persona> persona;
    
    public TipoPersona(){}

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public Set<Persona> getPersona() {
        return persona;
    }

    public void setPersona(Set<Persona> persona) {
        this.persona = persona;
    }
    
    
}
