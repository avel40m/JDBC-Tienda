package tienda.entidades;

import java.util.Scanner;
import tienda.servicios.FabricanteServicio;

/**
 *
 * @author avelino
 */
public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int codigoFabricante;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigoFabricante=" + codigoFabricante + '}';
    }
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private FabricanteServicio fabricanteServicio = new FabricanteServicio();
    
    public Producto crearUsuario() throws Exception{
        Producto producto = new Producto();
        System.out.println("Ingresar el nombre del producto");
        producto.setNombre(leer.next());
        System.out.println("Ingrese el precio del producto");
        producto.setPrecio(leer.nextDouble());
        System.out.println("Ingrese el id del fabricante");
        fabricanteServicio.mostrarFabricante();
        producto.setCodigoFabricante(leer.nextInt());
        return producto;
    }
}
