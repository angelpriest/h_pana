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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juan Carlos
 */
@Embeddable
public class HMedicoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "no_identificacion", nullable = false)
    private int noIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fc_actualiza", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fcActualiza;

    public HMedicoPK() {
    }

    public HMedicoPK(int noIdentificacion, Date fcActualiza) {
        this.noIdentificacion = noIdentificacion;
        this.fcActualiza = fcActualiza;
    }

    public int getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(int noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Date getFcActualiza() {
        return fcActualiza;
    }

    public void setFcActualiza(Date fcActualiza) {
        this.fcActualiza = fcActualiza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) noIdentificacion;
        hash += (fcActualiza != null ? fcActualiza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HMedicoPK)) {
            return false;
        }
        HMedicoPK other = (HMedicoPK) object;
        if (this.noIdentificacion != other.noIdentificacion) {
            return false;
        }
        if ((this.fcActualiza == null && other.fcActualiza != null) || (this.fcActualiza != null && !this.fcActualiza.equals(other.fcActualiza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HMedicoPK[ noIdentificacion=" + noIdentificacion + ", fcActualiza=" + fcActualiza + " ]";
    }
    
}
