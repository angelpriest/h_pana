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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Carlos
 */
@MappedSuperclass
@Table(catalog = "h_pana", schema = "public")
@XmlRootElement
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_identificacion", nullable = false)
    private Integer noIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hr_inicial", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hrInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hr_final", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hrFinal;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Character estado;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medico medico;

    public Agenda() {
    }

    public Agenda(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Agenda(Integer noIdentificacion, Date hrInicial, Date hrFinal, Date fecha) {
        this.noIdentificacion = noIdentificacion;
        this.hrInicial = hrInicial;
        this.hrFinal = hrFinal;
        this.fecha = fecha;
    }

    public Integer getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Integer noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Date getHrInicial() {
        return hrInicial;
    }

    public void setHrInicial(Date hrInicial) {
        this.hrInicial = hrInicial;
    }

    public Date getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(Date hrFinal) {
        this.hrFinal = hrFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Agenda[ noIdentificacion=" + noIdentificacion + " ]";
    }
    
}
