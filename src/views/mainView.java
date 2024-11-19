/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import forms.frmCotizar;
import forms.frmEmpleados;
import forms.frmMarca;
import forms.frmPrecioporServicio;
import forms.frmPropietario;
import forms.frmVehiculo;


/**
 *
 * @author alsan
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
        this.setExtendedState(mainView.MAXIMIZED_BOTH);
        this.setTitle("Sistema gestión taller JM");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        mnuEmpleado = new javax.swing.JMenuItem();
        mnuPropietarios = new javax.swing.JMenuItem();
        mnuProveedores = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        jmnMarcaVehiculo = new javax.swing.JMenuItem();
        jmnPreciosServicios = new javax.swing.JMenuItem();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(102, 255, 102));

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Persona");

        mnuEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trabajadores.png"))); // NOI18N
        mnuEmpleado.setMnemonic('t');
        mnuEmpleado.setText("Empleados");
        mnuEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuEmpleadoMouseClicked(evt);
            }
        });
        mnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadoActionPerformed(evt);
            }
        });
        editMenu.add(mnuEmpleado);

        mnuPropietarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        mnuPropietarios.setMnemonic('y');
        mnuPropietarios.setText("Propietarios");
        mnuPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPropietariosActionPerformed(evt);
            }
        });
        editMenu.add(mnuPropietarios);

        mnuProveedores.setMnemonic('p');
        mnuProveedores.setText("Proveedores");
        editMenu.add(mnuProveedores);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Acciones");

        jmnMarcaVehiculo.setText("Marcas");
        jmnMarcaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnMarcaVehiculoActionPerformed(evt);
            }
        });
        helpMenu.add(jmnMarcaVehiculo);

        jmnPreciosServicios.setText("Precios servicios");
        jmnPreciosServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnPreciosServiciosActionPerformed(evt);
            }
        });
        helpMenu.add(jmnPreciosServicios);

        contentMenuItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Vehículo");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Cotización");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void mnuEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEmpleadoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuEmpleadoMouseClicked

    private void mnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadoActionPerformed
        // TODO add your handling code here:
       frmEmpleados form = new frmEmpleados();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_mnuEmpleadoActionPerformed

    private void mnuPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPropietariosActionPerformed
        // TODO add your handling code here:
        frmPropietario form = new frmPropietario();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_mnuPropietariosActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        frmVehiculo form = new frmVehiculo();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        frmCotizar form = new frmCotizar();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jmnPreciosServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnPreciosServiciosActionPerformed
        // TODO add your handling code here:
        frmPrecioporServicio form = new frmPrecioporServicio();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jmnPreciosServiciosActionPerformed

    private void jmnMarcaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnMarcaVehiculoActionPerformed
        // TODO add your handling code here:
        frmMarca form = new frmMarca();
        mainPane.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jmnMarcaVehiculoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jmnMarcaVehiculo;
    private javax.swing.JMenuItem jmnPreciosServicios;
    private javax.swing.JDesktopPane mainPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuEmpleado;
    private javax.swing.JMenuItem mnuPropietarios;
    private javax.swing.JMenuItem mnuProveedores;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}