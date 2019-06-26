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
public class ServicioProducto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idServicioProductoSeccion;
    private Double costoTotal;
    private Double cantidadServicioProducto;
    
    @ManyToOne
    @JoinColumn(name = "fk_idProductoSeccion")
    private ProductoSeccion productoSeccion;
    
    @ManyToOne
    @JoinColumn(name = "fk_idServicio")
    private Servicio servicio;
    
    public ServicioProducto(){}

    public Integer getIdServicioProductoSeccion() {
        return idServicioProductoSeccion;
    }

    public void setIdServicioProductoSeccion(Integer idServicioProductoSeccion) {
        this.idServicioProductoSeccion = idServicioProductoSeccion;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getCantidadServicioProducto() {
        return cantidadServicioProducto;
    }

    public void setCantidadServicioProducto(Double cantidadServicioProducto) {
        this.cantidadServicioProducto = cantidadServicioProducto;
    }
    
    
}