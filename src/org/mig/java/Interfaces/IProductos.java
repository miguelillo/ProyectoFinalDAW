/*
 * Este codigo pertenece a miguel.navarrovera@gmail.com
 * Su uso esta prohibido para uso comercial.
 * Si tienes interes en usarlo, ponte en contacto conmigo, Gracias. :D
 */
package org.mig.java.Interfaces;

import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;

/**
 *
 * @author miguelangel
 */
public interface IProductos {
    
    public void insertarProducto(Productos producto, Tiendas tienda);
    
    public void borrarProducto(Productos producto, Tiendas tienda);
    
    public Productos buscarProducto(Productos producto);
    
    public void modificarProducto(Productos producto);
    
    
    
    
}
