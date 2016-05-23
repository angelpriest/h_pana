/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;
package org.primefaces.showcase.view.input;
 
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.annotation.ManagedBean;

/**
 *
 * @author angel rivera
 */

 
@ManagedBean
public class registro {
     
    private String id;
    private String nombre;
    private String apellido;
    private Date fcNacimiento;
    private int telefono;
    private int celular;
    private int edad;
    private String eMail;
    private String direccion;
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellido() {
        return apellido;
    }
 
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
 
    public Date getFcNacimiento() {
        return fcNacimiento;
    }
 
    public void setFcNacimiento(Date fcNacimiento) {
        this.fcNacimiento = fcNacimiento;
    }
 
    public int getTelefono() {
        return telefono;
    }
 
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
 
    public int getCelular() {
        return celular;
    }
 
    public void setCelular(int celular) {
        this.productKey = celular;
    }
}