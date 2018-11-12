/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author Kaze
 */
public class Dialogo_VerAlquileres extends javax.swing.JDialog {
    public void cargarTabla() throws FileNotFoundException, IOException{
        Clases.General.ModeloTablaAlquileres.setRowCount(0);
        Clases.General.ModeloTablaAlquileres.setColumnCount(0);
        TablaAlquileres.setModel(Clases.General.ModeloTablaAlquileres);
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        int NumContactos = Clientes.getLastRowNum();
        int NumAlquileres = Alquileres.getLastRowNum();
        Clases.General.ModeloTablaAlquileres.addColumn("ID");
        Clases.General.ModeloTablaAlquileres.addColumn("Cliente");
        Clases.General.ModeloTablaAlquileres.addColumn("Fecha Inicio");
        Clases.General.ModeloTablaAlquileres.addColumn("Fecha Entrega");
        Clases.General.ModeloTablaAlquileres.addColumn("Dirección");
        Clases.General.ModeloTablaAlquileres.addColumn("¿Pendiente?");
        Object Datos[]=new Object[6]; //Numero de columnas de la tabla, es un Array de objetos.
        for (int i=1;i<=NumAlquileres;i++){//recorre las filas
            if (chkTerminados.isSelected()==false && Alquileres.getRow(i).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
            Datos[0]=(int)Alquileres.getRow(i).getCell(0).getNumericCellValue();
            //Dejamos la posición 1 para el final pues necesita una pequeña búsqueda.
            Datos[2]=Alquileres.getRow(i).getCell(22);
            Datos[3]=Alquileres.getRow(i).getCell(23);
            Datos[4]=Alquileres.getRow(i).getCell(2);
            if (Alquileres.getRow(i).getCell(25).getBooleanCellValue()==true){
                Datos[5]="Si";
            }else Datos[5]="No";
            for (int j=1;j<=NumContactos;j++){
                if (Clientes.getRow(j).getCell(0).getNumericCellValue()==Alquileres.getRow(i).getCell(1).getNumericCellValue()){
                    //Buscamos el cliente que tiene el ID del alquiler que estamos mostrando
                    //Cargamos el campo de la lista con el Nombre y los Apellidos
                    Datos[1]=Clientes.getRow(j).getCell(1)+ " " + Clientes.getRow(j).getCell(2);
                }
            }
            Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
        }
        TablaAlquileres.setModel(Clases.General.ModeloTablaAlquileres); //Asignamos el Modelo a la Tabla.
        }
    }
    public void verID(){
        int registro = TablaAlquileres.getSelectedRow();
        int ID=(int)Clases.General.ModeloTablaAlquileres.getValueAt(registro, 0);
        Clases.Alquileres.ID_Alquiler=ID;
    }
    private String sinAcentos(String Cadena){
        Cadena=Cadena.replaceAll("á", "a");
        Cadena=Cadena.replaceAll("é", "e");
        Cadena=Cadena.replaceAll("í", "i");
        Cadena=Cadena.replaceAll("ó", "o");
        Cadena=Cadena.replaceAll("ú", "u");
        return Cadena;
    }
    private String eliminar0Inicial(String Cadena){
        if (Cadena.startsWith("0")){
            //Si la fecha empieza por 0 lo eliminamos.
            Cadena=Cadena.substring(1);
        }
        return Cadena;
    }
    public void verCliente() throws IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        HSSFSheet Alquileres =libro.getSheetAt(1);
        int NumContactos = Clientes.getLastRowNum();
        int NumAlquileres =Alquileres.getLastRowNum();
        for (int i=1;i<=NumAlquileres;i++){
            if ((int)Alquileres.getRow(i).getCell(0).getNumericCellValue()==Clases.Alquileres.ID_Alquiler){
                //Encontramos el alquiler seleccionado.
                for (int j=1;j<=NumContactos;j++){
                    if (Clientes.getRow(j).getCell(0).getNumericCellValue()==Alquileres.getRow(i).getCell(1).getNumericCellValue()){
                        //Buscamos el cliente que tiene el ID del alquiler seleccionado.
                        //Cargamos las variables de nombre, apellidos y CI para mandarlos al diálogo Alquiler.
                        Clases.Clientes.CNombre=Clientes.getRow(j).getCell(1).getStringCellValue();
                        Clases.Clientes.CApellidos=Clientes.getRow(j).getCell(2).getStringCellValue();
                        Clases.Clientes.CCI=Clientes.getRow(j).getCell(3).getStringCellValue();
                        break; //Encontramos lo que necesitábamos, terminamos el proceso.
                    }
                }
            }
        }
    }
    public void Buscar() throws FileNotFoundException, IOException{
        String Busqueda = txtBuscar.getText();
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        HSSFSheet Alquileres =libro.getSheetAt(1);
        int NumContactos = Clientes.getLastRowNum();
        int NumAlquileres = Alquileres.getLastRowNum();
        String Cadena1=Calendario1.getText();
        String Cadena2=Calendario2.getText();
        Cadena1=Cadena1.replaceAll("-", "/");
        Cadena1=eliminar0Inicial(Cadena1);
        Cadena2=Cadena2.replaceAll("-", "/");
        Cadena2=eliminar0Inicial(Cadena2);
        System.out.println(Cadena1+" "+Cadena2);
        Clases.General.ModeloTablaAlquileres.setRowCount(0);
        Object Datos[]=new Object[6]; //Numero de columnas de la tabla, es un Array de objetos.
        Busqueda.trim();//Eliminamos posibles espacios al principio o final del texto.
        //Se ha cargado en la variable el contenido del cuadro de búsqueda.
        if (!Busqueda.equals("")){
            Busqueda=Busqueda.toLowerCase();
            Busqueda=sinAcentos(Busqueda);
            Boolean Encontrado=false;
            for (int i=1;i<=NumContactos;i++){//recorremos Clientes.
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
                for (int h=1;h<=NumAlquileres;h++){ //recorremos Alquileres.
                    String FechaRegistro1=Alquileres.getRow(h).getCell(22).getStringCellValue();
                    String FechaRegistro2=Alquileres.getRow(h).getCell(23).getStringCellValue();
                    FechaRegistro1=eliminar0Inicial(FechaRegistro1);
                    FechaRegistro2=eliminar0Inicial(FechaRegistro2);
                    //Comprobamos si el alquiler actual tiene el ID del cliente encontrado:
                    if (Alquileres.getRow(h).getCell(1).getNumericCellValue()==Clientes.getRow(i).getCell(0).getNumericCellValue()){
                        if (chkFechaInicio.isSelected()==true){
                            if (chkFechaEntrega.isSelected()==true){
                                if (Cadena1.compareTo(FechaRegistro1)==0 && Cadena2.compareTo(FechaRegistro2)==0){
                                    if (chkTerminados.isSelected()==false && Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                        //Añadimos a la lista los datos interesantes del alquiler:
                                        Datos[0]=(int)Alquileres.getRow(h).getCell(0).getNumericCellValue();
                                        Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                        Datos[2]=Alquileres.getRow(h).getCell(22);
                                        Datos[3]=Alquileres.getRow(h).getCell(23);
                                        Datos[4]=Alquileres.getRow(h).getCell(2);
                                        if (Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true){
                                            Datos[5]="Si";
                                        }else Datos[5]="No";
                                        Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                                    }
                                }
                            }
                            else{ //Está seleccionada la primera fecha pero no la segunda.
                                if (Cadena1.compareTo(FechaRegistro1)==0){
                                    if (chkTerminados.isSelected()==false && Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                        //Añadimos a la lista los datos interesantes del alquiler:
                                        Datos[0]=(int)Alquileres.getRow(h).getCell(0).getNumericCellValue();
                                        Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                        Datos[2]=Alquileres.getRow(h).getCell(22);
                                        Datos[3]=Alquileres.getRow(h).getCell(23);
                                        Datos[4]=Alquileres.getRow(h).getCell(2);
                                        if (Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true){
                                            Datos[5]="Si";
                                        }else Datos[5]="No";
                                        Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                                    }
                                }
                            }
                        }
                        else if (chkFechaEntrega.isSelected()==true){
                            if (Cadena2.compareTo(FechaRegistro2)==0){
                                    if (chkTerminados.isSelected()==false && Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                        //Añadimos a la lista los datos interesantes del alquiler:
                                        Datos[0]=(int)Alquileres.getRow(h).getCell(0).getNumericCellValue();
                                        Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                        Datos[2]=Alquileres.getRow(h).getCell(22);
                                        Datos[3]=Alquileres.getRow(h).getCell(23);
                                        Datos[4]=Alquileres.getRow(h).getCell(2);
                                        if (Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true){
                                            Datos[5]="Si";
                                        }else Datos[5]="No";
                                        Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                                    }
                                }
                        }
                        else{ //No hay fechas seleccionadas.
                            //Solo mostramos los Pendientes a no ser que se indique lo contrario en la casilla:
                            if (chkTerminados.isSelected()==false && Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                //Añadimos a la lista los datos interesantes del alquiler:
                                Datos[0]=(int)Alquileres.getRow(h).getCell(0).getNumericCellValue();
                                Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);;
                                Datos[2]=Alquileres.getRow(h).getCell(22);
                                Datos[3]=Alquileres.getRow(h).getCell(23);
                                Datos[4]=Alquileres.getRow(h).getCell(2);
                                if (Alquileres.getRow(h).getCell(25).getBooleanCellValue()==true){
                                    Datos[5]="Si";
                                }else Datos[5]="No";
                                Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                            }
                        }
                        Encontrado=false;
                    }                  
                }              
            }
            }
            TablaAlquileres.setModel(Clases.General.ModeloTablaAlquileres); 
        }
        else{ //El campo de búsqueda está en blanco.
            for (int g=0;g<=NumAlquileres;g++){ //Recorremos Alquileres para buscar las fechas, sin nombres.
                String FechaRegistro1=Alquileres.getRow(g).getCell(22).getStringCellValue();
                String FechaRegistro2=Alquileres.getRow(g).getCell(23).getStringCellValue();
                FechaRegistro1=eliminar0Inicial(FechaRegistro1);
                FechaRegistro2=eliminar0Inicial(FechaRegistro2);
                    
                if (chkFechaInicio.isSelected()==true){
                    if (chkFechaEntrega.isSelected()==true){
                        if (Cadena1.compareTo(FechaRegistro1)==0 && Cadena2.compareTo(FechaRegistro2)==0){
                            if (chkTerminados.isSelected()==false && Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                //Añadimos a la lista los datos interesantes del alquiler:
                                Datos[0]=(int)Alquileres.getRow(g).getCell(0).getNumericCellValue();
                                //Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                Datos[2]=Alquileres.getRow(g).getCell(22);
                                Datos[3]=Alquileres.getRow(g).getCell(23);
                                Datos[4]=Alquileres.getRow(g).getCell(2);
                                if (Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true){
                                    Datos[5]="Si";
                                }else Datos[5]="No";
                                for (int f=1;f<=NumContactos;f++){
                                    if (Clientes.getRow(f).getCell(0).getNumericCellValue()==Alquileres.getRow(g).getCell(1).getNumericCellValue()){
                                        //Buscamos el cliente que tiene el ID del alquiler que estamos mostrando
                                        //Cargamos el campo de la lista con el Nombre y los Apellidos
                                        Datos[1]=Clientes.getRow(f).getCell(1)+ " " + Clientes.getRow(f).getCell(2);
                                    }
                                }
                                Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                            }
                        }
                    }
                    else{ //Está seleccionada la primera fecha pero no la segunda.
                        if (Cadena1.compareTo(FechaRegistro1)==0){
                            if (chkTerminados.isSelected()==false && Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                //Añadimos a la lista los datos interesantes del alquiler:
                                Datos[0]=(int)Alquileres.getRow(g).getCell(0).getNumericCellValue();
                                //Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                Datos[2]=Alquileres.getRow(g).getCell(22);
                                Datos[3]=Alquileres.getRow(g).getCell(23);
                                Datos[4]=Alquileres.getRow(g).getCell(2);
                                if (Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true){
                                    Datos[5]="Si";
                                }else Datos[5]="No";
                                for (int f=1;f<=NumContactos;f++){
                                    if (Clientes.getRow(f).getCell(0).getNumericCellValue()==Alquileres.getRow(g).getCell(1).getNumericCellValue()){
                                        //Buscamos el cliente que tiene el ID del alquiler que estamos mostrando
                                        //Cargamos el campo de la lista con el Nombre y los Apellidos
                                        Datos[1]=Clientes.getRow(f).getCell(1)+ " " + Clientes.getRow(f).getCell(2);
                                    }
                                }
                                Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                            }
                        }
                    }
                }
                else if (chkFechaEntrega.isSelected()==true){ //Solo está seleccionada la segunda fecha.
                    if (Cadena2.compareTo(FechaRegistro2)==0){
                            if (chkTerminados.isSelected()==false && Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true || chkTerminados.isSelected()==true){
                                //Añadimos a la lista los datos interesantes del alquiler:
                                Datos[0]=(int)Alquileres.getRow(g).getCell(0).getNumericCellValue();
                                //Datos[1]=Clientes.getRow(i).getCell(1)+ " " + Clientes.getRow(i).getCell(2);
                                Datos[2]=Alquileres.getRow(g).getCell(22);
                                Datos[3]=Alquileres.getRow(g).getCell(23);
                                Datos[4]=Alquileres.getRow(g).getCell(2);
                                if (Alquileres.getRow(g).getCell(25).getBooleanCellValue()==true){
                                    Datos[5]="Si";
                                }else Datos[5]="No";
                                for (int f=1;f<=NumContactos;f++){
                                    if (Clientes.getRow(f).getCell(0).getNumericCellValue()==Alquileres.getRow(g).getCell(1).getNumericCellValue()){
                                        //Buscamos el cliente que tiene el ID del alquiler que estamos mostrando
                                        //Cargamos el campo de la lista con el Nombre y los Apellidos
                                        Datos[1]=Clientes.getRow(f).getCell(1)+ " " + Clientes.getRow(f).getCell(2);
                                    }
                                }
                                Clases.General.ModeloTablaAlquileres.addRow(Datos); //Añadimos una fila con el Array Datos.
                            }
                        }
                }
                else{ //No hay fechas seleccionadas ni texto a buscar.
                        cargarTabla();//Si se borra el cuadro de búsqueda, vuelve a mostrar la lista completa.
                }
            }
        } 
    }
    /**
     * Creates new form Dialogo_VerAlquileres
     */
    public Dialogo_VerAlquileres(java.awt.Frame parent, boolean modal) throws FileNotFoundException, IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        Calendario1.setVisible(false);
        Calendario2.setVisible(false);
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
        txtBuscar = new javax.swing.JTextField();
        chkTerminados = new javax.swing.JCheckBox();
        Calendario1 = new datechooser.beans.DateChooserCombo();
        Calendario2 = new datechooser.beans.DateChooserCombo();
        chkFechaInicio = new javax.swing.JCheckBox();
        chkFechaEntrega = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlquileres = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alquileres");
        setResizable(false);

        jLabel1.setText("Escriba cualquier dato del cliente del Alquiler que está buscando:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        chkTerminados.setText("Ver también los Alquileres terminados.");
        chkTerminados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkTerminadosMouseReleased(evt);
            }
        });

        Calendario1.setCalendarPreferredSize(new java.awt.Dimension(336, 260));
        Calendario1.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                Calendario1OnCommit(evt);
            }
        });

        Calendario2.setCalendarPreferredSize(new java.awt.Dimension(336, 260));
        Calendario2.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                Calendario2OnCommit(evt);
            }
        });

        chkFechaInicio.setText("Incluir Fecha de Inicio en la búsqueda.");
        chkFechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkFechaInicioMouseReleased(evt);
            }
        });

        chkFechaEntrega.setText("Incluir Fecha de Entrega en la búsqueda.");
        chkFechaEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkFechaEntregaMouseReleased(evt);
            }
        });

        TablaAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Alquiler", "Cliente", "Fecha Inicio", "Fecha Entrega", "Dirección", "¿Pendiente?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAlquileresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaAlquileres);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkFechaInicio)
                                .addGap(18, 18, 18)
                                .addComponent(Calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkFechaEntrega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Calendario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkTerminados))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkFechaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFechaEntrega)
                    .addComponent(Calendario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkTerminados)
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

    private void chkTerminadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTerminadosMouseReleased
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkTerminadosMouseReleased

    private void chkFechaInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkFechaInicioMouseReleased
        if (chkFechaInicio.isSelected()==true){
            Calendario1.setVisible(true);
        }else Calendario1.setVisible(false);
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkFechaInicioMouseReleased

    private void chkFechaEntregaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkFechaEntregaMouseReleased
        if (chkFechaEntrega.isSelected()==true){
            Calendario2.setVisible(true);
        }else Calendario2.setVisible(false);
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkFechaEntregaMouseReleased

    private void Calendario1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_Calendario1OnCommit
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Calendario1OnCommit

    private void Calendario2OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_Calendario2OnCommit
        try {
            Buscar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Calendario2OnCommit

    private void TablaAlquileresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlquileresMouseClicked
        //        if (evt.getClickCount() == 2) { //Comprueba si es un doble clic.
        try {
            verID();
            verCliente();
            Clases.Alquileres.abrirAlquiler();
            Clases.Generar_Dialogos.mostrarAlquiler();
            cargarTabla();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogo_VerClientes.class.getName()).log
        (Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo 'SokolmetDB'.");
        } catch (IOException ex) {
            Logger.getLogger(Dialogo_VerClientes.class.getName()).log
        (Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    //        }
    }//GEN-LAST:event_TablaAlquileresMouseClicked

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
            java.util.logging.Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Dialogo_VerAlquileres dialog = new Dialogo_VerAlquileres(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Dialogo_VerAlquileres.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Calendario1;
    private datechooser.beans.DateChooserCombo Calendario2;
    private javax.swing.JTable TablaAlquileres;
    private javax.swing.JCheckBox chkFechaEntrega;
    private javax.swing.JCheckBox chkFechaInicio;
    private javax.swing.JCheckBox chkTerminados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
