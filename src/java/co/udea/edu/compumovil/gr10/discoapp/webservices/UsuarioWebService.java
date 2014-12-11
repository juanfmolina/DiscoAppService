/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.webservices;

import co.udea.edu.compumovil.gr10.discoapp.bussiness.UsuarioLogic;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author juanf.molina
 */
@Path("usuarios")
public class UsuarioWebService {

    private UsuarioLogic usuarioLogic;
    
    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path ("iniciosesion")

    public String iniciarSesion(@QueryParam("usuario") String nombreUsuario,
            @QueryParam("password") String password) {
        
        usuarioLogic= new UsuarioLogic();
        Usuario usuarioValidado= usuarioLogic.validarUsuario(nombreUsuario, password);
        if (usuarioValidado==null) {
            return null;
        }
        return usuarioValidado.getIdUsuario();
    }
    
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarUsuario(String ){
        usuarioLogic = new UsuarioLogic();
        Usuario usuarioRegistrado=usuarioLogic.registrarUsuario(usuario);
        if (usuarioRegistrado==null) {
            return false;
        }
        return true;
    }

}
