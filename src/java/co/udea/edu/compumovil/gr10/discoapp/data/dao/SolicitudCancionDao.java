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
public interface SolicitudCancionDao {
    
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
     * Metodo para retornar todas las peticiones de canción por orden ascendente de fecha
     * @return Lista con todas las peticiones pendientes
     */
    public List<SolicitudCancion> getPendingPeticiones();
    
    /**
     * Metodo para actualizar una peticion de cancion
     * @param solicitud 
     */
    public void updatePeticion(SolicitudCancion solicitud);
    
    
    /**
     * 
     * @return 
     */
    public List<SolicitudCancion> getAllSolicitudes();
    
    /**
     * 
     * @param idUsuario
     * @return 
     */
    public List<SolicitudCancion> getSolicitudByUsuario(String idUsuario);
}
