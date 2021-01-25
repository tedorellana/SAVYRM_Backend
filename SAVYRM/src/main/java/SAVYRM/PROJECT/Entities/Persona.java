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
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPaternoPersona;
    private String apellidoMaternoPersona;
    private String documentoIdentidadPersona;
    private String numeroDocumentoPersona;
    private String numeroTelefonoPersona;
    private String correoPersona;
    private String direccionPersona;
    
    @ManyToOne
    @JoinColumn(name="fk_idTipoPersona")
    private TipoPersona tipoPersona;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Usuario> usuario;
    
    @JsonIgnore
    @OneToMany(mappedBy = "personaAtendida", cascade = CascadeType.ALL)
    private Set<Servicio> personaAtendida;
    
    @JsonIgnore
    @OneToMany(mappedBy = "personaEmpleado", cascade = CascadeType.ALL)
    private Set<Servicio> personaEmpleado;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<OrdenCompra> ordenCompra;
    
    public Persona(){}

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<Servicio> getPersonaAtendida() {
        return personaAtendida;
    }

    public void setPersonaAtendida(Set<Servicio> personaAtendida) {
        this.personaAtendida = personaAtendida;
    }

    public Set<Servicio> getPersonaEmpleado() {
        return personaEmpleado;
    }

    public void setPersonaEmpleado(Set<Servicio> personaEmpleado) {
        this.personaEmpleado = personaEmpleado;
    }
    
//    public Persona(Integer idPersona, String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona, String documentoIdentidadPersona, String numeroDocumentoPersona, String numeroTelefonoPersona, String correoPersona, String direccionPersona, TipoPersona... tipoPersona){
//        this.idPersona = idPersona;
//        this.nombrePersona = nombrePersona;
//        this.apellidoPaternoPersona = apellidoPaternoPersona;
//        this.apellidoMaternoPersona = apellidoMaternoPersona;
//        this.documentoIdentidadPersona = documentoIdentidadPersona;
//        this.numeroDocumentoPersona = numeroDocumentoPersona;
//        this.numeroTelefonoPersona = numeroTelefonoPersona;
//        this.correoPersona = correoPersona;
//        this.direccionPersona = direccionPersona;
//    }
//
//    public Persona(Integer idPersona, String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona, String documentoIdentidadPersona, String numeroDocumentoPersona, String numeroTelefonoPersona, String correoPersona, String direccionPersona, Usuario... usuario){
//        this.idPersona = idPersona;
//        this.nombrePersona = nombrePersona;
//        this.apellidoPaternoPersona = apellidoPaternoPersona;
//        this.apellidoMaternoPersona = apellidoMaternoPersona;
//        this.documentoIdentidadPersona = documentoIdentidadPersona;
//        this.numeroDocumentoPersona = numeroDocumentoPersona;
//        this.numeroTelefonoPersona = numeroTelefonoPersona;
//        this.correoPersona = correoPersona;
//        this.direccionPersona = direccionPersona;
//        this.usuario = usuario;
//        this.personaAtendida = personaAtendida;
//        this.personaEmpleado ;
//    }
//    
//    public Persona(Integer idPersona, String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona, String documentoIdentidadPersona, String numeroDocumentoPersona, String numeroTelefonoPersona, String correoPersona, String direccionPersona, Servicio... personaAtendida){
//        this.idPersona = idPersona;
//        this.nombrePersona = nombrePersona;
//        this.apellidoPaternoPersona = apellidoPaternoPersona;
//        this.apellidoMaternoPersona = apellidoMaternoPersona;
//        this.documentoIdentidadPersona = documentoIdentidadPersona;
//        this.numeroDocumentoPersona = numeroDocumentoPersona;
//        this.numeroTelefonoPersona = numeroTelefonoPersona;
//        this.correoPersona = correoPersona;
//        this.direccionPersona = direccionPersona;
//        this.tipoPersona = tipoPersona;
//        this.usuario = usuario;
//        this.personaAtendida = personaAtendida;
//        this.personaEmpleado ;
//    }
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPaternoPersona() {
        return apellidoPaternoPersona;
    }

    public void setApellidoPaternoPersona(String apellidoPaternoPersona) {
        this.apellidoPaternoPersona = apellidoPaternoPersona;
    }

    public String getApellidoMaternoPersona() {
        return apellidoMaternoPersona;
    }

    public void setApellidoMaternoPersona(String apellidoMaternoPersona) {
        this.apellidoMaternoPersona = apellidoMaternoPersona;
    }

    public String getDocumentoIdentidadPersona() {
        return documentoIdentidadPersona;
    }

    public void setDocumentoIdentidadPersona(String documentoIdentidadPersona) {
        this.documentoIdentidadPersona = documentoIdentidadPersona;
    }

    public String getNumeroDocumentoPersona() {
        return numeroDocumentoPersona;
    }

    public void setNumeroDocumentoPersona(String numeroDocumentoPersona) {
        this.numeroDocumentoPersona = numeroDocumentoPersona;
    }

    public String getNumeroTelefonoPersona() {
        return numeroTelefonoPersona;
    }

    public void setNumeroTelefonoPersona(String numeroTelefonoPersona) {
        this.numeroTelefonoPersona = numeroTelefonoPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }
    
    
}
