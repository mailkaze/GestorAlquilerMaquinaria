package Ventanas;

//import Codigo.Clases.Sokolmet;
import java.awt.Desktop;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Formulario_Principal extends javax.swing.JFrame {  
    
    public Formulario_Principal() throws FileNotFoundException, IOException { //Esto es el Constructor, crea un nuevo 'Formulario_Principal'.
        initComponents();
        this.setLocationRelativeTo(null);
        Clases.General.comprobarArchivo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmdCrearCliente = new javax.swing.JButton();
        cmdVerClientes = new javax.swing.JButton();
        cmdCrearAlquiler = new javax.swing.JButton();
        cmdVerAlquileres = new javax.swing.JButton();
        cmdCrearItem = new javax.swing.JButton();
        cmdVerItems = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuCrearCliente = new javax.swing.JMenuItem();
        mnuCrearAlquiler = new javax.swing.JMenuItem();
        mnuCrearItem = new javax.swing.JMenuItem();
        mnuEdicion = new javax.swing.JMenu();
        mnuVerClientes = new javax.swing.JMenuItem();
        mnuVerAlquileres = new javax.swing.JMenuItem();
        mnuVerItems = new javax.swing.JMenuItem();
        mnuVerEstadisticas = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAbrirManual = new javax.swing.JMenuItem();
        mnuCopiaSeguridad = new javax.swing.JMenuItem();
        mnuBajar = new javax.swing.JMenuItem();
        mnuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Alquileres SOKOLMET");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_Sokolmet.png"))); // NOI18N

        cmdCrearCliente.setBackground(new java.awt.Color(51, 102, 255));
        cmdCrearCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdCrearCliente.setText("Crear Nuevo Cliente");
        cmdCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCrearClienteActionPerformed(evt);
            }
        });

        cmdVerClientes.setBackground(new java.awt.Color(51, 102, 255));
        cmdVerClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdVerClientes.setText("Ver Clientes");
        cmdVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerClientesActionPerformed(evt);
            }
        });

        cmdCrearAlquiler.setBackground(new java.awt.Color(51, 255, 102));
        cmdCrearAlquiler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdCrearAlquiler.setText("Crear Nuevo Alquiler");
        cmdCrearAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCrearAlquilerActionPerformed(evt);
            }
        });

        cmdVerAlquileres.setBackground(new java.awt.Color(51, 255, 102));
        cmdVerAlquileres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdVerAlquileres.setText("Ver Alquileres");
        cmdVerAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerAlquileresActionPerformed(evt);
            }
        });

        cmdCrearItem.setBackground(new java.awt.Color(255, 102, 102));
        cmdCrearItem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdCrearItem.setText("Crear Nuevo Item");
        cmdCrearItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCrearItemActionPerformed(evt);
            }
        });

        cmdVerItems.setBackground(new java.awt.Color(255, 102, 102));
        cmdVerItems.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdVerItems.setText("Ver Items");
        cmdVerItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerItemsActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        mnuArchivo.setText("Archivo");

        mnuCrearCliente.setText("Crear Nuevo Cliente");
        mnuCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearClienteActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuCrearCliente);

        mnuCrearAlquiler.setText("Crear Nuevo Alquiler");
        mnuCrearAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearAlquilerActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuCrearAlquiler);

        mnuCrearItem.setText("Crear Nuevo Item");
        mnuCrearItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearItemActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuCrearItem);

        jMenuBar1.add(mnuArchivo);

        mnuEdicion.setText("Ver");

        mnuVerClientes.setText("Ver Clientes");
        mnuVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerClientesActionPerformed(evt);
            }
        });
        mnuEdicion.add(mnuVerClientes);

        mnuVerAlquileres.setText("Ver Alquileres");
        mnuVerAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerAlquileresActionPerformed(evt);
            }
        });
        mnuEdicion.add(mnuVerAlquileres);

        mnuVerItems.setText("Ver Items");
        mnuVerItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerItemsActionPerformed(evt);
            }
        });
        mnuEdicion.add(mnuVerItems);

        mnuVerEstadisticas.setText("Ver Estadísticas");
        mnuVerEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerEstadisticasActionPerformed(evt);
            }
        });
        mnuEdicion.add(mnuVerEstadisticas);

        jMenuBar1.add(mnuEdicion);

        mnuAyuda.setText("Ayuda");

        mnuAbrirManual.setText("Ver el Manual en PDF");
        mnuAbrirManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAbrirManualActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAbrirManual);

        mnuCopiaSeguridad.setText("Hacer copia de seguridad On Line");
        mnuCopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCopiaSeguridadActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuCopiaSeguridad);

        mnuBajar.setText("Importar copia de seguridad");
        mnuBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBajarActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuBajar);

        mnuAcercaDe.setText("Acerca de...");
        mnuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAcercaDe);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdCrearItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdCrearAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(cmdCrearCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdVerClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdVerAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdVerItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdVerClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(cmdCrearAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cmdVerAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdCrearItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdVerItems, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearClienteActionPerformed
        Clases.General.CargarDatos=false;
        Clases.Generar_Dialogos.mostrarCliente();
    }//GEN-LAST:event_mnuCrearClienteActionPerformed

    private void mnuCrearAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearAlquilerActionPerformed
        try {
            Clases.General.AbrirAlquiler=true;
            Clases.Generar_Dialogos.mostrarVerClientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuCrearAlquilerActionPerformed

    private void mnuCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearItemActionPerformed
        Clases.General.CargarDatos=false;
        Clases.Generar_Dialogos.mostrarItem();
    }//GEN-LAST:event_mnuCrearItemActionPerformed

    private void mnuVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerClientesActionPerformed
        try {
            Clases.General.AbrirAlquiler=false;
            Clases.Generar_Dialogos.mostrarVerClientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVerClientesActionPerformed

    private void mnuVerAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerAlquileresActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarVerAlquileres();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVerAlquileresActionPerformed

    private void mnuVerItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerItemsActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarVerItems();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVerItemsActionPerformed

    private void mnuAbrirManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirManualActionPerformed
        try {
            Clases.General.abrirManual();
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo.");
        }
        
    }//GEN-LAST:event_mnuAbrirManualActionPerformed

    private void mnuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcercaDeActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarAcercaDe();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAcercaDeActionPerformed

    private void mnuCopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCopiaSeguridadActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Esta acción sobreescribirá el archivo guardado\nen el SERVIDOR ON LINE, ¿Continuar?")==0){
            Clases.General.subirArchivoPorFTP();
        }
//        try {
//            Clases.Generar_Dialogos.mostrarCargaOnLine();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_mnuCopiaSeguridadActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(null, "¿Desea realizar una copia de seguridad on line ahora?")==0){
            if (JOptionPane.showConfirmDialog(null, "Esta acción sobreescribirá el archivo guardado\nen el SERVIDOR ON LINE, ¿Continuar?")==0){
                Clases.General.subirArchivoPorFTP();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void mnuBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBajarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Esta acción sobreescribirá el archivo SokolmetDB de SU EQUIPO, ¿Continuar?")==0){
                Clases.General.bajarArchivoPorFTP("SokolmetDB");
            }
    }//GEN-LAST:event_mnuBajarActionPerformed

    private void cmdCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearClienteActionPerformed
        Clases.General.CargarDatos=false;
        Clases.Generar_Dialogos.mostrarCliente();
    }//GEN-LAST:event_cmdCrearClienteActionPerformed

    private void cmdCrearAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearAlquilerActionPerformed
        try {
            Clases.General.AbrirAlquiler=true;
            Clases.Generar_Dialogos.mostrarVerClientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCrearAlquilerActionPerformed

    private void cmdCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearItemActionPerformed
        Clases.General.CargarDatos=false;
        Clases.Generar_Dialogos.mostrarItem();
    }//GEN-LAST:event_cmdCrearItemActionPerformed

    private void cmdVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerClientesActionPerformed
        try {
            Clases.General.AbrirAlquiler=false;
            Clases.Generar_Dialogos.mostrarVerClientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdVerClientesActionPerformed

    private void cmdVerAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerAlquileresActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarVerAlquileres();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdVerAlquileresActionPerformed

    private void cmdVerItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerItemsActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarVerItems();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdVerItemsActionPerformed

    private void mnuVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerEstadisticasActionPerformed
        try {
            Clases.Generar_Dialogos.mostrarPassword();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVerEstadisticasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Formulario_Principal().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Formulario_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCrearAlquiler;
    private javax.swing.JButton cmdCrearCliente;
    private javax.swing.JButton cmdCrearItem;
    private javax.swing.JButton cmdVerAlquileres;
    private javax.swing.JButton cmdVerClientes;
    private javax.swing.JButton cmdVerItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenuItem mnuAbrirManual;
    private javax.swing.JMenuItem mnuAcercaDe;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuBajar;
    private javax.swing.JMenuItem mnuCopiaSeguridad;
    private javax.swing.JMenuItem mnuCrearAlquiler;
    private javax.swing.JMenuItem mnuCrearCliente;
    private javax.swing.JMenuItem mnuCrearItem;
    private javax.swing.JMenu mnuEdicion;
    private javax.swing.JMenuItem mnuVerAlquileres;
    private javax.swing.JMenuItem mnuVerClientes;
    private javax.swing.JMenuItem mnuVerEstadisticas;
    private javax.swing.JMenuItem mnuVerItems;
    // End of variables declaration//GEN-END:variables
}