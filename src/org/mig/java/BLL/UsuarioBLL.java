package org.mig.java.BLL;

import org.mig.java.DAO.DAOFactory;
import org.mig.java.Entities.Usuarios;
import org.mig.java.Interfaces.IUsuario;

/**
 *
 * @author miguelangel
 */
public class UsuarioBLL {

    public void RegistrarUsuario(Usuarios usuario) {
        DAOFactory factory = DAOFactory.getInstance();
        IUsuario daoUsuario = factory.getUsuarioDAO();

        //Cargo el objeo instanciado que se ha pasado desde el 
        daoUsuario.RegistrarUsuario(usuario);
    }

    public Usuarios loginUsuario(Usuarios usuario) {
        DAOFactory factory = DAOFactory.getInstance();
        IUsuario daoUsuario = factory.getUsuarioDAO();

        return daoUsuario.LoginUsuario(usuario);
    }
}
