/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author miguelangel
 */
@Embeddable
public class DireccionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "UsuarioMail")
    private String usuarioMail;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;

    public DireccionesPK() {
    }

    public DireccionesPK(String usuarioMail, String direccion) {
        this.usuarioMail = usuarioMail;
        this.direccion = direccion;
    }

    public String getUsuarioMail() {
        return usuarioMail;
    }

    public void setUsuarioMail(String usuarioMail) {
        this.usuarioMail = usuarioMail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioMail != null ? usuarioMail.hashCode() : 0);
        hash += (direccion != null ? direccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesPK)) {
            return false;
        }
        DireccionesPK other = (DireccionesPK) object;
        if ((this.usuarioMail == null && other.usuarioMail != null) || (this.usuarioMail != null && !this.usuarioMail.equals(other.usuarioMail))) {
            return false;
        }
        if ((this.direccion == null && other.direccion != null) || (this.direccion != null && !this.direccion.equals(other.direccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.DireccionesPK[ usuarioMail=" + usuarioMail + ", direccion=" + direccion + " ]";
    }
    
}
