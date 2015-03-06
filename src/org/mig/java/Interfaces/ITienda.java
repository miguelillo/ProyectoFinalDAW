package org.mig.java.Interfaces;

import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;

/**
 *
 * @author miguelangel
 */
public interface ITienda {
    
    public void RegistrarTienda(Tiendas tienda);
    
    public void BorrarTienda(Tiendas tienda);
    
    public Tiendas BuscarTienda(Tiendas tienda);
    
    public void ModificarTienda(Tiendas tienda);
    
    public Productos MostrarCatalogoProductosTienda(Tiendas tienda);
    
}
