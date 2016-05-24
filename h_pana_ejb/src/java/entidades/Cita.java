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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
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
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_cita", nullable = false)
    private Integer noCita;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Serializable fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Size(max = 3)
    @Column(length = 3)
    private String consultorio;
    @Size(max = 1)
    @Column(length = 1)
    private String estado;
    @JoinColumn(name = "medico", referencedColumnName = "no_identificacion", nullable = false)
    @ManyToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "paciente", referencedColumnName = "no_identificacion", nullable = false)
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
