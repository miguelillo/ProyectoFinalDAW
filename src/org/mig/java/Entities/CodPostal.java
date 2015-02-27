/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "cod_postal")
@NamedQueries({
    @NamedQuery(name = "CodPostal.findAll", query = "SELECT c FROM CodPostal c")})
public class CodPostal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Postal")
    private Integer codPostal;

    public CodPostal() {
    }

    public CodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPostal != null ? codPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodPostal)) {
            return false;
        }
        CodPostal other = (CodPostal) object;
        if ((this.codPostal == null && other.codPostal != null) || (this.codPostal != null && !this.codPostal.equals(other.codPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.CodPostal[ codPostal=" + codPostal + " ]";
    }
    
}
