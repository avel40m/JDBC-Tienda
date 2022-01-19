package tienda.servicios;

import java.util.List;
import tienda.persistencia.ProductoDAO;
import tienda.entidades.Producto;
/**
 *
 * @author avelino
 */
public class ProductoServicio {
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
    
    public List<Producto> listarTodo() throws Exception{
        List<Producto> productos = dao.listarProductoPorNombre();
        return productos;
    }
    
    public void mostrarTodosNombre() throws Exception{
        List<Producto> productos = listarTodo();
        System.out.println("Listado de nombre de productos");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }
    
    public void mostraTodosNombrePrecio() throws Exception{
        List<Producto> productos = listarTodo();
        System.out.println("Listado de nombre y precio de productos");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - $"+producto.getPrecio());
        }
    }
    
    public void mostraProductosPorIntervalo() throws Exception{
        List<Producto> productos = dao.listarProductoIntervalo();
        System.out.println("Mostrar producto que su precio este entre 120 y 202");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo() + " - " + producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
    
    public void mostrarProductosPortatil() throws Exception{
        List<Producto> productos = dao.listarProductosPortatil();
        System.out.println("Lista de productos portatil");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
    
    public void productoBarato() throws Exception{
        Producto producto = dao.productoBarato();
        System.out.println("Producto más barato");
        System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
    }
    
    public void crearProducto() throws Exception{
        Producto producto = new Producto().crearUsuario();
        
        dao.crearProducto(producto);
    }
    
    public void modificarProducto(String nombre, int id) throws Exception{
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(id);
        dao.modificarProducto(producto);
    }
}
