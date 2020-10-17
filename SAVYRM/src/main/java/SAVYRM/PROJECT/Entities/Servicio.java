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
public class Servicio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idServicio;
    private String horaInicioServicio;
    private String horaFinServicio;
    private String horaEdicionServicio;
    
    @JsonIgnore
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicioProducto> servicioProducto;
    
    @ManyToOne
    @JoinColumn(name = "idPersonaAtendidaServicio")
    private Persona personaAtendida;
    
    @ManyToOne
    @JoinColumn(name = "idPersonaEmpleado")
    private Persona personaEmpleado;
    
    @ManyToOne
    @JoinColumn(name = "fk_idTipoServicio")
    private TipoServicio tipoServicio;
    
    public Servicio(){}

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getHoraInicioServicio() {
        return horaInicioServicio;
    }

    public void setHoraInicioServicio(String horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    public String getHoraFinServicio() {
        return horaFinServicio;
    }

    public void setHoraFinServicio(String horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    public String getHoraEdicionServicio() {
        return horaEdicionServicio;
    }

    public void setHoraEdicionServicio(String horaEdicionServicio) {
        this.horaEdicionServicio = horaEdicionServicio;
    }

    
    public Persona getPersonaAtendida() {
        return personaAtendida;
    }

    public void setPersonaAtendida(Persona personaAtendida) {
        this.personaAtendida = personaAtendida;
    }

    public Persona getPersonaEmpleado() {
        return personaEmpleado;
    }

    public void setPersonaEmpleado(Persona personaEmpleado) {
        this.personaEmpleado = personaEmpleado;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Set<ServicioProducto> getServicioProducto() {
        return servicioProducto;
    }

    public void setServicioProducto(Set<ServicioProducto> servicioProducto) {
        this.servicioProducto = servicioProducto;
    }
    
    
    
}
