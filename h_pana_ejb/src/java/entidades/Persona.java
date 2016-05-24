/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Carlos
 */
@MappedSuperclass
@Table(catalog = "h_pana", schema = "public")
@XmlRootElement
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_identificacion", nullable = false)
    private Integer noIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String apellidos;
    @Column(name = "telefono_fijo")
    private Integer telefonoFijo;
    @Column(name = "telefono_celular")
    private Integer telefonoCelular;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fc_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fcNacimiento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "e_mail", length = 2147483647)
    private String eMail;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String direccion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Medico medico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Permisos permisos;

    public Persona() {
    }

    public Persona(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Persona(Integer noIdentificacion, String nombres, String apellidos, int edad, Date fcNacimiento) {
        this.noIdentificacion = noIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fcNacimiento = fcNacimiento;
    }

    public Integer getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(Integer telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public Integer getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(Integer telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFcNacimiento() {
        return fcNacimiento;
    }

    public void setFcNacimiento(Date fcNacimiento) {
        this.fcNacimiento = fcNacimiento;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noIdentificacion != null ? noIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ noIdentificacion=" + noIdentificacion + " ]";
    }
    
}
