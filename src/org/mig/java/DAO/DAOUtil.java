package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author miguelangel
 */
public class DAOUtil {

    // Constructors -------------------------------------------------------------------------------
    private DAOUtil() {
        // Utility class, hide constructor.
    }

    // Actions ------------------------------------------------------------------------------------
    /**
     * Returns a PreparedStatement of the given connection, set with the given
     * SQL query and the given parameter values.
     *
     * @param connection The Connection to create the PreparedStatement from.
     * @param sql The SQL query to construct the PreparedStatement with.
     * @param values The parameter values to be set in the created
     * PreparedStatement.
     * @return
     * @throws SQLException If something fails during creating the
     * PreparedStatement.
     */
    public static PreparedStatement prepareStatement(Connection connection, String sql, Object... values)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        setValues(statement, values);
        return statement;
    }

    /**
     * Set the given parameter values in the given PreparedStatement.
     *
     * @param statement
     * @param values The parameter values to be set in the created
     * PreparedStatement.
     * @throws SQLException If something fails during setting the
     * PreparedStatement values.
     */
    public static void setValues(PreparedStatement statement, Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
    }

    /**
     * Converts the given java.util.Date to java.sql.Date.
     *
     * @param date The java.util.Date to be converted to java.sql.Date.
     * @return The converted java.sql.Date.
     */
    public static Date toSqlDate(java.util.Date date) {
        return (date != null) ? new Date(date.getTime()) : null;
    }

}
