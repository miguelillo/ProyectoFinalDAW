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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "Precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Color")
    private String color;
    @Column(name = "Talla")
    private String talla;
    @Column(name = "Composicion")
    private String composicion;
    @Basic(optional = false)
    @Column(name = "Categoria")
    private String categoria;
    @JoinTable(name = "productos_tiendas", joinColumns = {
        @JoinColumn(name = "Productoid", referencedColumnName = "Referencia")}, inverseJoinColumns = {
        @JoinColumn(name = "TiendaCIF", referencedColumnName = "CIF")})
    @ManyToMany
    private Collection<Tiendas> tiendasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<Pedidos> pedidosCollection;

    public Productos() {
    }

    public Productos(String referencia) {
        this.referencia = referencia;
    }

    public Productos(String referencia, int precio, String nombre, String descripcion, String categoria) {
        this.referencia = referencia;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Collection<Tiendas> getTiendasCollection() {
        return tiendasCollection;
    }

    public void setTiendasCollection(Collection<Tiendas> tiendasCollection) {
        this.tiendasCollection = tiendasCollection;
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
        hash += (referencia != null ? referencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.referencia == null && other.referencia != null) || (this.referencia != null && !this.referencia.equals(other.referencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Productos[ referencia=" + referencia + " ]";
    }
    
}
