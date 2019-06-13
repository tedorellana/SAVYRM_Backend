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
import javax.persistence.OneToMany;

@Entity
public class Almacen {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idAlmacen;
    private String nombreAlmacen;
    private String direccion;
    private Double capacidad;
    
    @JsonIgnore
    @OneToMany(mappedBy = "almacen", cascade = CascadeType.ALL)
    private Set<Seccion> seccion;

    public Set<Seccion> getSeccion() {
        return seccion;
    }

    public void setSeccion(Set<Seccion> seccion) {
        this.seccion = seccion;
    }
    
    public Almacen(Integer idAlmacen, String nombreAlmacen, String direccion, Double capacidad, Seccion... seccion) {
        this.idAlmacen = idAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.seccion = Stream.of(seccion).collect(Collectors.toSet());
        this.seccion.forEach(x -> x.setAlmacen(this));
    }

    public Almacen(){}
    
    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }
}
