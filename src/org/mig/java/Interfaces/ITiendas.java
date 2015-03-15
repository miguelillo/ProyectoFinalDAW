package org.mig.java.Interfaces;

import java.util.List;
import org.mig.java.Entities.Productos;
import org.mig.java.Entities.Tiendas;
import org.mig.java.Entities.Usuarios;

/**
 *
 * @author miguelangel
 */
public interface ITiendas {
    
    public void RegistrarTienda(Tiendas tienda, Usuarios usuario);
    
    public void BorrarTienda(Tiendas tienda);
    
    public Tiendas BuscarTienda(Tiendas tienda);
    
    public void ModificarTienda(Tiendas tienda);
    
    public Productos MostrarCatalogoProductosTienda(Tiendas tienda);
    
    public  List<Tiendas> tiendasPropietario(Usuarios usuario);
    
}
