/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ctrPrecioPieza;
import javax.swing.table.DefaultTableModel;
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
public class mdlPrecioPorPiezaTest {
    
    public mdlPrecioPorPiezaTest() {
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
     * Test of mostrar method, of class mdlPrecioPorPieza.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        String buscar = "";
        mdlPrecioPorPieza instance = new mdlPrecioPorPieza();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.mostrar(buscar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class mdlPrecioPorPieza.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ctrPrecioPieza dts = null;
        mdlPrecioPorPieza instance = new mdlPrecioPorPieza();
        boolean expResult = false;
        boolean result = instance.insertar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class mdlPrecioPorPieza.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        ctrPrecioPieza dts = null;
        mdlPrecioPorPieza instance = new mdlPrecioPorPieza();
        boolean expResult = false;
        boolean result = instance.editar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class mdlPrecioPorPieza.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ctrPrecioPieza dts = null;
        mdlPrecioPorPieza instance = new mdlPrecioPorPieza();
        boolean expResult = false;
        boolean result = instance.eliminar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
