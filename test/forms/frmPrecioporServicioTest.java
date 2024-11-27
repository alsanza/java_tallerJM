/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alsan
 */
public class frmPrecioporServicioTest {
    
    public frmPrecioporServicioTest() {
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
     * Test of cargarCombo method, of class frmPrecioporServicio.
     */
    @Test
    public void testCargarCombo() {
        System.out.println("cargarCombo");
        frmPrecioporServicio instance = new frmPrecioporServicio();
        instance.cargarCombo();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ocultar_columnas method, of class frmPrecioporServicio.
     */
    @Test
    public void testOcultar_columnas() {
        System.out.println("ocultar_columnas");
        frmPrecioporServicio instance = new frmPrecioporServicio();
        instance.ocultar_columnas();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inhabilitar method, of class frmPrecioporServicio.
     */
    @Test
    public void testInhabilitar() {
        System.out.println("inhabilitar");
        frmPrecioporServicio instance = new frmPrecioporServicio();
        instance.inhabilitar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of habilitar method, of class frmPrecioporServicio.
     */
    @Test
    public void testHabilitar() {
        System.out.println("habilitar");
        frmPrecioporServicio instance = new frmPrecioporServicio();
        instance.habilitar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class frmPrecioporServicio.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        String buscar = "";
        frmPrecioporServicio instance = new frmPrecioporServicio();
        instance.mostrar(buscar);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class frmPrecioporServicio.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        frmPrecioporServicio.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
