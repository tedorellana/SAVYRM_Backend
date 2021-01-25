/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idOrdencompra;
    private String fechaRegistroOrdencompra;
    private Double precioTotalOrdencompra;
    
    @ManyToOne
    @JoinColumn(name="fk_idPersona")
    private Persona persona;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL)
    private Set<OrdenCompra> ordenCompra;
    
    public OrdenCompra(){}

    public Integer getIdOrdencompra() {
        return idOrdencompra;
    }

    public void setIdOrdencompra(Integer idOrdencompra) {
        this.idOrdencompra = idOrdencompra;
    }

    public String getFechaRegistroOrdencompra() {
        return fechaRegistroOrdencompra;
    }

    public void setFechaRegistroOrdencompra(String fechaRegistroOrdencompra) {
        this.fechaRegistroOrdencompra = fechaRegistroOrdencompra;
    }

    public Double getPrecioTotalOrdencompra() {
        return precioTotalOrdencompra;
    }

    public void setPrecioTotalOrdencompra(Double precioTotalOrdencompra) {
        this.precioTotalOrdencompra = precioTotalOrdencompra;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<OrdenCompra> getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Set<OrdenCompra> ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
}
