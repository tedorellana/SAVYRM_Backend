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
public class ProductoSeccion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idProductoSeccion;
    private Double cantidadProductoSeccion;
    private String fechaIngreso;
    
    @ManyToOne
    @JoinColumn(name="fk_idLote")
    private Lote lote;
    
    @ManyToOne
    @JoinColumn(name="fk_idProducto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="fk_idSeccion")
    private Seccion seccion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "productoSeccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicioProducto> servicioProducto;
    
    public ProductoSeccion(){
        
    }
    
    public ProductoSeccion(Double cantidadProductoSeccion, String fechaIngreso){
        this.cantidadProductoSeccion = cantidadProductoSeccion;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdProductoSeccion() {
        return idProductoSeccion;
    }

    public void setIdProductoSeccion(Integer idProductoSeccion) {
        this.idProductoSeccion = idProductoSeccion;
    }

    public Double getCantidadProductoSeccion() {
        return cantidadProductoSeccion;
    }

    public void setCantidadProductoSeccion(Double cantidadProductoSeccion) {
        this.cantidadProductoSeccion = cantidadProductoSeccion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Set<ServicioProducto> getServicioProducto() {
        return servicioProducto;
    }

    public void setServicioProducto(Set<ServicioProducto> servicioProducto) {
        this.servicioProducto = servicioProducto;
    }
    
    
}
