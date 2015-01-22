/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.udea.edu.compumovil.gr10.discoapp.webservices;

import co.udea.edu.compumovil.gr10.discoapp.bussiness.CalificacionLogic;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.CalificacionDao;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JuanF
 */
@Path("calificaciones")
public class CalificacionWebService {
    private CalificacionLogic calificacionLogic;
    @POST
    @Path("enviarcalificacion")
    @Produces(MediaType.TEXT_PLAIN) 
    public String ingresarCalificacion(@QueryParam("idusuario") String idUsuario,
           @QueryParam("servicio") int servicio,
           @QueryParam("musica") int musica,
           @QueryParam("comentario") String comentario){
        calificacionLogic = new CalificacionLogic();
        if (calificacionLogic.insertarCalificacion(servicio, musica, comentario, idUsuario)) {
            return "Calificación Exitosa";
        }
         return "No se pudo procesar la calificacion";
    }
    
}
