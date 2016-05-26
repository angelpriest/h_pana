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
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByPaciente", query = "SELECT p FROM Paciente p WHERE p.paciente = :paciente"),
    @NamedQuery(name = "Paciente.findByRefFamiliar", query = "SELECT p FROM Paciente p WHERE p.refFamiliar = :refFamiliar"),
    @NamedQuery(name = "Paciente.findByNoIdentificacion", query = "SELECT p FROM Paciente p WHERE p.noIdentificacion = :noIdentificacion")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2)
    private String paciente;
    @Column(name = "ref_familiar")
    private Integer refFamiliar;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_identificacion")
    private Integer noIdentificacion;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<HMedico> hMedicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Cita> citaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<MMetricas> mMetricasList;

    public Paciente() {
    }

    public Paciente(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Integer getRefFamiliar() {
        return refFamiliar;
    }

    public void setRefFamiliar(Integer refFamiliar) {
        this.refFamiliar = refFamiliar;
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

    public List<HMedico> getHMedicoList() {
        return hMedicoList;
    }

    public void setHMedicoList(List<HMedico> hMedicoList) {
        this.hMedicoList = hMedicoList;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public List<MMetricas> getMMetricasList() {
        return mMetricasList;
    }

    public void setMMetricasList(List<MMetricas> mMetricasList) {
        this.mMetricasList = mMetricasList;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Paciente[ noIdentificacion=" + noIdentificacion + " ]";
    }
    
}
