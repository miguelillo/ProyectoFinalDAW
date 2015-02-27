/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.Interfaces;

import org.mig.java.Entities.Usuarios;
import org.mig.java.Exceptions.DAOException;

/**
 *
 * @author miguelangel
 */
public interface IUsuario {

    public Usuarios LoginUsuario(Usuarios usuario) throws DAOException;

    public void ValidarUsuario(Usuarios usuario) throws DAOException;

    public void RegistrarUsuario(Usuarios usuario) throws DAOException;

}
