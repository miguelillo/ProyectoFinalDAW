/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */
package org.mig.java.BLL;

import java.util.List;
import org.mig.java.DAO.DAOFactory;
import org.mig.java.Entities.Tiendas;
import org.mig.java.Entities.Usuarios;
import org.mig.java.Interfaces.ITiendas;

/**
 * @author miguelangel
 */
public class TiendasBLL {

    public void RegistrarTienda(Tiendas tienda, Usuarios usuario) {
        DAOFactory daoFactory = DAOFactory.getInstance();

        ITiendas daoTiendas = daoFactory.getTiendasDAO();

        daoTiendas.RegistrarTienda(tienda, usuario);

    }

    public List<Tiendas> propietarioTienda(Usuarios usuario) {
        DAOFactory daoFactory = DAOFactory.getInstance();

        ITiendas daoTiendas = daoFactory.getTiendasDAO();

        return daoTiendas.tiendasPropietario(usuario);
    }

}
