/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.SolicitudCancion;
import java.util.List;


/**
 *
 * @author santiago.gomezp
 */
public interface PeticionCancionDao {
    
    /**
     * 
     * @param solicitud 
     */
    public void insertPeticion(SolicitudCancion solicitud);
    
    
    
    /**
     * Obtiene la cancion deseada 
     * @param idSolicitud
     * @return 
     */
    public SolicitudCancion getPeticion(int idSolicitud);
    
    
    /**
     * 
     * @return 
     */
    public List<SolicitudCancion> getAllSolicitudes();
    
    /**
     * 
     * @return 
     */
    public List<SolicitudCancion> getSolicitudByUsuario(int idUsuario);
}
