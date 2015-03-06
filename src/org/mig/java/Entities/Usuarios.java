/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguelangel
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioMail")
    private Collection<Tiendas> tiendasCollection;
    private static final long serialVersionUID = 1L;
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "User_Name")
    private String userName;
    @Id
    @Basic(optional = false)
    @Column(name = "Mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Apellido2")
    private String apellido2;
    @Basic(optional = false)
    @Column(name = "Apellido1")
    private String apellido1;
    @Basic(optional = false)
    @Column(name = "Fecha_Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "Pais")
    private String pais;
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Basic(optional = false)
    @Column(name = "Perfil")
    private String perfil;

    public Usuarios() {
    }

    public Usuarios(String mail) {
        this.mail = mail;
    }

    public Usuarios(String mail, String userName, String nombre, String password, String apellido2, String apellido1, Date fechaNacimiento, String pais, String perfil) {
        this.mail = mail;
        this.userName = userName;
        this.nombre = nombre;
        this.password = password;
        this.apellido2 = apellido2;
        this.apellido1 = apellido1;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.perfil = perfil;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mig.java.Entities.Usuarios[ mail=" + mail + " ]";
    }

    public Collection<Tiendas> getTiendasCollection() {
        return tiendasCollection;
    }

    public void setTiendasCollection(Collection<Tiendas> tiendasCollection) {
        this.tiendasCollection = tiendasCollection;
    }
    
}
