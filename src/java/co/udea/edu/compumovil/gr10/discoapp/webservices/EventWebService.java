/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.webservices;

import co.udea.edu.compumovil.gr10.discoapp.bussiness.EventoLogic;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Evento;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *Responde a las peticiones de los servicios web referentes a los eventos
 * @author juanf.molina
 */

@Path("eventos")
public class EventWebService {
    
    /**
     * Entidad encargada de ejecutar la logica  necesaria para manipular los eventos
     */
    private EventoLogic eventoLogic;
    
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("proximoseventos")
    public List<Evento> obtenerEventosProximos (){
        List<Evento> eventosProximos;
        eventoLogic= new EventoLogic();
        eventosProximos= eventoLogic.obtenerEventosProximos();
        return eventosProximos;
        
    }
    
 
}
