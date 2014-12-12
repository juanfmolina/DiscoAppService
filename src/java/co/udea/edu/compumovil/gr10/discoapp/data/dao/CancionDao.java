/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Cancion;
import java.util.List;

/**
 *
 * @author santiago.gomezp
 */
public interface CancionDao {
    
    /**
     * Se inserta una cancion
     * @param cancion sera la cancion que se guarda
     */
    public void insertCancion( Cancion cancion);
    
    /**
     * Obtiene todas las canciones
     * @return 
     */
    public List<Cancion> getAllCancion();
    
    /**
     * Se elimina una cancion
     * @param idCancion
     * @param cancion sera la cancion a eliminar
     */
    public void deleteCancion(int idCancion);
    
 
    
    public Cancion getCancion(int idCancion);
    
    
}
