/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.mig.java.DAO.DAOUtil.prepareStatement;
import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;
import org.mig.java.Entities.Usuarios;
import org.mig.java.Exceptions.DAOException;
import org.mig.java.Interfaces.ITiendas;

/**
 *
 * @author miguelangel
 */
public class DAOTiendas implements ITiendas {

    //Preparo el DAOFactory
    private final DAOFactory daoFactory;

    // Constructors -------------------------------------------------------------------------------
    /**
     * Construct an User DAO for the given DAOFactory. Package private so that
     * it can be constructed inside the DAO package only.
     *
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    public DAOTiendas(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    String REGISTRAR_TIENDA = "INSERT INTO proyectofinaldaw.tiendas (`CIF`, `UsuarioMail`, `Nombre`) \n"
            + "	VALUES (?, ?, ?)";
    String PROPIETARIO_TIENDA = "SELECT * FROM TIENDAS WHERE USUARIOMAIL = ?";

    @Override
    public void RegistrarTienda(Tiendas tienda, Usuarios usuario) {

        Object[] values = {
            tienda.getCif(),
            usuario.getMail(),
            tienda.getNombre()
        };

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, REGISTRAR_TIENDA, values);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Error al crear usuario.");
            }
        } catch (SQLException | DAOException ex) {
            throw new DAOException("UPS! Ocurrio un error al registrarte!");
        }

    }

    @Override
    public void BorrarTienda(Tiendas tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tiendas BuscarTienda(Tiendas tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarTienda(Tiendas tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos MostrarCatalogoProductosTienda(Tiendas tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tiendas> tiendasPropietario(Usuarios usuario) {
        Usuarios propietario = new Usuarios();
        List<Tiendas> listaTiendas = new ArrayList<>();

        try {
            Object[] values = {
                usuario.getMail()
            };

            Connection connection = daoFactory.getConnection();
            PreparedStatement pstmt = prepareStatement(connection, PROPIETARIO_TIENDA, values);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                obtenerFilasTiendas(rs);

                listaTiendas.add(obtenerFilasTiendas(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOTiendas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTiendas;
    }

    private Tiendas obtenerFilasTiendas(ResultSet rs) throws SQLException {
        Tiendas filaTienda = new Tiendas();

        filaTienda.setCif(rs.getString(("CIF")));
        filaTienda.setNombre(rs.getString("NOMBRE"));

        return filaTienda;
    }
}
