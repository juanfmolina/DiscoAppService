/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Calificacion;
import java.util.List;

/**
 *
 * @author juanf.molina
 */
public interface CalificacionDao {
    /**
     * Se inserta una calificación
     * @param calificacion Será la calificación que se guarda
     */
    public void insertCalificacion( Calificacion calificacion);
    
    /**
     * Obtiene todas las calificaciones
     * @return 
     */
    public List<Calificacion> getAllCalificacion();
    
       
    
}
