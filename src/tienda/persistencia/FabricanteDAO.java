package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;

public class FabricanteDAO extends DAO {
    
    public List<Fabricante> listarFabricante() throws Exception{
        List<Fabricante> fabricantes = new ArrayList();
        try {
            consultarBase("SELECT * FROM fabricante");
            
            while (resultado.next()) {                
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
                fabricantes.add(fabricante);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        return fabricantes;
    }
    
    public void crearFabricante(Fabricante fabricante) throws Exception{
        try {
            String sql = "INSERT INTO fabricante VALUES (null,'"+fabricante.getNombre()+"')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarFabricanteNombre(String nombre) throws Exception{
        Fabricante fabricante = null;
        try {
            String sql = "SELECT * FROM fabricante WHERE nombre = '"+nombre+"'";
            consultarBase(sql);
            
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString("nombre"));                
            }
        } catch (Exception e) {
            throw e;
        }
        return fabricante;
    }
}
