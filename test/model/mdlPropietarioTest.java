/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ctrPropietario;
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
public class mdlPropietarioTest {
    
    public mdlPropietarioTest() {
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
     * Test of mostrar method, of class mdlPropietario.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        String buscar = "";
        mdlPropietario instance = new mdlPropietario();
        DefaultTableModel expResult = new DefaultTableModel();
        expResult.addColumn("Columna1");
        expResult.addColumn("Columna2");
        expResult.addColumn("Columna3");
        expResult.addColumn("Columna4");
        expResult.addColumn("Columna5");
        expResult.addColumn("Columna6");
        expResult.addColumn("Columna7");
        expResult.addColumn("Columna8");
        
        // Añadir filas de ejemplo según lo que debería devolver el método 'mostrar'
        expResult.addRow(new Object[]{"25","Cédula ciudadanía","36508253","Jorge Eliecer", "Rodriguez Zapata","maecha@hotmail.com","3121023648","Carrera 36 # 123 - 15","1","2024-11-04 19:14:44"});
        expResult.addRow(new Object[]{"21","Cédula ciudadanía", "98258147","Juan Carlos", "Areiza Zapata","juanc@hotmail.com","3001592648","calle 84","1","2024-11-04 16:54:16"});
        expResult.addRow(new Object[]{"18","Cédula ciudadanía", "10121910256","Pablo Andrés", "Molina Vazquez","pablo@hotmail.com","3125874769", "Calle 107 # 43 - 16","1","2024-11-04 12:46:59"});
        expResult.addRow(new Object[]{"17","Cédula ciudadanía", "98617630","Hector Dario","Calle Molina","hector@hotmail.com","3006175487","Calle 34 # 80 - 36","1","2024-11-04 12:25:02"});
        expResult.addRow(new Object[]{"16","Seleccione una opción","32507701","Miguel Angel","Zapata Alavarez","migue@hotmail.com","3016328574","Vereda el Tonusco","1","2024-11-01 16:10:25"});
        expResult.addRow(new Object[]{"15","Seleccione un opción","70120356","Carlos Mauricio","Sánchez Zapata","cmauricio@gmail.com","3152473656","Calle 107 # 87 - 241","1","2024-11-01 15:51:53"});

        DefaultTableModel result = instance.mostrar(buscar);
        assertNotNull("El modelo no debería ser null", result);
        assertEquals(expResult.getColumnCount(), result.getColumnCount());
        assertEquals(expResult.getRowCount(), result.getRowCount());
        // Verificar el contenido de cada celda si es necesario
        for (int i = 0; i < expResult.getRowCount(); i++) { 
            for (int j = 0; j < expResult.getColumnCount(); j++) { 
                assertEquals(expResult.getValueAt(i, j), result.getValueAt(i, j)); 
            } 
        } 
    
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class mdlPropietario.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ctrPropietario dts = null;
        mdlPropietario instance = new mdlPropietario();
        boolean expResult = false;
        boolean result = instance.insertar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class mdlPropietario.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        ctrPropietario dts = null;
        mdlPropietario instance = new mdlPropietario();
        boolean expResult = false;
        boolean result = instance.editar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class mdlPropietario.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ctrPropietario dts = null;
        mdlPropietario instance = new mdlPropietario();
        boolean expResult = false;
        boolean result = instance.eliminar(dts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
