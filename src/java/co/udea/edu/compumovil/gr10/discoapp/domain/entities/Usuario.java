package co.udea.edu.compumovil.gr10.discoapp.domain.entities;
// Generated 9/12/2014 07:45:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String idUsuario;
     private String password;
     private String nombreUsuario;
     private String tipoUsuario;
     private Date fechaRegistro;
     private String correoElectronico;
     private Set solicitudCancions = new HashSet(0);
     private Set eventos = new HashSet(0);
     private Set calificacions = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String idUsuario, String password, String nombreUsuario, String tipoUsuario, Date fechaRegistro, String correoElectronico) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
        this.correoElectronico = correoElectronico;
    }
    public Usuario(String idUsuario, String password, String nombreUsuario, String tipoUsuario, Date fechaRegistro, String correoElectronico, Set solicitudCancions, Set eventos, Set calificacions) {
       this.idUsuario = idUsuario;
       this.password = password;
       this.nombreUsuario = nombreUsuario;
       this.tipoUsuario = tipoUsuario;
       this.fechaRegistro = fechaRegistro;
       this.correoElectronico = correoElectronico;
       this.solicitudCancions = solicitudCancions;
       this.eventos = eventos;
       this.calificacions = calificacions;
    }
   
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public Set getSolicitudCancions() {
        return this.solicitudCancions;
    }
    
    public void setSolicitudCancions(Set solicitudCancions) {
        this.solicitudCancions = solicitudCancions;
    }
    public Set getEventos() {
        return this.eventos;
    }
    
    public void setEventos(Set eventos) {
        this.eventos = eventos;
    }
    public Set getCalificacions() {
        return this.calificacions;
    }
    
    public void setCalificacions(Set calificacions) {
        this.calificacions = calificacions;
    }




}


