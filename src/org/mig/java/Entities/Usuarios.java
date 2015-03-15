/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */

package org.mig.java.Entities;

import java.io.Serializable;
import java.util.Date;

/**
 * @author miguelangel
 */

public class Usuarios implements Serializable {
   
    private String dni;
 
    private String userName;
    private String mail;
    private String nombre;
    private String password;
    private String apellido2;
    private String apellido1;
    private Date fechaNacimiento;
    private String pais;
    private String imagenUrl;
    private String perfil;
    private String sexo;

    public Usuarios() {
    }

    public Usuarios(String mail) {
        this.mail = mail;
    }

    public Usuarios(String mail, String userName, String nombre, String password, String apellido2, String apellido1, Date fechaNacimiento, String pais, String perfil, String sexo) {
        this.mail = mail;
        this.userName = userName;
        this.nombre = nombre;
        this.password = password;
        this.apellido2 = apellido2;
        this.apellido1 = apellido1;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.perfil = perfil;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
