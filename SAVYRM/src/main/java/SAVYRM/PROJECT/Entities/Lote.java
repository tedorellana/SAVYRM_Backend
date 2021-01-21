package SAVYRM.PROJECT.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
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
public class Lote {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLote;
    private String codigoLote;
    private Double costoLote;
    private Double cantidadUnidadesLote;
    private String fechaCaducidadLote;
    
    @JsonIgnore
    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    private Set<ProductoSeccion> productoSeccion;

    public Lote()
    {
        //super();
    }
    
    public Lote(String codigoLote, Double costoLote, Double cantidadUnidadesLote, String fechaCaducacionLote, ProductoSeccion... productoSeccion) {
        this.codigoLote = codigoLote;
        this.costoLote = costoLote;
        this.cantidadUnidadesLote = cantidadUnidadesLote;
        this.fechaCaducidadLote = fechaCaducacionLote;
        this.productoSeccion = Stream.of(productoSeccion).collect(Collectors.toSet());
        this.productoSeccion.forEach(x -> x.setLote(this));
    }
    
    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public Double getCostoLote() {
        return costoLote;
    }

    public void setCostoLote(Double costoLote) {
        this.costoLote = costoLote;
    }

    public Double getCantidaUnidadesLote() {
        return cantidadUnidadesLote;
    }

    public void setCantidaUnidadesLote(Double cantidaUnidadesLote) {
        this.cantidadUnidadesLote = cantidaUnidadesLote;
    }

    public String getFechaCaducacionLote() {
        return fechaCaducidadLote;
    }

    public void setFechaCaducacionLote(String fechaCaducacionLote) {
        this.fechaCaducidadLote = fechaCaducacionLote;
    }

    public Set<ProductoSeccion> getProductoSeccion() {
        return productoSeccion;
    }

    public void setProductoSeccion(Set<ProductoSeccion> productoSeccion) {
        this.productoSeccion = productoSeccion;
    }
    
    
}
