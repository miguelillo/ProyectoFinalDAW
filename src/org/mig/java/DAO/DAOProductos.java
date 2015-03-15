/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */
package org.mig.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;
import org.mig.java.Interfaces.IProductos;
import static org.mig.java.DAO.DAOUtil.prepareStatement;
import org.mig.java.Exceptions.DAOException;

/**
 * @author miguelangel
 */
public class DAOProductos implements IProductos {
//Preparo el DAOFactory

    private final DAOFactory daoFactory;

    // Constructors -------------------------------------------------------------------------------
    /**
     * Construct an User DAO for the given DAOFactory. Package private so that
     * it can be constructed inside the DAO package only.
     *
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    public DAOProductos(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    //SQL's
    String INSERTAR_PRODUCTOS = "INSERT INTO proyectofinaldaw.productos (`Referencia`, `Precio`, `Nombre`, `Descripcion`, `Color`, `Talla`, `Composicion`, `Categoria`) \n"
            + "	VALUES (?, ?, ?, ?, ?, ?, ?,?)";
    String INSERTAR_PRODUCTOS_TIENDA = "INSERT INTO proyectofinaldaw.productos_tiendas (`Productoid`, `TiendaCIF`) \n"
            + "	VALUES (?, ?);";

    @Override
    public void insertarProducto(Productos producto, Tiendas tienda) {

        Object[] productosValues = {
            producto.getReferencia(),
            producto.getPrecio(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getColor(),
            producto.getTalla(),
            producto.getComposicion(),
            producto.getCategoria()
        };
        Object[] productosTiendasValues = {
            producto.getReferencia(),
            tienda.getCif()
        };
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement pstmtProductos = prepareStatement(connection, INSERTAR_PRODUCTOS, productosValues);
            PreparedStatement pstmtTiendasProductos = prepareStatement(connection, INSERTAR_PRODUCTOS_TIENDA, productosTiendasValues);

            
            //REVISAR LA REFERENCIA DE LOS PRODUCTOS, NO ESTA CLARO LA DB.
            
            int affectedRowsProductos = pstmtProductos.executeUpdate();
            int affectedRowsTiendasProductos = pstmtTiendasProductos.executeUpdate();

            if (affectedRowsProductos == 0 || affectedRowsTiendasProductos == 0) {
                throw new DAOException("Error al introducir el producto");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrarProducto(Productos producto, Tiendas tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos buscarProducto(Productos producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarProducto(Productos producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
