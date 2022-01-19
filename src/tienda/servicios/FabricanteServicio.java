package tienda.servicios;

import java.util.List;
import tienda.persistencia.FabricanteDAO;
import tienda.entidades.Fabricante;

public class FabricanteServicio {
    private  FabricanteDAO dao;
    
    public FabricanteServicio(){
        this.dao = new FabricanteDAO();
    }
    
    private List<Fabricante> listarFabricante() throws Exception{
           List<Fabricante> fabricantes = dao.listarFabricante();
           return fabricantes;
    }
    
    public void mostrarFabricante() throws Exception{
        List<Fabricante> fabricantes = listarFabricante();
        
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante.getCodigo() + " - " + fabricante.getNombre());
        }
    }
    
    private Fabricante buscarFabricanteNombre(String nombre) throws Exception{
        Fabricante fabricante = dao.buscarFabricanteNombre(nombre);
        return fabricante;
    }
    
    public void crearFabricante() throws Exception{
        Fabricante fabricante = new Fabricante().crearFabricante();
        validacion(fabricante);
        dao.crearFabricante(fabricante);
    }
    
    private void validacion(Fabricante fabricante) throws Exception{
        if(fabricante.getNombre() == null || fabricante.getNombre().isEmpty()){
            throw new Exception("El nombre tiene que ser completo");
        }
        Fabricante f = buscarFabricanteNombre(fabricante.getNombre());
        if (f != null) {
            throw new Exception("El nombre es incorrecto, pertenece un dato en la base de datos");
        }
    }
}
