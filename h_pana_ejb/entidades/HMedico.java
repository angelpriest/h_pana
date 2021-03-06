/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan Carlos
 */
@Entity
@Table(name = "h_medico")
@NamedQueries({
    @NamedQuery(name = "HMedico.findAll", query = "SELECT h FROM HMedico h"),
    @NamedQuery(name = "HMedico.findByNoIdentificacion", query = "SELECT h FROM HMedico h WHERE h.hMedicoPK.noIdentificacion = :noIdentificacion"),
    @NamedQuery(name = "HMedico.findByEnfHereditarias", query = "SELECT h FROM HMedico h WHERE h.enfHereditarias = :enfHereditarias"),
    @NamedQuery(name = "HMedico.findByEnfSufridas", query = "SELECT h FROM HMedico h WHERE h.enfSufridas = :enfSufridas"),
    @NamedQuery(name = "HMedico.findByEnfPadece", query = "SELECT h FROM HMedico h WHERE h.enfPadece = :enfPadece"),
    @NamedQuery(name = "HMedico.findByAlcohol", query = "SELECT h FROM HMedico h WHERE h.alcohol = :alcohol"),
    @NamedQuery(name = "HMedico.findByCigarrillo", query = "SELECT h FROM HMedico h WHERE h.cigarrillo = :cigarrillo"),
    @NamedQuery(name = "HMedico.findByFrecMedica", query = "SELECT h FROM HMedico h WHERE h.frecMedica = :frecMedica"),
    @NamedQuery(name = "HMedico.findByFrecEjercicio", query = "SELECT h FROM HMedico h WHERE h.frecEjercicio = :frecEjercicio"),
    @NamedQuery(name = "HMedico.findByFcActualiza", query = "SELECT h FROM HMedico h WHERE h.hMedicoPK.fcActualiza = :fcActualiza")})
public class HMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HMedicoPK hMedicoPK;
    @Size(max = 2147483647)
    @Column(name = "enf_hereditarias")
    private String enfHereditarias;
    @Size(max = 2147483647)
    @Column(name = "enf_sufridas")
    private String enfSufridas;
    @Size(max = 2147483647)
    @Column(name = "enf_padece")
    private String enfPadece;
    private Boolean alcohol;
    private Boolean cigarrillo;
    @Column(name = "frec_medica")
    private Integer frecMedica;
    @Column(name = "frec_ejercicio")
    private Integer frecEjercicio;
    @JoinColumn(name = "no_identificacion", referencedColumnName = "no_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public HMedico() {
    }

    public HMedico(HMedicoPK hMedicoPK) {
        this.hMedicoPK = hMedicoPK;
    }

    public HMedico(int noIdentificacion, Date fcActualiza) {
        this.hMedicoPK = new HMedicoPK(noIdentificacion, fcActualiza);
    }

    public HMedicoPK getHMedicoPK() {
        return hMedicoPK;
    }

    public void setHMedicoPK(HMedicoPK hMedicoPK) {
        this.hMedicoPK = hMedicoPK;
    }

    public String getEnfHereditarias() {
        return enfHereditarias;
    }

    public void setEnfHereditarias(String enfHereditarias) {
        this.enfHereditarias = enfHereditarias;
    }

    public String getEnfSufridas() {
        return enfSufridas;
    }

    public void setEnfSufridas(String enfSufridas) {
        this.enfSufridas = enfSufridas;
    }

    public String getEnfPadece() {
        return enfPadece;
    }

    public void setEnfPadece(String enfPadece) {
        this.enfPadece = enfPadece;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Boolean alcohol) {
        this.alcohol = alcohol;
    }

    public Boolean getCigarrillo() {
        return cigarrillo;
    }

    public void setCigarrillo(Boolean cigarrillo) {
        this.cigarrillo = cigarrillo;
    }

    public Integer getFrecMedica() {
        return frecMedica;
    }

    public void setFrecMedica(Integer frecMedica) {
        this.frecMedica = frecMedica;
    }

    public Integer getFrecEjercicio() {
        return frecEjercicio;
    }

    public void setFrecEjercicio(Integer frecEjercicio) {
        this.frecEjercicio = frecEjercicio;
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
        hash += (hMedicoPK != null ? hMedicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HMedico)) {
            return false;
        }
        HMedico other = (HMedico) object;
        if ((this.hMedicoPK == null && other.hMedicoPK != null) || (this.hMedicoPK != null && !this.hMedicoPK.equals(other.hMedicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HMedico[ hMedicoPK=" + hMedicoPK + " ]";
    }
    
}
