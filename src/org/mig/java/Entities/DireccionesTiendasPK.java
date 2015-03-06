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
public class DireccionesTiendasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "tiendas_CIF")
    private String tiendasCIF;

    public DireccionesTiendasPK() {
    }

    public DireccionesTiendasPK(String direccion, String tiendasCIF) {
        this.direccion = direccion;
        this.tiendasCIF = tiendasCIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTiendasCIF() {
        return tiendasCIF;
    }

    public void setTiendasCIF(String tiendasCIF) {
        this.tiendasCIF = tiendasCIF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccion != null ? direccion.hashCode() : 0);
        hash += (tiendasCIF != null ? tiendasCIF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesTiendasPK)) {
            return false;
        }
        DireccionesTiendasPK other = (DireccionesTiendasPK) object;
        if ((this.direccion == null && other.direccion != null) || (this.direccion != null && !this.direccion.equals(other.direccion))) {
            return false;
        }
        if ((this.tiendasCIF == null && other.tiendasCIF != null) || (this.tiendasCIF != null && !this.tiendasCIF.equals(other.tiendasCIF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.DireccionesTiendasPK[ direccion=" + direccion + ", tiendasCIF=" + tiendasCIF + " ]";
    }
    
}
