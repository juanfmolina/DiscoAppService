/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.bussiness;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.SolicitudCancionDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.UsuarioDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.SolicitudCancionDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.UsuarioDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.SolicitudCancion;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JuanF
 */
public class SolicitudLogic {

    private SolicitudCancionDao solicitudCancionDao = null;
    private UsuarioDao usuarioDao = null;
    
    
    /**
     * Metodo para solicitar una cancion 
     * @param nombrePeticion solicitud hecha por un usuario
     * @param nombreUsuario usuario que pide la solicitud
     * @return exito o no de la solicitud
     */
    public boolean solicitarCancion (String nombrePeticion, String nombreUsuario){
        if (nombrePeticion.equals("")||nombreUsuario.equals("")) {
            return false;
        }
        usuarioDao= new UsuarioDaoImplement();
        solicitudCancionDao= new SolicitudCancionDaoImplement();
        Usuario usuario = usuarioDao.getUsuario(nombreUsuario);
         if (usuario==null) {
            return false;
        }
         if (!usuario.getTipoUsuario().equals("cliente")) {
            return false;
        }
         SolicitudCancion solicitudCancion = new SolicitudCancion(usuario, nombrePeticion, nombrePeticion, new Date());
         solicitudCancionDao.insertPeticion(solicitudCancion);
         return true;        
    }

    /**
     * Metodo de la logica del negocio para obtener todas las peticiones de cancion pentiendes.
     * @return todas las peticiones pendientes
     */
    public List<SolicitudCancion> obtenerSolicitudesPendientes() {
        solicitudCancionDao = new SolicitudCancionDaoImplement();
        List<SolicitudCancion> solicitudesPendientes = new ArrayList<SolicitudCancion>();
        solicitudesPendientes = solicitudCancionDao.getPendingPeticiones();
        return solicitudesPendientes;

    }

}
