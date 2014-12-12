/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.CancionDao;
import co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig.HibernateSessionFactory;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Cancion;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author santiago.gomezp
 */
public class CancionDaoImplement implements CancionDao{

    @Override
    public void insertCancion(Cancion cancion) {
        
        Session session = null;
        
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            
            try {
                    transaction = session.getTransaction();
                    transaction.begin();
                    session.save(cancion);
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
    public List<Cancion> getAllCancion() {
   
        Session session = null;
        List<Cancion> listaCanciones = new ArrayList<Cancion>();
        
        try{
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("From Cancion");
            listaCanciones = query.list();
        }catch (Exception e)  {
            System.out.println(e.getMessage());
        }finally {         
            if(session != null){
                session.close();
            }
        }
        return listaCanciones;
    }

    @Override
    public void deleteCancion(int idCancion) {
        Session session = null;
        
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            Cancion cancion = this.getCancion(idCancion);
            try {
                if (cancion != null){
                    transaction = session.getTransaction();
                    transaction.begin();
                    session.delete(cancion);
                    transaction.commit();
                }
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
    public Cancion getCancion(int idCancion) {
              
            Session session = null;
            Cancion cancion = null;
            try {
                
                session = HibernateSessionFactory.getInstance().getSession();
                Query query = session.createQuery("from Cancion where idCancion= :idCancion");
                query.setParameter("idCancion", idCancion);
                cancion = (Cancion) query.uniqueResult();
                
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());                
            }finally{
                if(session != null){
                    session.close();
                }
            }
            
        
        return cancion;
        
    }
    
    
}
