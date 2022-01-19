package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Producto;

/**
 *
 * @author avelino
 */
public class ProductoDAO extends DAO {

    public List<Producto> listarProductoPorNombre() throws Exception {
        List<Producto> productos = new ArrayList();
        try {
            consultarBase("SELECT * FROM producto");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return productos;
    }

    public List<Producto> listarProductoIntervalo() throws Exception {
        List<Producto> productos = new ArrayList();
        try {
            consultarBase("SELECT * FROM producto WHERE precio>=120 && precio <= 202");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return productos;
    }

    public List<Producto> listarProductosPortatil() throws Exception {
        List<Producto> productos = new ArrayList();
        try {
            consultarBase("SELECT * FROM producto WHERE nombre LIKE '%portatil%'");
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return productos;
    }

    public Producto productoBarato() throws Exception {
        Producto producto = null;
        try {
            consultarBase("select * from producto order by precio asc limit 1");
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return producto;
    }

    public void crearProducto(Producto producto) throws Exception {
        try {
            String sql = "INSERT INTO producto VALUES (null,'" + producto.getNombre() + "',"
                    + producto.getPrecio() + "," + producto.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "' WHERE codigo = " + producto.getCodigo() + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
