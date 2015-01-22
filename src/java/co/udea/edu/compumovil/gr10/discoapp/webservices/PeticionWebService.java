/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.udea.edu.compumovil.gr10.discoapp.webservices;

import co.udea.edu.compumovil.gr10.discoapp.bussiness.SolicitudLogic;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JuanF
 */

@Path("peticiones")
public class PeticionWebService {
   private SolicitudLogic solicitudLogic;
    
    @POST
    @Path("solicitarcancion")
    @Produces(MediaType.TEXT_PLAIN)    
    public String solicitarCancion(@QueryParam("idusuario")String idUsuario,
            @QueryParam("solicitud") String solicitud){
        solicitudLogic= new SolicitudLogic();
        if (solicitudLogic.solicitarCancion(solicitud, idUsuario)) {
            return "Solicitud Exitosa";
        }
        return "No se pudo realizar la solicitud";
        
    }
    
}
