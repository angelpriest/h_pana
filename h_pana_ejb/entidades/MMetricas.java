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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Carlos
 */
@MappedSuperclass
@Table(name = "m_metricas", catalog = "h_pana", schema = "public")
@XmlRootElement
public class MMetricas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MMetricasPK mMetricasPK;
    private Integer peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 2, scale = 2)
    private BigDecimal altura;
    @Column(precision = 3, scale = 2)
    private BigDecimal presion;
    @Column(precision = 3, scale = 2)
    private BigDecimal trigliceridos;
    @Column(precision = 3, scale = 2)
    private BigDecimal colesterol;
    @Column(precision = 3, scale = 2)
    private BigDecimal glicemia;
    @Column(precision = 3, scale = 2)
    private BigDecimal tiroides;
    @Column(precision = 3, scale = 2)
    private BigDecimal creistina;
    @Column(name = "colesterol_hdi", precision = 3, scale = 2)
    private BigDecimal colesterolHdi;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", nullable = false, insertable = false, updatable = false)
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
