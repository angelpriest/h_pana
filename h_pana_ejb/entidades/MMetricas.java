/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Juan Carlos
 */
@Entity
@Table(name = "m_metricas")
@NamedQueries({
    @NamedQuery(name = "MMetricas.findAll", query = "SELECT m FROM MMetricas m"),
    @NamedQuery(name = "MMetricas.findByPeso", query = "SELECT m FROM MMetricas m WHERE m.peso = :peso"),
    @NamedQuery(name = "MMetricas.findByAltura", query = "SELECT m FROM MMetricas m WHERE m.altura = :altura"),
    @NamedQuery(name = "MMetricas.findByPresion", query = "SELECT m FROM MMetricas m WHERE m.presion = :presion"),
    @NamedQuery(name = "MMetricas.findByTrigliceridos", query = "SELECT m FROM MMetricas m WHERE m.trigliceridos = :trigliceridos"),
    @NamedQuery(name = "MMetricas.findByColesterol", query = "SELECT m FROM MMetricas m WHERE m.colesterol = :colesterol"),
    @NamedQuery(name = "MMetricas.findByGlicemia", query = "SELECT m FROM MMetricas m WHERE m.glicemia = :glicemia"),
    @NamedQuery(name = "MMetricas.findByTiroides", query = "SELECT m FROM MMetricas m WHERE m.tiroides = :tiroides"),
    @NamedQuery(name = "MMetricas.findByCreistina", query = "SELECT m FROM MMetricas m WHERE m.creistina = :creistina"),
    @NamedQuery(name = "MMetricas.findByFcActualiza", query = "SELECT m FROM MMetricas m WHERE m.mMetricasPK.fcActualiza = :fcActualiza"),
    @NamedQuery(name = "MMetricas.findByColesterolHdi", query = "SELECT m FROM MMetricas m WHERE m.colesterolHdi = :colesterolHdi"),
    @NamedQuery(name = "MMetricas.findByNoIdentificacion", query = "SELECT m FROM MMetricas m WHERE m.mMetricasPK.noIdentificacion = :noIdentificacion")})
public class MMetricas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MMetricasPK mMetricasPK;
    private Integer peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal altura;
    private BigDecimal presion;
    private BigDecimal trigliceridos;
    private BigDecimal colesterol;
    private BigDecimal glicemia;
    private BigDecimal tiroides;
    private BigDecimal creistina;
    @Column(name = "colesterol_hdi")
    private BigDecimal colesterolHdi;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public MMetricas() {
    }

    public MMetricas(MMetricasPK mMetricasPK) {
        this.mMetricasPK = mMetricasPK;
    }

    public MMetricas(Date fcActualiza, int noIdentificacion) {
        this.mMetricasPK = new MMetricasPK(fcActualiza, noIdentificacion);
    }

    public MMetricasPK getMMetricasPK() {
        return mMetricasPK;
    }

    public void setMMetricasPK(MMetricasPK mMetricasPK) {
        this.mMetricasPK = mMetricasPK;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPresion() {
        return presion;
    }

    public void setPresion(BigDecimal presion) {
        this.presion = presion;
    }

    public BigDecimal getTrigliceridos() {
        return trigliceridos;
    }

    public void setTrigliceridos(BigDecimal trigliceridos) {
        this.trigliceridos = trigliceridos;
    }

    public BigDecimal getColesterol() {
        return colesterol;
    }

    public void setColesterol(BigDecimal colesterol) {
        this.colesterol = colesterol;
    }

    public BigDecimal getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(BigDecimal glicemia) {
        this.glicemia = glicemia;
    }

    public BigDecimal getTiroides() {
        return tiroides;
    }

    public void setTiroides(BigDecimal tiroides) {
        this.tiroides = tiroides;
    }

    public BigDecimal getCreistina() {
        return creistina;
    }

    public void setCreistina(BigDecimal creistina) {
        this.creistina = creistina;
    }

    public BigDecimal getColesterolHdi() {
        return colesterolHdi;
    }

    public void setColesterolHdi(BigDecimal colesterolHdi) {
        this.colesterolHdi = colesterolHdi;
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
        hash += (mMetricasPK != null ? mMetricasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMetricas)) {
            return false;
        }
        MMetricas other = (MMetricas) object;
        if ((this.mMetricasPK == null && other.mMetricasPK != null) || (this.mMetricasPK != null && !this.mMetricasPK.equals(other.mMetricasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MMetricas[ mMetricasPK=" + mMetricasPK + " ]";
    }
    
}
