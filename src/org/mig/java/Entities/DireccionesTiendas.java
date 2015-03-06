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
@Table(name = "direcciones_tiendas")
@NamedQueries({
    @NamedQuery(name = "DireccionesTiendas.findAll", query = "SELECT d FROM DireccionesTiendas d")})
public class DireccionesTiendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionesTiendasPK direccionesTiendasPK;
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
    @JoinColumn(name = "tiendas_CIF", referencedColumnName = "CIF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tiendas tiendas;

    public DireccionesTiendas() {
    }

    public DireccionesTiendas(DireccionesTiendasPK direccionesTiendasPK) {
        this.direccionesTiendasPK = direccionesTiendasPK;
    }

    public DireccionesTiendas(DireccionesTiendasPK direccionesTiendasPK, int numero, int puerta, String poblacion, int codPostal) {
        this.direccionesTiendasPK = direccionesTiendasPK;
        this.numero = numero;
        this.puerta = puerta;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
    }

    public DireccionesTiendas(String direccion, String tiendasCIF) {
        this.direccionesTiendasPK = new DireccionesTiendasPK(direccion, tiendasCIF);
    }

    public DireccionesTiendasPK getDireccionesTiendasPK() {
        return direccionesTiendasPK;
    }

    public void setDireccionesTiendasPK(DireccionesTiendasPK direccionesTiendasPK) {
        this.direccionesTiendasPK = direccionesTiendasPK;
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

    public Tiendas getTiendas() {
        return tiendas;
    }

    public void setTiendas(Tiendas tiendas) {
        this.tiendas = tiendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionesTiendasPK != null ? direccionesTiendasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesTiendas)) {
            return false;
        }
        DireccionesTiendas other = (DireccionesTiendas) object;
        if ((this.direccionesTiendasPK == null && other.direccionesTiendasPK != null) || (this.direccionesTiendasPK != null && !this.direccionesTiendasPK.equals(other.direccionesTiendasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.DireccionesTiendas[ direccionesTiendasPK=" + direccionesTiendasPK + " ]";
    }
    
}
