/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */

package org.mig.java.BLL;

import org.mig.java.DAO.DAOFactory;
import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;
import org.mig.java.Interfaces.IProductos;

/**
 * @author miguelangel
 */
public class ProductosBLL {
    
    public void insertarProducto(Productos producto, Tiendas tienda){
        DAOFactory daoFactory = DAOFactory.getInstance();
        
        IProductos daoProductos = daoFactory.getProductosDAO();
        
        daoProductos.insertarProducto(producto, tienda);
        
    }
}
