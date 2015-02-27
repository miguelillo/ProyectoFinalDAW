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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "telefonos")
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t")})
public class Telefonos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Numero")
    private int numero;
    @Id
    @Basic(optional = false)
    @Column(name = "UsuarioMail")
    private String usuarioMail;
    @JoinColumn(name = "UsuarioMail", referencedColumnName = "Mail", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Telefonos() {
    }

    public Telefonos(String usuarioMail) {
        this.usuarioMail = usuarioMail;
    }

    public Telefonos(String usuarioMail, int numero) {
        this.usuarioMail = usuarioMail;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUsuarioMail() {
        return usuarioMail;
    }

    public void setUsuarioMail(String usuarioMail) {
        this.usuarioMail = usuarioMail;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioMail != null ? usuarioMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.usuarioMail == null && other.usuarioMail != null) || (this.usuarioMail != null && !this.usuarioMail.equals(other.usuarioMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Telefonos[ usuarioMail=" + usuarioMail + " ]";
    }
    
}
