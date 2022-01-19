/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

/**
 *
 * @author avelino
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductoServicio productoServicio = new ProductoServicio();
        FabricanteServicio fabricanteServicio = new FabricanteServicio();
        
        try {
            productoServicio.modificarProducto("Disco SATA 2 gb",13);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
