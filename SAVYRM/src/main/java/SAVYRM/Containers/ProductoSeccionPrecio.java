/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.Containers;
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
import javax.persistence.Entity;

/**
 *
 * @author TORELLANA
 */
@Entity
public class ProductoSeccionPrecio {
    @Id
    private Integer idProductoSeccion;


    public Integer getIdProductoSeccion() {
        return idProductoSeccion;
    }

    public void setIdProductoSeccion(Integer idProductoSeccion) {
        this.idProductoSeccion = idProductoSeccion;
    }

}
