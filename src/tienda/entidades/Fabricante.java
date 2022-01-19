package tienda.entidades;

import java.util.Scanner;

/**
 *
 * @author avelino
 */
public class Fabricante {
    private int codigo;
    private String nombre;

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

    @Override
    public String toString() {
        return "Fabricante{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Fabricante crearFabricante(){
        Fabricante fabricante = new Fabricante();
        System.out.println("Nombre del fabricante");
        fabricante.setNombre(leer.next());
        return fabricante;
    }
    
}
