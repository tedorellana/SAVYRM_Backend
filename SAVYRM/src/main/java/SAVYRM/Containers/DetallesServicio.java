/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.Containers;

/**
 *
 * @author TORELLANA
 */
public class DetallesServicio {
    
    public int idEmpleado;
    
    public int idCliente;
    
    public String dateTimeServiceBegin; 

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDateTimeServiceBegin() {
        return dateTimeServiceBegin;
    }

    public void setDateTimeServiceBegin(String dateTimeServiceBegin) {
        this.dateTimeServiceBegin = dateTimeServiceBegin;
    }
}
