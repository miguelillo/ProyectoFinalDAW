package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            + "`Pais`, "
            + "imagen_url, "
            + "`Perfil`,"
            + "`sexo`)"
            + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String LOGIN_USUARIO = "SELECT * FROM USUARIOS WHERE MAIL = ? AND PASSWORD = ?";

    /**
     *
     * @param usuario DAO PARA REGISTRAR A UN USUARIO EN LA BASE DE DATOS.
     * @throws DAOException
     */
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
            usuario.getPerfil(),
            usuario.getSexo()};

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, REGISTRO_USUARIO, values);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Error al crear usuario.");
            }

        } catch (SQLException ex) {
            throw new DAOException("UPS! Ocurrio un error al registrarte!");
        }
    }

    @Override
    public Usuarios LoginUsuario(Usuarios usuario) throws DAOException {
        Usuarios usuarioValido = null;

        Object[] values = {
            usuario.getMail(),
            usuario.getPassword(),};

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement pstmt = prepareStatement(connection, LOGIN_USUARIO, values);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuarioValido = obtenerFilaUsuario(rs);
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al intentar Logearte!");
        }

        return usuarioValido;
    }

    private Usuarios obtenerFilaUsuario(ResultSet rs) throws SQLException {
        Usuarios filaUsuario = new Usuarios();

        filaUsuario.setDni(rs.getString("DNI"));
        filaUsuario.setUserName(rs.getString("USER_NAME"));
        filaUsuario.setMail(rs.getString("MAIL"));
        filaUsuario.setNombre(rs.getString("NOMBRE"));
        filaUsuario.setPassword(rs.getString("PASSWORD"));
        filaUsuario.setApellido2(rs.getString("APELLIDO1"));
        filaUsuario.setApellido1(rs.getString("APELLIDO2"));
        filaUsuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
        filaUsuario.setPais(rs.getString("PAIS"));
        filaUsuario.setImagenUrl(rs.getString("IMAGEN_URL"));
        filaUsuario.setPerfil(rs.getString("PERFIL"));
        filaUsuario.setSexo(rs.getString("SEXO"));

        return filaUsuario;

    }
}
