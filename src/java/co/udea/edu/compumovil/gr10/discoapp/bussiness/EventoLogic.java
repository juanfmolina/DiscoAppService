/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.bussiness;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.EventoDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.UsuarioDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.EventoDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Evento;
import java.util.List;

/**
 *
 * @author juanf.molina
 */
public class EventoLogic {
    private EventoDao eventoDao;
    
    public boolean crearEvento(Evento evento){
        if (evento.getFechaEvento()==null || evento.getNombreEvento()==null
                ||evento.getUrlImagen()==null||evento.getUsuario()==null) {
            return false;
        }
        eventoDao = new EventoDaoImplement();
        eventoDao.insertEvento(evento);
        return true;
    }
    
    public List<Evento> obtenerEventosProximos(){
        eventoDao= new EventoDaoImplement();
        List<Evento> eventosProximos= eventoDao.getNextEventos();
        return eventosProximos;
    }
    public void eliminarEvento(int idEvento){
        eventoDao= new EventoDaoImplement();
        eventoDao.deleteEvento(idEvento);
    }
    public boolean actualizarEvento(Evento evento){
        if (evento.getFechaEvento()==null || evento.getNombreEvento()==null
                ||evento.getUrlImagen()==null||evento.getUsuario()==null) {
            return false;
        }
         eventoDao = new EventoDaoImplement();
        eventoDao.updateEvento(evento);
        return true;
    }
    public List<Evento> obtenerTodosLosEventos(){
        eventoDao= new EventoDaoImplement();
        List<Evento> todosEventos= eventoDao.getAllEventos();
        return todosEventos;
    }
    
    
}
