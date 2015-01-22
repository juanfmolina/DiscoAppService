/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.bussiness;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.CalificacionDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.UsuarioDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.CalificacionDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.UsuarioDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Calificacion;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;

/**
 *
 * @author JuanF
 */
public class CalificacionLogic {

    private UsuarioDao usuarioDao = null;
    private CalificacionDao calificacionDao= null;

    public boolean insertarCalificacion(int valorServicio, int valorMusica, String comentario, String idUsuario) {
        usuarioDao = new UsuarioDaoImplement();
        Usuario usuario = usuarioDao.getUsuario(idUsuario);
        if (usuario == null) {
            return false;
        }
        if (!usuario.getTipoUsuario().equals("cliente")) {
            return false;
        }
        Calificacion calificacion = new Calificacion(0, usuario, valorServicio, valorMusica, comentario);
        calificacionDao = new CalificacionDaoImplement();
        calificacionDao.insertCalificacion(calificacion);
        return true;
    }

}
