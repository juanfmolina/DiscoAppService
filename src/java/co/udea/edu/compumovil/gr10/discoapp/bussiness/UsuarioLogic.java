/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.bussiness;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.UsuarioDao;
import co.udea.edu.compumovil.gr10.discoapp.data.dao.implement.UsuarioDaoImplement;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author juanf.molina
 */
public class UsuarioLogic {

    private UsuarioDao usuarioDao;

    public Usuario registrarUsuario(Usuario usuario) {

        usuarioDao = new UsuarioDaoImplement();
        if (validarDatos(usuario)) {
            usuario.setPassword(encriptar(usuario.getPassword()));
            if (!usuarioDao.makeAccount(usuario)) {
                return null;
            }
        }
        return usuarioDao.getUsuario(usuario.getIdUsuario());

    }

    public Usuario validarUsuario(String nombreUsuario, String password) {
        usuarioDao = new UsuarioDaoImplement();
        Usuario usuarioAValidar = usuarioDao.getUsuario(nombreUsuario);
        if (usuarioAValidar == null) {
            return null;
        }
        String encryptPassword = encriptar(password);
        if (usuarioAValidar.getPassword().equals(encryptPassword)) {
            return usuarioAValidar;
        }
        return null;
    }

    public Usuario actualizarDatos(Usuario usuario) {
        usuarioDao = new UsuarioDaoImplement();
        if (validarDatos(usuario)) {
            usuario.setPassword(encriptar(usuario.getPassword()));
            if (usuarioDao.getUsuario(usuario.getIdUsuario())==null) {
                return null;
            }
            if (!usuarioDao.updateUsuario(usuario)) {
                return null;
            }
        }
        return usuarioDao.getUsuario(usuario.getIdUsuario());

    }

    public boolean validarDatos(Usuario usuario) {
        if (usuario.getIdUsuario() == null || usuario.getNombreUsuario() == null
                || usuario.getPassword() == null || usuario.getCorreoElectronico() == null
                || usuario.getFechaRegistro() == null || usuario.getTipoUsuario() == null) {
            return false;
        }
        return true;
    }

    static String encriptar(String texto) {

        String secretKey = "grupo10compumovil"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

}
