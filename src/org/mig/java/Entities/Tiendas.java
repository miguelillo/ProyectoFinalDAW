/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */
package org.mig.java.Entities;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author miguelangel
 */
public class Tiendas implements Serializable {

    private String cif;
    private String nombre;
    private Usuarios usuarioMail;

    public Tiendas() {
    }

    public Tiendas(String cif) {
        this.cif = cif;
    }

    public Tiendas(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
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

    public Usuarios getUsuarioMail() {
        return usuarioMail;
    }

    public void setUsuarioMail(Usuarios usuarioMail) {
        this.usuarioMail = usuarioMail;
    }

}
