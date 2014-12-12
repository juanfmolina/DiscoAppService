/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.Implement;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.PeticionCancionDao;
import co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig.HibernateSessionFactory;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.SolicitudCancion;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author santiago.gomezp
 */
public class PeticionCancionDaoImplement implements PeticionCancionDao {

    @Override
    public void insertPeticion(SolicitudCancion solicitud) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            try {
                transaction = session.getTransaction();
                transaction.begin();
                session.save(solicitud);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        
    }

    @Override
    public SolicitudCancion getPeticion(int idSolicitud) {
        SolicitudCancion solicitud = null;
        Session session = null;
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Solicitud cancion where idSolicitud =:idSolicitud");
            query.setParameter("idSolicitud", idSolicitud);
            solicitud = (SolicitudCancion) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }
        }
        
        return solicitud;
    }

    @Override
    public List<SolicitudCancion> getAllSolicitudes() {
        Session session = null;
        List<SolicitudCancion>  listaSolicitudes = new ArrayList<SolicitudCancion>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("From SolicitudCancion");
            listaSolicitudes = query.list();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaSolicitudes;            
    }

    @Override
    public List<SolicitudCancion> getSolicitudByUsuario(int idUsuario) {
        Session session = null;
        List<SolicitudCancion> listaSolicitudes = new ArrayList<SolicitudCancion>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from SolicitudCancion where idUsuario =:idUsuario ");
            query.setParameter("idUsuario", idUsuario);
            listaSolicitudes = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return listaSolicitudes;
    }
    
    
    
}
