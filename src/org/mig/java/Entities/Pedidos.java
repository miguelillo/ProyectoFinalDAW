/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "pedidos")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "Fecha_Pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "Fecha_Confirmacion")
    @Temporal(TemporalType.DATE)
    private Date fechaConfirmacion;
    @Column(name = "Fecha_Servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    @Column(name = "Unidades")
    private Integer unidades;
    @Column(name = "Num_Factura")
    private Integer numFactura;
    @Column(name = "Estado_Servicio")
    private String estadoServicio;
    @JoinColumn(name = "TiendaCIF", referencedColumnName = "CIF")
    @ManyToOne(optional = false)
    private Tiendas tiendas;
    @JoinColumn(name = "ProductoReferencia", referencedColumnName = "Referencia")
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "UsuarioMail", referencedColumnName = "Mail")
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedidos(Integer idPedido, Date fechaPedido) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Integer numFactura) {
        this.numFactura = numFactura;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public Tiendas getTiendas() {
        return tiendas;
    }

    public void setTiendas(Tiendas tiendas) {
        this.tiendas = tiendas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
