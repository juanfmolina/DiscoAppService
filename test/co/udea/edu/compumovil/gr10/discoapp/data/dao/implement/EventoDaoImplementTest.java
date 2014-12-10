/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;

import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Evento;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanf.molina
 */
public class EventoDaoImplementTest {
    
    public EventoDaoImplementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEvento method, of class EventoDaoImplement.
     */
    @Test
    public void testGetEvento() {
        System.out.println("getEvento");
        int idEvento = 0;
        EventoDaoImplement instance = new EventoDaoImplement();
        Evento expResult = null;
        Evento result = instance.getEvento(idEvento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEventos method, of class EventoDaoImplement.
     */
    @Test
    public void testGetAllEventos() {
        System.out.println("getAllEventos");
        EventoDaoImplement instance = new EventoDaoImplement();
        List<Evento> expResult = null;
        List<Evento> result = instance.getAllEventos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertEvento method, of class EventoDaoImplement.
     */
    @Test
    public void testInsertEvento() {
        System.out.println("insertEvento");
        Date date = new Date();
        Evento evento = new Evento(1, new Usuario("juanfmolina", "123", "Juan Fernando", "usuario",date , "j@gmail.com"), "Alumbrados","Navidad en familia", date, "sssss");
        EventoDaoImplement instance = new EventoDaoImplement();
        instance.insertEvento(evento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextEventos method, of class EventoDaoImplement.
     */
    @Test
    public void testGetNextEventos() {
        System.out.println("getNextEventos");
        EventoDaoImplement instance = new EventoDaoImplement();
        List<Evento> expResult = null;
        List<Evento> result = instance.getNextEventos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEvento method, of class EventoDaoImplement.
     */
    @Test
    public void testUpdateEvento() {
        System.out.println("updateEvento");
        Evento evento = null;
        EventoDaoImplement instance = new EventoDaoImplement();
        instance.updateEvento(evento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvento method, of class EventoDaoImplement.
     */
    @Test
    public void testDeleteEvento() {
        System.out.println("deleteEvento");
        int idEvento = 0;
        EventoDaoImplement instance = new EventoDaoImplement();
        instance.deleteEvento(idEvento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
