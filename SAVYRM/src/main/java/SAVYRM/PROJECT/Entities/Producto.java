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
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    private String codigoProducto;
    private Integer estadoProducto;
    
    @ManyToOne
    @JoinColumn(name = "fk_idUnidadMedida")
    private UnidadMedida unidadMedida;
      
    @ManyToOne
    @JoinColumn(name = "fk_idTIpoProducto")
    private TipoProducto tipoProducto;
        
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Preparacion> preparacion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "productoElaborado", cascade = CascadeType.ALL)
    private Set<ProductoFormula> productoElaborado;
    
    @JsonIgnore
    @OneToMany(mappedBy = "productoInsumo", cascade = CascadeType.ALL)
    private Set<ProductoFormula> productoInsumo;
    
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<ProductoSeccion> productoSeccion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Precio> precio;
    
    public Producto(){}

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(Integer estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Set<Preparacion> getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(Set<Preparacion> preparacion) {
        this.preparacion = preparacion;
    }

    public Set<ProductoSeccion> getProductoSeccion() {
        return productoSeccion;
    }

    public void setProductoSeccion(Set<ProductoSeccion> productoSeccion) {
        this.productoSeccion = productoSeccion;
    }

    public Set<Precio> getPrecio() {
        return precio;
    }

    public void setPrecio(Set<Precio> precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Set<ProductoFormula> getProductoElaborado() {
        return productoElaborado;
    }

    public void setProductoElaborado(Set<ProductoFormula> productoElaborado) {
        this.productoElaborado = productoElaborado;
    }

    public Set<ProductoFormula> getProductoInsumo() {
        return productoInsumo;
    }

    public void setProductoInsumo(Set<ProductoFormula> productoInsumo) {
        this.productoInsumo = productoInsumo;
    }

    
}
