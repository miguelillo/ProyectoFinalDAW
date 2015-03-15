/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */

package org.mig.java.Entities;

import java.io.Serializable;

/**
 * @author miguelangel
 */
public class Telefonos implements Serializable {
  
    private int numero;
    private String usuarioMail;
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

}
