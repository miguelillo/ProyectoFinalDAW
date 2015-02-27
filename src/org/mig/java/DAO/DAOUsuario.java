package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.mig.java.DAO.DAOUtil.prepareStatement;
import static org.mig.java.DAO.DAOUtil.toSqlDate;
import org.mig.java.Entities.Usuarios;
import org.mig.java.Exceptions.DAOException;
import org.mig.java.Interfaces.IUsuario;

/**
 *
 * @author miguelangel
 */
public class DAOUsuario implements IUsuario {

    //Preparo el DAOFactory
    private final DAOFactory daoFactory;

    // Constructors -------------------------------------------------------------------------------
    /**
     * Construct an User DAO for the given DAOFactory. Package private so that
     * it can be constructed inside the DAO package only.
     *
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    public DAOUsuario(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * 'V','P','C','A' V = VENDEDOR P = PROPIETARIO C = CLIENTE A =
     * ADMINISTRADOR WEB
     */
    private static final String REGISTRO_USUARIO = "INSERT INTO usuarios "
            + "(`DNI`, "
            + "`User_Name`, "
            + "`Mail`, "
            + "`Nombre`, "
            + "`Password`, "
            + "`Apellido2`, "
            + "`Apellido1`, "
            + "`Fecha_Nacimiento`, "
            + "`Pais`, imagen_url, "
            + "`Perfil`) \n"
            + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void RegistrarUsuario(Usuarios usuario) throws DAOException {

        Object[] values = {
            usuario.getDni(),
            usuario.getUserName(),
            usuario.getMail(),
            usuario.getNombre(),
            usuario.getPassword(),
            usuario.getApellido2(),
            usuario.getApellido1(),
            //CONVIERTO LA FECHA JAVA A SQL DATE con DAOUTIL
            toSqlDate(usuario.getFechaNacimiento()),
            usuario.getPais(),
            usuario.getImagenUrl(),
            usuario.getPerfil(),};

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, REGISTRO_USUARIO, values);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Error al crear usuario.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ValidarUsuario(Usuarios usuario) throws DAOException {

    }

    @Override
    public Usuarios LoginUsuario(Usuarios usuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
