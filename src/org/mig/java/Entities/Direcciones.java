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
public class Direcciones implements Serializable {
    
    
    protected DireccionesPK direccionesPK;
    private int numero;
    private int puerta;
    private Integer escalera;
    private String poblacion;
    private int codPostal;
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
}
