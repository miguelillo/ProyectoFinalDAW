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

public class CodPostal implements Serializable {
    
    private Integer codPostal;

    public CodPostal() {
    }

    public CodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }
}
