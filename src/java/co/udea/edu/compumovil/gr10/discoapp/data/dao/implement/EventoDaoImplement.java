/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.EventoDao;
import co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig.HibernateSessionFactory;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Evento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juanf.molina
 */
public class EventoDaoImplement implements EventoDao {

    @Override
    public Evento getEvento(int idEvento) {
        Session session = null;
        Evento evento = null;
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Evento where idEvento= :idEvento");
            query.setParameter("idEvento", idEvento);
            evento = (Evento) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return evento;
    }

    @Override
    public List<Evento> getAllEventos() {
        Session session = null;
        List<Evento> listaEventos = new ArrayList<Evento>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Evento");
            listaEventos = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaEventos;

    }

    @Override
    public void insertEvento(Evento evento) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(evento);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }

        }
    }

    @Override
    public List<Evento> getNextEventos() {
        Session session = null;
        List<Evento> listaEventos = new ArrayList<Evento>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Evento where fechaEvento >  current_date() orderby fechaEvento");
            listaEventos = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaEventos;

    }

    @Override
    public void updateEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEvento(int idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
