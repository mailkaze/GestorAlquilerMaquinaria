/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

//import Codigo.Clases.Sokolmet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author Kaze
 */
public class Dialogo_VerItems extends javax.swing.JDialog {

    public void cargarTabla() throws FileNotFoundException, IOException{
        Clases.General.ModeloTablaItems.setRowCount(0);
        Clases.General.ModeloTablaItems.setColumnCount(0);
        TablaItems.setModel(Clases.General.ModeloTablaItems);
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        int NumContactos = Items.getLastRowNum();
        Clases.General.ModeloTablaItems.addColumn("ID");
        Clases.General.ModeloTablaItems.addColumn("Nombre");
        Clases.General.ModeloTablaItems.addColumn("Precio");
        Clases.General.ModeloTablaItems.addColumn("Stock Actual");
        Object Datos[]=new Object[4]; //Numero de columnas de la tabla, es un Array de objetos.
        for (int i=1;i<=NumContactos;i++){//recorre las filas
            Datos[0]=(int)Items.getRow(i).getCell(0).getNumericCellValue();
            Datos[1]=Items.getRow(i).getCell(1).getRichStringCellValue();
            Datos[2]=Items.getRow(i).getCell(2).getNumericCellValue();
            Datos[3]=Clases.General.calcularStockDisponible(i); //Muestra stock disponible, no el dato que hay en la tabla.
            Clases.General.ModeloTablaItems.addRow(Datos); //Añadimos una fila con el Array Datos.
        }
        TablaItems.setModel(Clases.General.ModeloTablaItems); //Asignamos el Modelo a la Tabla.
    }
    
    public void verID(){
        int registro = TablaItems.getSelectedRow();
        int ID=(int)Clases.General.ModeloTablaItems.getValueAt(registro, 0);
        Clases.Items.ID_Item=ID;
    }
    private String sinAcentos(String Cadena){
        Cadena=Cadena.replaceAll("á", "a");
        Cadena=Cadena.replaceAll("é", "e");
        Cadena=Cadena.replaceAll("í", "i");
        Cadena=Cadena.replaceAll("ó", "o");
        Cadena=Cadena.replaceAll("ú", "u");
        System.out.println(Cadena);
        return Cadena;
    }
    public void Buscar() throws FileNotFoundException, IOException{
        String Busqueda = txtBuscar.getText();
        Busqueda.trim();//Eliminamos posibles espacios al principio o final del texto.
        //Se ha cargado en la variable el contenido del cuadro de búsqueda.
        if (!Busqueda.equals("")){
            Busqueda=Busqueda.toLowerCase();
            Busqueda=sinAcentos(Busqueda);
            Boolean Encontrado=false;
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
            HSSFWorkbook libro = new HSSFWorkbook(fs);
            HSSFSheet Items = libro.getSheetAt(2);
            int NumRegistros = Items.getLastRowNum();
            Clases.General.ModeloTablaItems.setRowCount(0);
            Object Datos[]=new Object[4]; //Numero de columnas de la tabla, es un Array de objetos.
            for (int i=1;i<=NumRegistros;i++){//recorremos las filas.                 
                String Celda1 = Items.getRow(i).getCell(1).getStringCellValue();
                Celda1.trim();
                Celda1=Celda1.toLowerCase();
                Celda1=sinAcentos(Celda1);
                if (Celda1.contains(Busqueda)){
                    //Comprobamos en cada celda si hay coincidencia.
                    Encontrado=true;
                }
                String Celda2 = String.valueOf(Items.getRow(i).getCell(2).getNumericCellValue());
                Celda2.trim();
                if (Celda2.toLowerCase().contains(Busqueda.toLowerCase())){
                    //Comprobamos en cada celda si hay coincidencia.
                    Encontrado=true;
                }
                String Celda3 = String.valueOf(Items.getRow(i).getCell(3).getNumericCellValue());
                Celda3.trim();
                if (Celda3.toLowerCase().contains(Busqueda.toLowerCase())){
                    //Comprobamos en cada celda si hay coincidencia.
                    Encontrado=true;
                }
                if (Encontrado==true){
                    Datos[0]=(int)Items.getRow(i).getCell(0).getNumericCellValue();
                    Datos[1]=Items.getRow(i).getCell(1).getRichStringCellValue();
                    Datos[2]=Items.getRow(i).getCell(2).getNumericCellValue();
                    Datos[3]=Items.getRow(i).getCell(3).getNumericCellValue();
                    Clases.General.ModeloTablaItems.addRow(Datos); //Añadimos una fila con el Array Datos.
                    Encontrado=false;
                }
            }
            TablaItems.setModel(Clases.General.ModeloTablaItems);
        }
            else cargarTabla(); //Si se borra el cuadro de búsqueda, vuelve a mostrar la lista completa.
    }
    /**
     * Creates new form Dialogo_VerItems
     */
    public Dialogo_VerItems(java.awt.Frame parent, boolean modal) throws FileNotFoundException, IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Items");
        setResizable(false);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Escriba cualquier dato del item que está buscando:");

        TablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void TablaItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaItemsMouseClicked
        //        if (evt.getClickCount() == 2) { //Comprueba si es un doble clic.
            try {               
                verID();
                Clases.Items.abrirItem();
                Clases.Generar_Dialogos.mostrarItem();
                cargarTabla();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }
    }//GEN-LAST:event_TablaItemsMouseClicked

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
            java.util.logging.Logger.getLogger(Dialogo_VerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Dialogo_VerItems dialog = new Dialogo_VerItems(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Dialogo_VerItems.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Dialogo_VerItems.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
