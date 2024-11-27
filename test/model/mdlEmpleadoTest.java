/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ctrEmpleado;
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
public class mdlEmpleadoTest {
    
    public mdlEmpleadoTest() {
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
     * Test of mostrar method, of class mdlEmpleado.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        String buscar = "";
        mdlEmpleado instance = new mdlEmpleado();
        DefaultTableModel expResult = new DefaultTableModel();
        expResult.addColumn("Columna1");
        expResult.addColumn("Columna2");
        expResult.addColumn("Columna3");
        expResult.addColumn("Columna4");
        expResult.addColumn("Columna5");
        expResult.addColumn("Columna6");
        expResult.addColumn("Columna7");
        expResult.addColumn("Columna8");
        expResult.addColumn("Columna9");
        expResult.addColumn("Columna10");
        expResult.addColumn("Columna11");
        expResult.addColumn("Columna12");
        expResult.addColumn("Columna13");
        
        // Añadir filas de ejemplo según lo que debería devolver el método 'mostrar'
        expResult.addRow(new Object[]{"13","Cédula ciudadanía","1021930524","Julian Andrés","Otalvaro Gutierrez","juano@hotmail.com","3176679010","Carrera 81 # 49 - 54","Recepcionista","1600000.0","jandres","1","2024-11-01 15:36:07","jandres123"});
        expResult.addRow(new Object[]{"12","Seleccione un opción","70510189","Juan Carlos","Posada López","juanc@gmail.com","30045987845","Carrera 65 # 25 - 16","Administrador","1600000.0","juanc","1","2024-11-01 12:40:59","juanc1234"});
       
        DefaultTableModel result = instance.mostrar(buscar);
        assertNotNull("El modelo no debería ser null", result);
        assertEquals(expResult.getColumnCount(), result.getColumnCount());
        assertEquals(expResult.getRowCount(), result.getRowCount());
        for (int i = 0; i < expResult.getRowCount(); i++) { 
            for (int j = 0; j < expResult.getColumnCount(); j++) { 
                assertEquals(expResult.getValueAt(i, j), result.getValueAt(i, j)); 
            } 
        } 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class mdlEmpleado.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ctrEmpleado dts = null;
        mdlEmpleado instance = new mdlEmpleado();
        boolean expResult = false;
        boolean result = instance.insertar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class mdlEmpleado.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        ctrEmpleado dts = null;
        mdlEmpleado instance = new mdlEmpleado();
        boolean expResult = false;
        boolean result = instance.editar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class mdlEmpleado.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ctrEmpleado dts = null;
        mdlEmpleado instance = new mdlEmpleado();
        boolean expResult = false;
        boolean result = instance.eliminar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class mdlEmpleado.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String login = "juanc";
        String password = "juanc1234";
        mdlEmpleado instance = new mdlEmpleado();
        DefaultTableModel expResult = new DefaultTableModel();
        expResult.addColumn("Columna1");
        expResult.addColumn("Columna2");
        //expResult.addColumn("Columna3");
        
        // Añadir filas de ejemplo según lo que debería devolver el método 'login'
        expResult.addRow(new Object[]{"13","Cédula ciudadanía","1021930524","Julian Andrés","Otalvaro Gutierrez","juano@hotmail.com","3176679010","Carrera 81 # 49 - 54","Recepcionista","1600000.0","jandres","1","2024-11-01 15:36:07","jandres123"});
        expResult.addRow(new Object[]{"12","Seleccione un opción","70510189","Juan Carlos","Posada López","juanc@gmail.com","30045987845","Carrera 65 # 25 - 16","Administrador","1600000.0","juanc","1","2024-11-01 12:40:59","juanc1234"});
        DefaultTableModel result = instance.login(login, password);
        // Asegúrate de que 'result' no sea nulo 
        assertNotNull("El modelo no debería ser null", result);
        assertEquals(expResult, result);
        assertEquals(expResult.getColumnCount(), result.getColumnCount());
        assertEquals(expResult.getRowCount(), result.getRowCount());
        for (int i = 0; i < expResult.getRowCount(); i++) { 
            for (int j = 0; j < expResult.getColumnCount(); j++) { 
                assertEquals(expResult.getValueAt(i, j), result.getValueAt(i, j)); 
            } 
        } 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
