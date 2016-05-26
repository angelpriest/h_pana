/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan Carlos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByArea", query = "SELECT m FROM Medico m WHERE m.area = :area"),
    @NamedQuery(name = "Medico.findByEspecialidad", query = "SELECT m FROM Medico m WHERE m.especialidad = :especialidad"),
    @NamedQuery(name = "Medico.findByNoIdentificacion", query = "SELECT m FROM Medico m WHERE m.noIdentificacion = :noIdentificacion")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    private String area;
    @Size(max = 2147483647)
    private String especialidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_identificacion")
    private Integer noIdentificacion;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medico")
    private Agenda agenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<Cita> citaList;

    public Medico() {
    }

    public Medico(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Medico[ noIdentificacion=" + noIdentificacion + " ]";
    }
    
}
