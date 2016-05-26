/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan Carlos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByNoCita", query = "SELECT c FROM Cita c WHERE c.noCita = :noCita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora"),
    @NamedQuery(name = "Cita.findByConsultorio", query = "SELECT c FROM Cita c WHERE c.consultorio = :consultorio"),
    @NamedQuery(name = "Cita.findByEstado", query = "SELECT c FROM Cita c WHERE c.estado = :estado")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_cita")
    private Integer noCita;
    @Basic(optional = false)
    @NotNull
    private Serializable fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Size(max = 3)
    private String consultorio;
    @Size(max = 1)
    private String estado;
    @JoinColumn(name = "medico", referencedColumnName = "no_identificacion")
    @ManyToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "paciente", referencedColumnName = "no_identificacion")
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Cita() {
    }

    public Cita(Integer noCita) {
        this.noCita = noCita;
    }

    public Cita(Integer noCita, Serializable fecha) {
        this.noCita = noCita;
        this.fecha = fecha;
    }

    public Integer getNoCita() {
        return noCita;
    }

    public void setNoCita(Integer noCita) {
        this.noCita = noCita;
    }

    public Serializable getFecha() {
        return fecha;
    }

    public void setFecha(Serializable fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCita != null ? noCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.noCita == null && other.noCita != null) || (this.noCita != null && !this.noCita.equals(other.noCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cita[ noCita=" + noCita + " ]";
    }
    
}
