package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.mig.java.Exceptions.DAOException;
import org.mig.java.Interfaces.ITiendas;
import org.mig.java.Interfaces.IUsuario;

public abstract class DAOFactory {

    // Constants ----------------------------------------------------------------------------------
    private static final String URL = "jdbc:mysql://localhost:3306/proyectofinaldaw";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Actions ------------------------------------------------------------------------------------
    /**
     * Returns a new DAOFactory instance for the given database name.
     *
     * @return A new DAOFactory instance for the given database name.
     */
    public static DAOFactory getInstance() {

        String url = URL;
        String driverClassName = DRIVER;
        String password = PASSWORD;
        String username = USERNAME;
        DAOFactory instance;

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new DAOException(
                    "El driver '" + driverClassName + "' no se encuentra en la ruta especificada.");
        }
        instance = new DriverManagerDAOFactory(url, username, password);

        return instance;
    }

    /**
     * Returns a connection to the database. Package private so that it can be
     * used inside the DAO package only.
     *
     * @return A connection to the database.
     * @throws SQLException If acquiring the connection fails.
     */
    abstract Connection getConnection() throws SQLException;

    // DAO implementation getters -----------------------------------------------------------------
    /**
     * Returns the User DAO associated with the current DAOFactory.
     *
     * @return The User DAO associated with the current DAOFactory.
     */
    public IUsuario getUsuarioDAO() {
        return new DAOUsuario(this);
    }

    public ITiendas getTiendasDAO() {
        return new DAOTiendas(this);
    }

    // You can add more DAO implementation getters here.
}

// Default DAOFactory implementations -------------------------------------------------------------
/**
 * The DriverManager based DAOFactory.
 */
class DriverManagerDAOFactory extends DAOFactory {

    private final String url;
    private final String username;
    private final String password;

    DriverManagerDAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

/**
 * The DataSource based DAOFactory.
 */
class DataSourceDAOFactory extends DAOFactory {

    private final DataSource dataSource;

    DataSourceDAOFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

/**
 * The DataSource-with-Login based DAOFactory.
 */
class DataSourceWithLoginDAOFactory extends DAOFactory {

    private final DataSource dataSource;
    private final String username;
    private final String password;

    DataSourceWithLoginDAOFactory(DataSource dataSource, String username, String password) {
        this.dataSource = dataSource;
        this.username = username;
        this.password = password;
    }

    @Override
    Connection getConnection() throws SQLException {
        return dataSource.getConnection(username, password);

    }
}
