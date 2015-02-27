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
@Table(name = "poblaciones")
@NamedQueries({
    @NamedQuery(name = "Poblaciones.findAll", query = "SELECT p FROM Poblaciones p")})
public class Poblaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Poblacion")
    private String poblacion;

    public Poblaciones() {
    }

    public Poblaciones(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poblacion != null ? poblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poblaciones)) {
            return false;
        }
        Poblaciones other = (Poblaciones) object;
        if ((this.poblacion == null && other.poblacion != null) || (this.poblacion != null && !this.poblacion.equals(other.poblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Poblaciones[ poblacion=" + poblacion + " ]";
    }
    
}
