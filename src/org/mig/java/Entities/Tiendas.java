/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "tiendas")
@NamedQueries({
    @NamedQuery(name = "Tiendas.findAll", query = "SELECT t FROM Tiendas t")})
public class Tiendas implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiendas")
    private Collection<DireccionesTiendas> direccionesTiendasCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CIF")
    private String cif;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @ManyToMany(mappedBy = "tiendasCollection")
    private Collection<Productos> productosCollection;
    @JoinColumn(name = "UsuarioMail", referencedColumnName = "Mail")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiendas")
    private Collection<Pedidos> pedidosCollection;

    public Tiendas() {
    }

    public Tiendas(String cif) {
        this.cif = cif;
    }

    public Tiendas(String cif, String nombre, String direccion) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cif != null ? cif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiendas)) {
            return false;
        }
        Tiendas other = (Tiendas) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Tiendas[ cif=" + cif + " ]";
    }

    public Collection<DireccionesTiendas> getDireccionesTiendasCollection() {
        return direccionesTiendasCollection;
    }

    public void setDireccionesTiendasCollection(Collection<DireccionesTiendas> direccionesTiendasCollection) {
        this.direccionesTiendasCollection = direccionesTiendasCollection;
    }
    
}
