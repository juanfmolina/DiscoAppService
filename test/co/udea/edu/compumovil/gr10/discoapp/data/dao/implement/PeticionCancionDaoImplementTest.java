/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.dao.implement;


import co.udea.edu.compumovil.gr10.discoapp.domain.entities.SolicitudCancion;
import co.udea.edu.compumovil.gr10.discoapp.domain.entities.Usuario;
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
public class PeticionCancionDaoImplementTest {

    public PeticionCancionDaoImplementTest() {
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
     * Test of insertPeticion method, of class PeticionCancionDaoImplement.
     */
    @Test
    public void testInsertPeticion() {
        System.out.println("insertPeticion");
        Usuario u = new Usuario("juanf.molina", null, null, null, null, null);
        SolicitudCancion solicitud = new SolicitudCancion(u, "Lo que hay", "En Espera");
        PeticionCancionDaoImplement instance = new PeticionCancionDaoImplement();
        instance.insertPeticion(solicitud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeticion method, of class PeticionCancionDaoImplement.
     */
    @Test
    public void testGetPeticion() {
        System.out.println("getPeticion");
        int idSolicitud = 1;
        PeticionCancionDaoImplement instance = new PeticionCancionDaoImplement();
        int expResult = 1;
        SolicitudCancion result = instance.getPeticion(idSolicitud);
        assertEquals(expResult, (int) result.getIdPeticionCancion());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllSolicitudes method, of class PeticionCancionDaoImplement.
     */
    @Test
    public void testGetAllSolicitudes() {
        System.out.println("getAllSolicitudes");
        PeticionCancionDaoImplement instance = new PeticionCancionDaoImplement();
        int expResult = 1;
        List<SolicitudCancion> result = instance.getAllSolicitudes();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getSolicitudByUsuario method, of class
     * PeticionCancionDaoImplement.
     */
    @Test
    public void testGetSolicitudByUsuario() {
        System.out.println("getSolicitudByUsuario");
        String idUsuario = "juanf.molina";
        PeticionCancionDaoImplement instance = new PeticionCancionDaoImplement();
        List<SolicitudCancion> result = instance.getSolicitudByUsuario(idUsuario);
        assertEquals(idUsuario, result.get(0).getUsuario().getIdUsuario());
        // TODO review the generated test code and remove the default call to fail.
        
    }

}
