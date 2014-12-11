/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;

import co.udea.edu.compumovil.gr10.discoapp.data.dao.UsuarioDao;
import co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig.HibernateSessionFactory;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juanf.molina
 */
public class UsuarioDaoImplement implements UsuarioDao {

    @Override
    public List<Usuario> getAllUsuarios() {
        Session session = null;
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Usuario");
            listaUsuarios = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaUsuarios;

    }

    @Override
    public Usuario getUsuario(String idUsuario) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Usuario where idUsuario= :idUsuario");
            query.setParameter("idUsuario", idUsuario);
            usuario = (Usuario) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> getUsuariosByTipo(String tipoUsuario) {
        Session session = null;
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Query query = session.createQuery("from Usuario where tipoUsuario= :tipoU");
            query.setParameter("tipoU", tipoUsuario);
            listaUsuarios = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaUsuarios;
    }

    @Override
    public boolean makeAccount(Usuario usuario) {
        Session session = null;
        Usuario usuario2 = this.getUsuario(usuario.getIdUsuario());
        if (usuario2 != null) {
            return false;
        }

        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            try {
                transaction = session.getTransaction();
                transaction.begin();
                session.save(usuario);
                transaction.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                transaction.rollback();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return true;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
        Session session = null;
        Usuario usuario2 = this.getUsuario(usuario.getIdUsuario());
        if (usuario2 == null) {
            return false;
        }

        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            try {
                transaction = session.getTransaction();
                transaction.begin();
                session.update(usuario);
                transaction.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                transaction.rollback();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return true;
    }

    @Override
    public boolean deleteUsuario(String idUsuario) {
        Session session = null;
        Usuario usuario = this.getUsuario(idUsuario);
        if (usuario == null) {
            return false;
        }

        try {
            session = HibernateSessionFactory.getInstance().getSession();
            Transaction transaction = null;
            try {
                transaction = session.getTransaction();
                transaction.begin();
                session.delete(usuario);
                transaction.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                transaction.rollback();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return true;
    }

}
