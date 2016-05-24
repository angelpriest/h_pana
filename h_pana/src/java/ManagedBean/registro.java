/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

 
import javax.faces.bean.ManagedBean;


 
@ManagedBean
public class registro {
     
    private String id;
    private String nombre;
    private String apellido;
    private String fcNacimiento;
    private int telefono;
    private int celular;
    private int edad;
    private String correo;
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
 
    public String getFcNacimiento() {
        return fcNacimiento;
    }
 
    public void setFcNacimiento(String fcNacimiento) {
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
        this.celular = celular;
    }
    
    public int getEdad () {
        return edad;
    }
    
    public void setEdad (int edad) {
        this.edad = edad;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo=correo;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }
}