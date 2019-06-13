/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.PROJECT.Entities;

import javax.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLog;
    private String Componente;
    private String Servicio;
    private String fecha;
    private String detalle;

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getComponente() {
        return Componente;
    }

    public void setComponente(String Componente) {
        this.Componente = Componente;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
