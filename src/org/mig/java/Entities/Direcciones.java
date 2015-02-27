/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
 * @author miguelangel
 */
@Entity
@Table(name = "direcciones")
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d")})
public class Direcciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionesPK direccionesPK;
    @Basic(optional = false)
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "Puerta")
    private int puerta;
    @Column(name = "Escalera")
    private Integer escalera;
    @Basic(optional = false)
    @Column(name = "Poblacion")
    private String poblacion;
    @Basic(optional = false)
    @Column(name = "Cod_Postal")
    private int codPostal;
    @JoinColumn(name = "UsuarioMail", referencedColumnName = "Mail", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Direcciones() {
    }

    public Direcciones(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public Direcciones(DireccionesPK direccionesPK, int numero, int puerta, String poblacion, int codPostal) {
        this.direccionesPK = direccionesPK;
        this.numero = numero;
        this.puerta = puerta;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
    }

    public Direcciones(String usuarioMail, String direccion) {
        this.direccionesPK = new DireccionesPK(usuarioMail, direccion);
    }

    public DireccionesPK getDireccionesPK() {
        return direccionesPK;
    }

    public void setDireccionesPK(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    public Integer getEscalera() {
        return escalera;
    }

    public void setEscalera(Integer escalera) {
        this.escalera = escalera;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
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
        hash += (direccionesPK != null ? direccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.direccionesPK == null && other.direccionesPK != null) || (this.direccionesPK != null && !this.direccionesPK.equals(other.direccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Direcciones[ direccionesPK=" + direccionesPK + " ]";
    }
    
}
