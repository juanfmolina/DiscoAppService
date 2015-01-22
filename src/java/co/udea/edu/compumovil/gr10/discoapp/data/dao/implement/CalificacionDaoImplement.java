/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.CalificacionDao;
import co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig.HibernateSessionFactory;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Calificacion;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juanf.molina
 */
public class CalificacionDaoImplement implements CalificacionDao{

    @Override
    public void insertCalificacion(Calificacion calificacion) {
          
        Session session = null;
        
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            
            try {
                    transaction = session.getTransaction();
                    transaction.begin();
                    session.save(calificacion);
                    transaction.commit();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                transaction.rollback();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        
        
    }

    @Override
    public List<Calificacion> getAllCalificacion() {
       
        Session session = null;
        List<Calificacion> listaCalificaciones = new ArrayList<Calificacion>();
        
        try{
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("From Calificacion");
            listaCalificaciones = query.list();
        }catch (Exception e)  {
            System.out.println(e.getMessage());
        }finally {         
            if(session != null){
                session.close();
            }
        }
        return listaCalificaciones;
    }
    
}
