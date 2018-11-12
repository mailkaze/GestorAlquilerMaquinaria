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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author Kaze
 */
public class Dialogo_VerClientes extends javax.swing.JDialog {

    public void cargarTabla() throws FileNotFoundException, IOException{
        Clases.General.ModeloTablaClientes.setRowCount(0);
        Clases.General.ModeloTablaClientes.setColumnCount(0);
        TablaClientes.setModel(Clases.General.ModeloTablaClientes);
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        int NumContactos = Clientes.getLastRowNum();
        Clases.General.ModeloTablaClientes.addColumn("ID");
        Clases.General.ModeloTablaClientes.addColumn("Nombre");
        Clases.General.ModeloTablaClientes.addColumn("Apellidos");
        Clases.General.ModeloTablaClientes.addColumn("C.I.");
        Object Datos[]=new Object[4]; //Numero de columnas de la tabla, es un Array de objetos.
        for (int i=1;i<=NumContactos;i++){//recorre las filas
            for (int j=0;j<4;j++){//reecorre las cuatro primeras columnas.
                if (j==0){
                    Datos[j]=(int)Clientes.getRow(i).getCell(j).getNumericCellValue();
                }
                else{
                    Datos[j]=Clientes.getRow(i).getCell(j);// Cargamos la fila en Datos.
                }
                //System.out.println(Datos[j]);
            }
            Clases.General.ModeloTablaClientes.addRow(Datos); //Añadimos una fila con el Array Datos.
        }
        TablaClientes.setModel(Clases.General.ModeloTablaClientes); //Asignamos el Modelo a la Tabla.
    }
    public void verID(){
        int registro = TablaClientes.getSelectedRow();
        int ID=(int)Clases.General.ModeloTablaClientes.getValueAt(registro, 0);
        Clases.Clientes.ID_Cliente=ID;
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
            HSSFSheet Clientes = libro.getSheetAt(0);
            int NumContactos = Clientes.getLastRowNum();
            Clases.General.ModeloTablaClientes.setRowCount(0);
            Object Datos[]=new Object[4]; //Numero de columnas de la tabla, es un Array de objetos.
            for (int i=1;i<=NumContactos;i++){//recorremos las filas.
                //Por si el usuario escribe seguidos el nombre y apellidos, metemos las celdas 1 y 2 de la fila en una sola variable:
                String Nombre = Clientes.getRow(i).getCell(1).getStringCellValue()+" "+Clientes.getRow(i).getCell(2).getStringCellValue();
                Nombre.trim();
                Nombre=Nombre.toLowerCase();
                Nombre=sinAcentos(Nombre);
                String Palabra="";
                ArrayList<String> Palabras = new ArrayList<String>(); //Un vector dinámico para almacenar palabras.
                for (int k=0;k<Busqueda.length();k++){
                    if (!Busqueda.substring(k,k+1).equals(" ")){
                        Palabra=Palabra+Busqueda.substring(k,k+1); //Recorremos la búsqueda armando palabras.
                    }
                    else{ //Al encontrar espacio termina una palabra y la almacena en el vector.
                        Palabras.add(Palabra);
                        Palabra="";
                    }
                }
                Palabras.add(Palabra); //Al terminar Busqueda almacena la última palabra en el vector.
                Palabra=""; 
                for (int h=0;h<Palabras.size();h++){ //Recorre el vector comparando las palabras con nombres y apellidos del archivo.
                    if (Nombre.contains(Palabras.get(h))){
                        Encontrado=true;
                    }
                    else{ //Si alguna palabra no se encuentra se entiende que no es un nombre y apellidos válido y rompe el bucle.
                        Encontrado=false; 
                        break;
                    }
                }
                if (Encontrado==false){ //Si no se encontró nombre y/o apellidos, buscamos otros campos:
                    for (int j=3;j<=15;j++){ //Buscamos en otros campos, atención al límite del FOR de j.
                        if (j!=10 && j!=11 && j!=14){ //No buscamos en los campos Boolean.
                            String Celda = Clientes.getRow(i).getCell(j).getStringCellValue();
                            Celda.trim();
                            if (Celda.toLowerCase().contains(Busqueda.toLowerCase())){
                                //Comprobamos en cada celda si hay coincidencia.
                                Encontrado=true;
                                break;
                            }
                        }
                    }
                }
            if (Encontrado==true){
                    //Si se encontró coincidencia en esta fila se reescribe la lista.
                for (int j=0;j<4;j++){//reecorre las cuatro primeras columnas.
                    if (j==0){
                        Datos[j]=(int)Clientes.getRow(i).getCell(j).getNumericCellValue();
                    }
                    else{
                        Datos[j]=Clientes.getRow(i).getCell(j);// Cargamos la fila en Datos.
                    }
                }
                Clases.General.ModeloTablaClientes.addRow(Datos); //Añadimos una fila con el Array Datos.
                Encontrado=false;
            }
            }
            TablaClientes.setModel(Clases.General.ModeloTablaClientes);
        }
            else cargarTabla(); //Si se borra el cuadro de búsqueda, vuelve a mostrar la lista completa.
    }
    
    /**
     * Creates new form Dialogo_VerClientes
     */
    public Dialogo_VerClientes(java.awt.Frame parent, boolean modal) throws FileNotFoundException, IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    Dialogo_VerClientes() {
        throw new UnsupportedOperationException("Not yet implemented");
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
        TablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Escriba cualquier dato del cliente que está buscando:");

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "C.I."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getColumn(0).setResizable(false);
        TablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
//        if (evt.getClickCount() == 2) { //Comprueba si es un doble clic.
            try {               
                verID();
                if (Clases.General.AbrirAlquiler==true){
                    this.setVisible(false);
                    Clases.Clientes.abrirCliente();
                    Clases.General.CargarDatos=false;
                    Clases.Generar_Dialogos.mostrarAlquiler();
                }
                else {
                    Clases.Clientes.abrirCliente();
                    Clases.Generar_Dialogos.mostrarCliente();
                    cargarTabla();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }
    }//GEN-LAST:event_TablaClientesMouseClicked

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
            java.util.logging.Logger.getLogger(Dialogo_VerClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Dialogo_VerClientes dialog = new Dialogo_VerClientes(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Dialogo_VerClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
