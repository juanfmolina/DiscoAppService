/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import java.util.List;

/**
 *
 * @author juanf.molina
 */
public interface UsuarioDao {
     
       
        /**
     * Entrega todos los usuarios que se encuentran almacenados en el sistema, sin importar
     * si esta eliminado o no.
     * @return retorna lista de usuarios
  
     */
     
    public List<Usuario> getAllUsuarios();
   
    /**
     * Entrega los datos de un usuario dado su identificador, si el usuario no exite retorna null
     * @param idUsuario valor usado para encontrar el usuario solicitado
     * @return retorna instancia del usuario si existe, sino retorna null
   
     */
   
    public Usuario getUsuario(String idUsuario) ;
    
  
    /**
     * Entrega los datos de un usuario segun el tipo de usuario.
     * @param tipoUsuario valor usado para encontrar el usuario solicitado
     * @return retorna el usuario para el parametro ingresado.
     */
     
     public List<Usuario> getUsuariosByTipo(String tipoUsuario);
   
   
     /**
      * crea una cuenta con los datos del usuario
      * @param usuario valor usado para crear una cuenta
      * @return retorna el exito o no de la creacion del usuario
      */
     
      public boolean makeAccount(Usuario usuario);
     
      /**
       * Usado para actualizar los datos de almacenados en el sistema de un usuario
       * @param usuario recibe el usuario que se desea actualizar
       * @return retorna el exito o no de la actualizacion del usuario
       */
       
       public boolean updateUsuario(Usuario usuario);
       
       /**
        * Usado para eliminar el usuario con el parámetro ingresado
        * @param idUsuario identificador del usuario a eliminar
        * @return retorna el exito o no de la eliminacion del usuario
        */
       
        public boolean deleteUsuario(String idUsuario);
       
       
       
        
    
}
