/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ds_login", nullable = false)
    private Integer dsLogin;
    private Integer modulo;
    @Column(name = "fl_permiso")
    private Character flPermiso;
    @Size(max = 1)
    @Column(name = "fl_add", length = 1)
    private String flAdd;
    @Size(max = 1)
    @Column(name = "fl_mod", length = 1)
    private String flMod;
    @Size(max = 1)
    @Column(name = "fl_del", length = 1)
    private String flDel;
    @JoinColumn(name = "ds_login", referencedColumnName = "no_identificacion", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Permisos() {
    }

    public Permisos(Integer dsLogin) {
        this.dsLogin = dsLogin;
    }

    public Integer getDsLogin() {
        return dsLogin;
    }

    public void setDsLogin(Integer dsLogin) {
        this.dsLogin = dsLogin;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Character getFlPermiso() {
        return flPermiso;
    }

    public void setFlPermiso(Character flPermiso) {
        this.flPermiso = flPermiso;
    }

    public String getFlAdd() {
        return flAdd;
    }

    public void setFlAdd(String flAdd) {
        this.flAdd = flAdd;
    }

    public String getFlMod() {
        return flMod;
    }

    public void setFlMod(String flMod) {
        this.flMod = flMod;
    }

    public String getFlDel() {
        return flDel;
    }

    public void setFlDel(String flDel) {
        this.flDel = flDel;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dsLogin != null ? dsLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.dsLogin == null && other.dsLogin != null) || (this.dsLogin != null && !this.dsLogin.equals(other.dsLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permisos[ dsLogin=" + dsLogin + " ]";
    }
    
}
