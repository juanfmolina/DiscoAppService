/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Evento;
import java.util.List;

/**
 *
 * @author juanf.molina
 */
public interface EventoDao {
    
    /**
     * Obtiene un evento por el id del Evento, si este existe
     * @param idEvento el Id del evento 
     * @return retorna el evento con el Id
     */
    public Evento getEvento(int idEvento);
    /**
     * Entrega todos los eventos ordenados por fecha
     * @return lista con todos los eventos
     */
    public List<Evento> getAllEventos();
    
    /**
     * Inserta un evento
     * @param evento 
     */
    public void insertEvento(Evento evento);
    
    /**
     * Retorna los eventos proximos a la fecha de consulta
     * @return lista de eventos con fecha proxima a la actual
     */
    public List<Evento> getNextEventos();
    /**
     * Actualiza la informacion de un evento
     * @param evento el evento a actualizar
     */
    public void updateEvento(Evento evento);
    /**
     * Elimina un evento por el atributo iDevento
     * @param idEvento el id del evento a eliminar
     */
    public void deleteEvento(int idEvento);
    
}
