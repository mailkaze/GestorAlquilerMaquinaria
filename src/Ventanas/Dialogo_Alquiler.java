/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Crear_Despacho;
import Clases.Crear_Recepcion;
import Clases.Alquileres;
import Clases.General;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import Clases.General;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Kaze
 */
public class Dialogo_Alquiler extends javax.swing.JDialog {
    Boolean EsNuevo=true;
    Boolean habilitar=false;
    ArrayList<Integer> Stocks = new ArrayList<>(); //Almacena los stocks disponibles de todos los items.
    
    private void habilitarDeshabilitar(Boolean b){
        txtDestino.setEditable(b);
        txtTelfDestino.setEditable(b);
        txtCantidad1.setEnabled(b);
        txtCantidad2.setEnabled(b);
        txtCantidad3.setEnabled(b);
        txtCantidad4.setEnabled(b);
        txtCantidad5.setEnabled(b);
        txtCantidad6.setEnabled(b);
        txtMonto1.setEditable(b);
        txtMonto2.setEditable(b);
        txtMonto3.setEditable(b);
        txtMonto4.setEditable(b);
        txtMonto5.setEditable(b);
        txtMonto6.setEditable(b);
        txtDias.setEditable(b);
        calendario1.setEnabled(b);
        calendario2.setEnabled(b);
        txtTotal.setEditable(b);
        txtComentarios.setEditable(b);
        cboItem1.setEnabled(b);
        cboItem2.setEnabled(b);
        cboItem3.setEnabled(b);
        cboItem4.setEnabled(b);
        cboItem5.setEnabled(b);
        cboItem6.setEnabled(b);
        cmdGuardar.setEnabled(b);
        mnuGuardar.setEnabled(b);
        txtAC.setEditable(b);
        txtNumDep.setEditable(b);
        calendario3.setEnabled(b);      
    }
    
    
    private void cargarDatos(){
        if (Clases.General.CargarDatos==true){
//            int dia,mes,ano;
//            Calendar fecha=Calendar.getInstance();
//            String Cadena="";
//            ArrayList<String> Cadenas = new ArrayList<String>();
            cboItem1.setSelectedItem(Clases.Alquileres.AItem1);
            cboItem2.setSelectedItem(Clases.Alquileres.AItem2);
            cboItem3.setSelectedItem(Clases.Alquileres.AItem3);
            cboItem4.setSelectedItem(Clases.Alquileres.AItem4);
            cboItem5.setSelectedItem(Clases.Alquileres.AItem5);
            cboItem6.setSelectedItem(Clases.Alquileres.AItem6);
            txtCantidad1.setValue((int)Clases.Alquileres.ACant1);
            txtCantidad2.setValue((int)Clases.Alquileres.ACant2);
            txtCantidad3.setValue((int)Clases.Alquileres.ACant3);
            txtCantidad4.setValue((int)Clases.Alquileres.ACant4);
            txtCantidad5.setValue((int)Clases.Alquileres.ACant5);
            txtCantidad6.setValue((int)Clases.Alquileres.ACant6);
            txtMonto1.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto1)));
            txtMonto2.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto2)));
            txtMonto3.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto3)));
            txtMonto4.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto4)));
            txtMonto5.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto5)));
            txtMonto6.setText(String.valueOf(General.redondear(Clases.Alquileres.AMonto6)));
//            for (int i=0;i<Clases.Alquileres.AFecha1.length();i++){//recorremos el string AFecha para sacar los numeros y separarlos(dia,mes,año)
//                if (!Clases.Alquileres.AFecha1.substring(i,i+1).equals("/")){ //Si es un número
//                    Cadena=Cadena+Clases.Alquileres.AFecha1.substring(i,i+1); //Recorremos la búsqueda armando palabras.
//                }
//                else{ //Al encontrar la barra inclinada carga la variable en el array.
//                    Cadenas.add(Cadena);
//                    Cadena="";
//                }
//            }
//            Cadenas.add(Cadena);
//            Cadena="";//Al terminar de recorrer la fecha también cargamos variable.
//            ano=Integer.parseInt(Cadenas.get(2));
//            mes=Integer.parseInt(Cadenas.get(1));
//            dia=Integer.parseInt(Cadenas.get(0));
//            fecha.set(ano, mes-1, dia);
//            calendario1.setSelectedDate(fecha);
            calendario1.setText(Clases.Alquileres.AFecha1);
//            Cadenas.clear();
//            for (int i=0;i<Clases.Alquileres.AFecha2.length();i++){//recorremos el string AFecha para sacar los numeros y separarlos(dia,mes,año)
//                if (!Clases.Alquileres.AFecha2.substring(i,i+1).equals("/")){ //Si es un número
//                    Cadena=Cadena+Clases.Alquileres.AFecha2.substring(i,i+1); //Recorremos la búsqueda armando palabras.
//                }
//                else{ //Al encontrar la barra inclinada carga la variable en el array.
//                    Cadenas.add(Cadena);
//                    Cadena="";
//                }
//            }
//            Cadenas.add(Cadena);
//            Cadena="";//Al terminar de recorrer la fecha también cargamos variable.
//            ano=Integer.parseInt(Cadenas.get(2));
//            mes=Integer.parseInt(Cadenas.get(1));
//            dia=Integer.parseInt(Cadenas.get(0));
//            fecha.set(ano, mes-1, dia);
//            Calendario2.setSelectedDate(fecha);
            calendario2.setText(Clases.Alquileres.AFecha2);
            txtDestino.setText(Clases.Alquileres.ADestino);
            txtTelfDestino.setText(Clases.Alquileres.ATelf);
            txtComentarios.setText(Clases.Alquileres.AComentarios);
            txtDias.setText(String.valueOf(Clases.Alquileres.ADias));
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
            txtCobrador.setText(Clases.Alquileres.ACobrador);
            if (Clases.Alquileres.AAC==null){
                txtAC.setText("0.0");
            }else{
                txtAC.setText(String.valueOf(Clases.Alquileres.AAC));
            }
            calcularSaldo();
            if (Clases.Alquileres.APendiente==false){
                JOptionPane.showMessageDialog(null, "Este alquiler ya fue cancelado.");
                try{
                    txtNumDep.setText(Clases.Alquileres.ANumDep);
                }catch(Exception e){}
                /*Lo que viene a continuación es la carga de la fecha de depósito,
                 * debido a que es un campo añadido a posteriori a la base de datos
                 * es posible que algunos registros no lo tengan y que esas celdas
                 * estén vacías, para tragar el error que daría en este caso usamos
                 * el TRY
                 */
                try{
//                    for (int i=0;i<Clases.Alquileres.AFecha3.length();i++){//recorremos el string AFecha para sacar los numeros y separarlos(dia,mes,año)
//                        if (!Clases.Alquileres.AFecha3.substring(i,i+1).equals("/")){ //Si es un número
//                            Cadena=Cadena+Clases.Alquileres.AFecha3.substring(i,i+1); //Recorremos la búsqueda armando palabras.
//                        }
//                        else{ //Al encontrar la barra inclinada carga la variable en el array.
//                            Cadenas.add(Cadena);
//                            Cadena="";
//                        }
//                    }
//                    Cadenas.add(Cadena);
//                    Cadena="";//Al terminar de recorrer la fecha también cargamos variable.
//                    ano=Integer.parseInt(Cadenas.get(2));
//                    mes=Integer.parseInt(Cadenas.get(1));
//                    dia=Integer.parseInt(Cadenas.get(0));
//                    fecha.set(ano, mes-1, dia);
//                    Calendario3.setSelectedDate(fecha);
                    calendario3.setText(Clases.Alquileres.AFecha3);
                    calcularDiasDep();
//                    Cadenas.clear();
                }catch (Exception e){
                    //Básicamente avisamos que la fecha mostrada por defecto en el calendario no corresponde a nada.
                    JOptionPane.showMessageDialog(null, "No hay fecha de depósito.");
                }
            }else{
//                txtNumDep.setVisible(false);
//                lblDep.setVisible(false);
//                calendario3.setVisible(false);
//                lblFecha.setVisible(false);
//                txtDiasDep.setVisible(false);
//                lblDias.setVisible(false);
            }
            cmdEliminar.setEnabled(true);
            mnuEliminar.setEnabled(true);
            if (Clases.Alquileres.APendiente==true){
                cmdTerminar.setEnabled(true);
                mnuTerminar.setEnabled(true);
            }  else{
                cmdTerminar.setEnabled(false);
                mnuTerminar.setEnabled(false);
            }  
            mnuModificar.setEnabled(true);
            habilitar=false;
        }
        else{
            cmdEliminar.setEnabled(false);
            mnuEliminar.setEnabled(false);
            cmdTerminar.setEnabled(false);
            mnuTerminar.setEnabled(false);
            mnuModificar.setEnabled(false);
            habilitar=true;
            txtCobradoPor.setVisible(false);
            
        }
    }
    private void comprobarStock(int index, int cant){
        if (cant>Stocks.get(index)){
            JOptionPane.showMessageDialog(null, "El Stock disponible de este ítem es de "+Stocks.get(index)+" unidades.");
        }
    }
    private void llenarCombos() throws IOException{
        POIFSFileSystem fs = new POIFSFileSystem (new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        int NumRegistros = Items.getLastRowNum();
        ArrayList<String> Nombres = new ArrayList<>(); //Declaración de un Vector Dinámico para almacenar los nombres de los Items.
        Stocks.add(0);//Creamos la posición '0' del array para poder empezar a usarlo desde la '1', como el combo y la tabla.
        for (int i=1;i<=NumRegistros;i++){
            Nombres.add(Items.getRow(i).getCell(1).toString());
            Stocks.add(Clases.General.calcularStockDisponible(i));
        }
        for (int j=0;j<Nombres.size();j++){
            /*Todos los comboBox han sido modificados (en Propiedades/Código/Parámetros de Tipo)
            con el valor <String>. Ésto resuelve las advertencias de llamada no checkeada que
            salía al Limpiar y Generar (Clean & Build), Añadiendo el parámetro -Xlint:Unchecked en las 
            opciones de Compilado.*/
            cboItem1.addItem(Nombres.get(j));
            cboItem2.addItem(Nombres.get(j));
            cboItem3.addItem(Nombres.get(j));
            cboItem4.addItem(Nombres.get(j));
            cboItem5.addItem(Nombres.get(j));
            cboItem6.addItem(Nombres.get(j));
        }  
    }
    
    private void calcularDias(){
        Calendar fecha1=new GregorianCalendar(), fecha2=new GregorianCalendar();
        //Conversión de String a Calendar:
        String strFormato="dd/MM/yyyy";
        DateFormat formatoFecha = new SimpleDateFormat(strFormato);
        Date date = new Date();
        try{
            date = formatoFecha.parse(calendario1.getText());
            fecha1.setTime(date);
            date = formatoFecha.parse(calendario2.getText());
            fecha2.setTime(date);
        }catch (ParseException e){
        }
        long Diferencia = (fecha2.getTimeInMillis() - fecha1.getTimeInMillis())/(24*60*60*1000);
        if (Diferencia<7 && fecha1.get(Calendar.WEEK_OF_YEAR)!=fecha2.get(Calendar.WEEK_OF_YEAR)){
            Diferencia-=1; //Si son menos de 7 dias de diferencia y las semanas son distintas, entendemos que hay un domingo y lo restamos.
        }
        txtDias.setText(String.valueOf(Diferencia-(Diferencia/7)));//Uno de cada siete días es Domingo, así es como se restan los Domingos :)
        //System.out.println("Domingos encontrados: "+Diferencia/7);
    }
    private Double calcularMonto(int index, int cant) throws FileNotFoundException, IOException{//recibe el Index del comboBox seleccionado y cantidad.
        Double Monto;
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        Monto=(Double)Items.getRow(index).getCell(2).getNumericCellValue()*cant;
        return General.redondear(Monto);
    }
    private Double calcularTotal(){
        Double Total,m1=0.0,m2=0.0,m3=0.0,m4=0.0,m5=0.0,m6=0.0;
        int dias=0;
        if (!txtDias.getText().equals("")) dias=Integer.valueOf(txtDias.getText());
        if (!txtMonto1.getText().equals("")) m1=Double.valueOf(txtMonto1.getText());
        if (!txtMonto2.getText().equals("")) m2=Double.valueOf(txtMonto2.getText());
        if (!txtMonto3.getText().equals("")) m3=Double.valueOf(txtMonto3.getText());
        if (!txtMonto4.getText().equals("")) m4=Double.valueOf(txtMonto4.getText());
        if (!txtMonto5.getText().equals("")) m5=Double.valueOf(txtMonto5.getText());
        if (!txtMonto6.getText().equals("")) m6=Double.valueOf(txtMonto6.getText());
        Total=(m1+m2+m3+m4+m5+m6)*dias;
        
        return General.redondear(Total);
    }
    private void calcularSaldo(){
        try{
            double saldo=Double.valueOf(txtTotal.getText())-Double.valueOf(txtAC.getText());
            txtSaldo.setText(String.valueOf(saldo));
        }catch(Exception e){}
    }
    private void calcularDiasDep(){
        Calendar fecha1=new GregorianCalendar(), fecha2=new GregorianCalendar();
        //Conversión de String a Calendar:
        String strFormato="dd/MM/yyyy";
        DateFormat formatoFecha = new SimpleDateFormat(strFormato);
        Date date = new Date();
        try{
            date = formatoFecha.parse(calendario2.getText());
            fecha1.setTime(date);
            date = formatoFecha.parse(calendario3.getText());
            fecha2.setTime(date);
        }catch (ParseException e){
        }
        long Diferencia = (fecha2.getTimeInMillis() - fecha1.getTimeInMillis())/(24*60*60*1000);
        txtDiasDep.setText(String.valueOf(Diferencia));
    }
    public Dialogo_Alquiler(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
//        if (EsNuevo==true)
        txtCliente.setText(Clases.Clientes.CNombre+" "+Clases.Clientes.CApellidos+", "+Clases.Clientes.CCI);
        llenarCombos();       
        cargarDatos();
        habilitarDeshabilitar(habilitar);//habilitar
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cboItem1 = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad1 = new javax.swing.JSpinner();
        lblMonto = new javax.swing.JLabel();
        txtMonto1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblMonto1 = new javax.swing.JLabel();
        txtCantidad2 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txtMonto2 = new javax.swing.JTextField();
        cboItem2 = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMonto2 = new javax.swing.JLabel();
        txtCantidad3 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txtMonto3 = new javax.swing.JTextField();
        cboItem3 = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelfDestino = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cboItem4 = new javax.swing.JComboBox<String>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMonto4 = new javax.swing.JTextField();
        lblMonto3 = new javax.swing.JLabel();
        txtCantidad4 = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cboItem5 = new javax.swing.JComboBox<String>();
        txtMonto5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCantidad5 = new javax.swing.JSpinner();
        lblMonto4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtMonto6 = new javax.swing.JTextField();
        lblMonto5 = new javax.swing.JLabel();
        txtCantidad6 = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        cboItem6 = new javax.swing.JComboBox<String>();
        jLabel30 = new javax.swing.JLabel();
        cmdGuardar = new javax.swing.JButton();
        cmdTerminar = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        txtCobradoPor = new javax.swing.JLabel();
        txtCobrador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtAC = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblDep = new javax.swing.JLabel();
        txtNumDep = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        txtDiasDep = new javax.swing.JTextField();
        calendario1 = new javax.swing.JFormattedTextField();
        calendario2 = new javax.swing.JFormattedTextField();
        calendario3 = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuGuardar = new javax.swing.JMenuItem();
        mnuTerminar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuModificar = new javax.swing.JMenuItem();
        mnuEliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alquiler");
        setResizable(false);

        jLabel2.setText("Item 1:");

        cboItem1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem1.setNextFocusableComponent(txtCantidad1);
        cboItem1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setText("Cantidad:");

        txtCantidad1.setEnabled(false);
        txtCantidad1.setNextFocusableComponent(txtMonto1);
        txtCantidad1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad1StateChanged(evt);
            }
        });

        lblMonto.setText("Monto:");

        txtMonto1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMonto1.setNextFocusableComponent(cboItem2);
        txtMonto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto1KeyReleased(evt);
            }
        });

        jLabel4.setText("Bs.");

        jLabel5.setText("Cliente seleccionado:");

        txtCliente.setEditable(false);
        txtCliente.setFocusable(false);

        lblMonto1.setText("Monto:");

        txtCantidad2.setEnabled(false);
        txtCantidad2.setNextFocusableComponent(txtMonto2);
        txtCantidad2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad2StateChanged(evt);
            }
        });

        jLabel6.setText("Bs.");

        txtMonto2.setNextFocusableComponent(cboItem3);
        txtMonto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto2KeyReleased(evt);
            }
        });

        cboItem2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem2.setNextFocusableComponent(txtCantidad2);
        cboItem2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel7.setText("Cantidad:");

        jLabel8.setText("Item 2:");

        lblMonto2.setText("Monto:");

        txtCantidad3.setEnabled(false);
        txtCantidad3.setNextFocusableComponent(txtMonto3);
        txtCantidad3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad3StateChanged(evt);
            }
        });

        jLabel9.setText("Bs.");

        txtMonto3.setNextFocusableComponent(cboItem4);
        txtMonto3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto3KeyReleased(evt);
            }
        });

        cboItem3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem3.setNextFocusableComponent(txtCantidad3);
        cboItem3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel10.setText("Cantidad:");

        jLabel11.setText("Item 3:");

        jLabel12.setText("Dirección de destino:");

        txtDestino.setNextFocusableComponent(txtTelfDestino);

        jLabel13.setText("Teléfono de destino:");

        txtTelfDestino.setNextFocusableComponent(txtDias);

        jLabel14.setText("Comentarios:");

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        txtComentarios.setNextFocusableComponent(txtDias);
        jScrollPane2.setViewportView(txtComentarios);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setText("TOTAL:");

        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        jLabel18.setText("Bs.");

        jLabel16.setText("Fecha de inicio:");

        jLabel19.setText("Fecha de entrega:");

        jLabel20.setText("Total días (descontados domingos):");

        txtDias.setNextFocusableComponent(cmdGuardar);
        txtDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiasKeyReleased(evt);
            }
        });

        jLabel21.setText("(Puede descontar manualmente los feriados aquí.)");

        jLabel22.setText("Item 4:");

        cboItem4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem4.setNextFocusableComponent(txtCantidad4);
        cboItem4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel23.setText("Cantidad:");

        jLabel24.setText("Bs.");

        txtMonto4.setNextFocusableComponent(cboItem5);
        txtMonto4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto4KeyReleased(evt);
            }
        });

        lblMonto3.setText("Monto:");

        txtCantidad4.setEnabled(false);
        txtCantidad4.setNextFocusableComponent(txtMonto4);
        txtCantidad4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad4StateChanged(evt);
            }
        });

        jLabel25.setText("Item 5:");

        jLabel26.setText("Cantidad:");

        cboItem5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem5.setNextFocusableComponent(txtCantidad5);
        cboItem5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txtMonto5.setNextFocusableComponent(cboItem6);
        txtMonto5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto5KeyReleased(evt);
            }
        });

        jLabel27.setText("Bs.");

        txtCantidad5.setEnabled(false);
        txtCantidad5.setNextFocusableComponent(txtMonto5);
        txtCantidad5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad5StateChanged(evt);
            }
        });

        lblMonto4.setText("Monto:");

        jLabel28.setText("Bs.");

        txtMonto6.setNextFocusableComponent(txtDestino);
        txtMonto6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto6KeyReleased(evt);
            }
        });

        lblMonto5.setText("Monto:");

        txtCantidad6.setEnabled(false);
        txtCantidad6.setNextFocusableComponent(txtMonto6);
        txtCantidad6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCantidad6StateChanged(evt);
            }
        });

        jLabel29.setText("Cantidad:");

        cboItem6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cboItem6.setNextFocusableComponent(txtCantidad6);
        cboItem6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboItem6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel30.setText("Item 6:");

        cmdGuardar.setText("Iniciar Alquiler");
        cmdGuardar.setNextFocusableComponent(cmdTerminar);
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        cmdTerminar.setText("Terminar Alquiler");
        cmdTerminar.setNextFocusableComponent(cmdEliminar);
        cmdTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTerminarActionPerformed(evt);
            }
        });

        cmdEliminar.setText("Eliminar Alquiler");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        txtCobradoPor.setText("Cobrado por:");

        jLabel1.setText("Dejado a cuenta:");

        txtAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtACKeyReleased(evt);
            }
        });

        jLabel15.setText("Saldo a Pagar:");

        txtSaldo.setEditable(false);

        lblDep.setText("Nº de Depósito:");

        lblFecha.setText("Fecha de Depósito:");

        lblDias.setText("Días entre recepción y depósito:");

        txtDiasDep.setEditable(false);

        calendario1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        calendario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calendario1KeyReleased(evt);
            }
        });

        calendario2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        calendario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calendario2KeyReleased(evt);
            }
        });

        calendario3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        calendario3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calendario3KeyReleased(evt);
            }
        });

        jMenu1.setText("Archivo");

        mnuGuardar.setText("Iniciar Alquiler");
        mnuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuGuardar);

        mnuTerminar.setText("Terminar Alquiler (dar por pagado)");
        mnuTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTerminarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuTerminar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        mnuModificar.setText("Modificar este Alquiler");
        mnuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarActionPerformed(evt);
            }
        });
        jMenu2.add(mnuModificar);

        mnuEliminar.setText("Eliminar este Alquiler");
        mnuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEliminar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonto4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboItem6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMonto5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonto6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCobradoPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCobrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addGap(18, 18, 18)
                        .addComponent(calendario3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(lblDep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(calendario1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(calendario2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDias)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiasDep, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(calendario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDep)
                                    .addComponent(txtNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFecha)
                                    .addComponent(calendario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDias)
                                    .addComponent(txtDiasDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdEliminar)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCobradoPor)
                                    .addComponent(txtCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto)
                            .addComponent(txtMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto1)
                            .addComponent(txtMonto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtCantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto2)
                            .addComponent(txtMonto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtCantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto3)
                            .addComponent(txtMonto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(txtCantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto4)
                            .addComponent(txtMonto5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboItem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtCantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto5)
                            .addComponent(txtMonto6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTelfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboItem1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem1PopupMenuWillBecomeInvisible
        if (cboItem1.getSelectedIndex()!=0){
            try {
                txtMonto1.setText(String.valueOf(calcularMonto(cboItem1.getSelectedIndex(),(int)txtCantidad1.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem1PopupMenuWillBecomeInvisible

    private void txtCantidad1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad1StateChanged
        if (cboItem1.getSelectedIndex()!=0){
            try {
                if (txtCantidad1.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem1.getSelectedIndex(),(int)txtCantidad1.getValue());
                    txtMonto1.setText(String.valueOf(calcularMonto(cboItem1.getSelectedIndex(),(int)txtCantidad1.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad1StateChanged

    private void cboItem2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem2PopupMenuWillBecomeInvisible
        if (cboItem2.getSelectedIndex()!=0){
            try {
                txtMonto2.setText(String.valueOf(calcularMonto(cboItem2.getSelectedIndex(),(int)txtCantidad2.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem2PopupMenuWillBecomeInvisible

    private void txtCantidad2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad2StateChanged
        if (cboItem2.getSelectedIndex()!=0){
            try {
                if (txtCantidad2.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem2.getSelectedIndex(),(int)txtCantidad2.getValue());
                    txtMonto2.setText(String.valueOf(calcularMonto(cboItem2.getSelectedIndex(),(int)txtCantidad2.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad2StateChanged

    private void cboItem3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem3PopupMenuWillBecomeInvisible
        if (cboItem3.getSelectedIndex()!=0){
            try {
                txtMonto3.setText(String.valueOf(calcularMonto(cboItem3.getSelectedIndex(),(int)txtCantidad3.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem3PopupMenuWillBecomeInvisible

    private void txtCantidad3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad3StateChanged
        if (cboItem3.getSelectedIndex()!=0){
            try {
                if (txtCantidad3.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem3.getSelectedIndex(),(int)txtCantidad3.getValue());
                    txtMonto3.setText(String.valueOf(calcularMonto(cboItem3.getSelectedIndex(),(int)txtCantidad3.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad3StateChanged

    private void cboItem4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem4PopupMenuWillBecomeInvisible
        if (cboItem4.getSelectedIndex()!=0){
            try {
                txtMonto4.setText(String.valueOf(calcularMonto(cboItem4.getSelectedIndex(),(int)txtCantidad4.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem4PopupMenuWillBecomeInvisible

    private void txtCantidad4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad4StateChanged
        if (cboItem4.getSelectedIndex()!=0){
            try {
                if (txtCantidad4.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem4.getSelectedIndex(),(int)txtCantidad4.getValue());
                    txtMonto4.setText(String.valueOf(calcularMonto(cboItem4.getSelectedIndex(),(int)txtCantidad4.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad4StateChanged

    private void cboItem5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem5PopupMenuWillBecomeInvisible
        if (cboItem5.getSelectedIndex()!=0){
            try {
                txtMonto5.setText(String.valueOf(calcularMonto(cboItem5.getSelectedIndex(),(int)txtCantidad5.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem5PopupMenuWillBecomeInvisible

    private void txtCantidad5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad5StateChanged
        if (cboItem5.getSelectedIndex()!=0){
            try {
                if (txtCantidad5.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem5.getSelectedIndex(),(int)txtCantidad5.getValue());
                    txtMonto5.setText(String.valueOf(calcularMonto(cboItem5.getSelectedIndex(),(int)txtCantidad5.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad5StateChanged

    private void cboItem6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboItem6PopupMenuWillBecomeInvisible
        if (cboItem6.getSelectedIndex()!=0){
            try {
                txtMonto6.setText(String.valueOf(calcularMonto(cboItem6.getSelectedIndex(),(int)txtCantidad6.getValue())));
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboItem6PopupMenuWillBecomeInvisible

    private void txtCantidad6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCantidad6StateChanged
        if (cboItem6.getSelectedIndex()!=0){
            try {
                if (txtCantidad6.isEnabled()){//calculamos el monto y comprobamos stock solo si es el usuario quien lo manipula.
                    comprobarStock(cboItem6.getSelectedIndex(),(int)txtCantidad6.getValue());
                    txtMonto6.setText(String.valueOf(calcularMonto(cboItem6.getSelectedIndex(),(int)txtCantidad6.getValue())));
                }
                txtTotal.setText(String.valueOf(calcularTotal()));
                calcularSaldo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCantidad6StateChanged

    private void txtDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasKeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,true)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtDias.getText().length(); i++){
               if (General.esValido(new Character(txtDias.getText().charAt(i)),true)){
                   texto += txtDias.getText().charAt(i);
               }
           }
           txtDias.setText(texto);
           getToolkit().beep();
        }
        else txtTotal.setText(String.valueOf(calcularTotal()));
        calcularSaldo();
    }//GEN-LAST:event_txtDiasKeyReleased

    private void mnuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarActionPerformed
        if (mnuModificar.isEnabled() == true) {
            habilitarDeshabilitar(true);
            EsNuevo = false;
            cmdGuardar.setText("Guardar");
            mnuGuardar.setText("Guardar");
            mnuTerminar.setEnabled(false);
            cmdTerminar.setEnabled(false);
        }
    }//GEN-LAST:event_mnuModificarActionPerformed

    private void mnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarActionPerformed
        try {
            Clases.Alquileres.AItem1=String.valueOf(cboItem1.getSelectedItem());
            Clases.Alquileres.ACant1=(int)txtCantidad1.getValue();
            if (txtMonto1.getText().equals(""))txtMonto1.setText("0");
            Clases.Alquileres.AMonto1=Double.valueOf(txtMonto1.getText());
            Clases.Alquileres.AItem2=String.valueOf(cboItem2.getSelectedItem());
            Clases.Alquileres.ACant2=(int)txtCantidad2.getValue();
            if (txtMonto2.getText().equals(""))txtMonto2.setText("0");
            Clases.Alquileres.AMonto2=Double.valueOf(txtMonto2.getText());
            Clases.Alquileres.AItem3=String.valueOf(cboItem3.getSelectedItem());
            Clases.Alquileres.ACant3=(int)txtCantidad3.getValue();
            if (txtMonto3.getText().equals(""))txtMonto3.setText("0");
            Clases.Alquileres.AMonto3=Double.valueOf(txtMonto3.getText());
            Clases.Alquileres.AItem4=String.valueOf(cboItem4.getSelectedItem());
            Clases.Alquileres.ACant4=(int)txtCantidad4.getValue();
            if (txtMonto4.getText().equals(""))txtMonto4.setText("0");
            Clases.Alquileres.AMonto4=Double.valueOf(txtMonto4.getText());
            Clases.Alquileres.AItem5=String.valueOf(cboItem5.getSelectedItem());
            Clases.Alquileres.ACant5=(int)txtCantidad5.getValue();
            if (txtMonto5.getText().equals(""))txtMonto5.setText("0");
            Clases.Alquileres.AMonto5=Double.valueOf(txtMonto5.getText());
            Clases.Alquileres.AItem6=String.valueOf(cboItem6.getSelectedItem());
            Clases.Alquileres.ACant6=(int)txtCantidad6.getValue();
            if (txtMonto6.getText().equals(""))txtMonto6.setText("0");
            Clases.Alquileres.AMonto6=Double.valueOf(txtMonto6.getText());
            Clases.Alquileres.ADestino=txtDestino.getText();
            Clases.Alquileres.ATelf=txtTelfDestino.getText();
            Clases.Alquileres.AComentarios=txtComentarios.getText();
            String Cadena1=calendario1.getText();
            String Cadena2=calendario2.getText();
            String Cadena3=calendario3.getText();
            Cadena1=Cadena1.replaceAll("-", "/");
            Cadena2=Cadena2.replaceAll("-", "/");
            Cadena3=Cadena3.replaceAll("-", "/");
            Clases.Alquileres.AFecha1=Cadena1;
            Clases.Alquileres.AFecha2=Cadena2;
            Clases.Alquileres.AFecha3=Cadena3;
            Clases.Alquileres.ADias=Integer.parseInt(txtDias.getText());
            if (txtAC.getText().equals(""))txtAC.setText("0");
            Clases.Alquileres.AAC=Double.parseDouble(txtAC.getText());
            Clases.Alquileres.ANumDep=txtNumDep.getText();
            
            if (EsNuevo==true){
                Clases.Alquileres.APendiente=true;
                Clases.Alquileres.guardarNuevoAlquiler();
            }
            else{
                if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de querer modificar este Alquiler?")==0){
                    Clases.Alquileres.modificarAlquiler();
                }
            }
            this.setVisible(false);
        } 
        catch (Exception ex) {       
            JOptionPane.showMessageDialog(null, "Se ha producido un error al intentar guardar,\nposiblemente alguno de los datos no es válido.\nPor favor, revíselo y vuelva a intentarlo.");
        }
    }//GEN-LAST:event_mnuGuardarActionPerformed

    private void mnuTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTerminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Terminar un alquiler significa darlo por pagado, \n este cambio no se puede deshacer, ¿Confirmar?")==0){
            try {             
                String Pagado=JOptionPane.showInputDialog(null, "Escriba el monto que se está pagando.(Saldo a pagar: "+txtSaldo.getText()+")");
                String Cobrador=JOptionPane.showInputDialog(null, "Nombre de la persona que ha realizado el cobro:");
                POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
                HSSFWorkbook    libro = new HSSFWorkbook(fs);
                HSSFSheet Alquileres = libro.getSheetAt(1);
                int NumRegistros = Alquileres.getLastRowNum();
                for (int i=1;i<=NumRegistros;i++){
                    if (Clases.Alquileres.ID_Alquiler==(int)Alquileres.getRow(i).getCell(0).getNumericCellValue()){
                        Alquileres.getRow(i).getCell(25).setCellValue(false); //asignamos FALSO al campo 'Pendiente'.
                        Alquileres.getRow(i).createCell(28).setCellValue(Pagado);
                        Alquileres.getRow(i).getCell(27).setCellValue(Cobrador); 
                    }
                }
                FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
                libro.write(elFichero);
                elFichero.close();
                JOptionPane.showMessageDialog(null, "El alquiler se ha terminado correctamente.");
                try {
                        int index1=cboItem1.getSelectedIndex();
                        int index2=cboItem2.getSelectedIndex();
                        int index3=cboItem3.getSelectedIndex();
                        int index4=cboItem4.getSelectedIndex();
                        int index5=cboItem5.getSelectedIndex();
                        int index6=cboItem6.getSelectedIndex();
                        String NomYApe=Clases.Clientes.CNombre+" "+Clases.Clientes.CApellidos;
                        Crear_Recepcion.crearRecepcion(NomYApe,calendario2.getText(),index1,index2,index3,index4,index5,index6);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuTerminarActionPerformed

    private void mnuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar este alquiler?") == 0) {
            try {
                Clases.Alquileres.eliminarAlquiler();
                this.setVisible(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuEliminarActionPerformed

    private void txtMonto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto1KeyReleased
       Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto1.getText().length(); i++){
               if (General.esValido(new Character(txtMonto1.getText().charAt(i)),false)){
                   texto += txtMonto1.getText().charAt(i);
               }
           }
           txtMonto1.setText(texto);
           getToolkit().beep();
        }
        else{ 
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto1KeyReleased

    private void txtMonto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto2KeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto2.getText().length(); i++){
               if (General.esValido(new Character(txtMonto2.getText().charAt(i)),false)){
                   texto += txtMonto2.getText().charAt(i);
               }
           }
           txtMonto2.setText(texto);
           getToolkit().beep();
        }
        else{
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto2KeyReleased

    private void txtMonto3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto3KeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto3.getText().length(); i++){
               if (General.esValido(new Character(txtMonto3.getText().charAt(i)),false)){
                   texto += txtMonto3.getText().charAt(i);
               }
           }
           txtMonto3.setText(texto);
           getToolkit().beep();
        }
        else {
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto3KeyReleased

    private void txtMonto4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto4KeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto4.getText().length(); i++){
               if (General.esValido(new Character(txtMonto4.getText().charAt(i)),false)){
                   texto += txtMonto4.getText().charAt(i);
               }
           }
           txtMonto4.setText(texto);
           getToolkit().beep();
        }
        else{
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto4KeyReleased

    private void txtMonto5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto5KeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto5.getText().length(); i++){
               if (General.esValido(new Character(txtMonto5.getText().charAt(i)),false)){
                   texto += txtMonto5.getText().charAt(i);
               }
           }
           txtMonto5.setText(texto);
           getToolkit().beep();
        }
        else {
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto5KeyReleased

    private void txtMonto6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto6KeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtMonto6.getText().length(); i++){
               if (General.esValido(new Character(txtMonto6.getText().charAt(i)),false)){
                   texto += txtMonto6.getText().charAt(i);
               }
           }
           txtMonto6.setText(texto);
           getToolkit().beep();
        }
        else {
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }
    }//GEN-LAST:event_txtMonto6KeyReleased

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!General.esValido(caracter,false)){ 
            //Cada vez que se escribe una letra en este campo comprobamos si es un número válido.
           String texto = "";
           for (int i = 0; i < txtTotal.getText().length(); i++){
               if (General.esValido(new Character(txtTotal.getText().charAt(i)),false)){
                   texto += txtTotal.getText().charAt(i);
               }
           }
           txtTotal.setText(texto);
           getToolkit().beep();
        }
        calcularSaldo();
    }//GEN-LAST:event_txtTotalKeyReleased

    private void cmdTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTerminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Terminar un alquiler significa darlo por pagado, \n este cambio no se puede deshacer, ¿Confirmar?")==0){
            try {             
                String Pagado=JOptionPane.showInputDialog(null, "Escriba el monto que se está pagando.(Saldo a pagar: "+txtSaldo.getText()+")");
                String Cobrador=JOptionPane.showInputDialog(null, "Nombre de la persona que ha realizado el cobro:");
                POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
                HSSFWorkbook    libro = new HSSFWorkbook(fs);
                HSSFSheet Alquileres = libro.getSheetAt(1);
                int NumRegistros = Alquileres.getLastRowNum();
                Clases.Alquileres.AAC=Double.valueOf(Pagado);
                for (int i=1;i<=NumRegistros;i++){
                    if (Clases.Alquileres.ID_Alquiler==(int)Alquileres.getRow(i).getCell(0).getNumericCellValue()){
                        Alquileres.getRow(i).getCell(25).setCellValue(false); //asignamos FALSO al campo 'Pendiente'.
                        Alquileres.getRow(i).createCell(28).setCellValue(Pagado);
                        Alquileres.getRow(i).getCell(27).setCellValue(Cobrador); 
                        break;
                    }
                }
                FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
                libro.write(elFichero);
                elFichero.close();
                JOptionPane.showMessageDialog(null, "El alquiler se ha terminado correctamente.");
                try {
                        int index1=cboItem1.getSelectedIndex();
                        int index2=cboItem2.getSelectedIndex();
                        int index3=cboItem3.getSelectedIndex();
                        int index4=cboItem4.getSelectedIndex();
                        int index5=cboItem5.getSelectedIndex();
                        int index6=cboItem6.getSelectedIndex();
                        String NomYApe=Clases.Clientes.CNombre+" "+Clases.Clientes.CApellidos;
                        Crear_Recepcion.crearRecepcion(NomYApe,calendario2.getText(),index1,index2,index3,index4,index5,index6);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdTerminarActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        if (cmdGuardar.isEnabled()==true){        
            try {
                Clases.Alquileres.AItem1=String.valueOf(cboItem1.getSelectedItem());
                Clases.Alquileres.ACant1=(int)txtCantidad1.getValue();
                if (txtMonto1.getText().equals(""))txtMonto1.setText("0");
                Clases.Alquileres.AMonto1=Double.valueOf(txtMonto1.getText());
                Clases.Alquileres.AItem2=String.valueOf(cboItem2.getSelectedItem());
                Clases.Alquileres.ACant2=(int)txtCantidad2.getValue();
                if (txtMonto2.getText().equals(""))txtMonto2.setText("0");
                Clases.Alquileres.AMonto2=Double.valueOf(txtMonto2.getText());
                Clases.Alquileres.AItem3=String.valueOf(cboItem3.getSelectedItem());
                Clases.Alquileres.ACant3=(int)txtCantidad3.getValue();
                if (txtMonto3.getText().equals(""))txtMonto3.setText("0");
                Clases.Alquileres.AMonto3=Double.valueOf(txtMonto3.getText());
                Clases.Alquileres.AItem4=String.valueOf(cboItem4.getSelectedItem());
                Clases.Alquileres.ACant4=(int)txtCantidad4.getValue();
                if (txtMonto4.getText().equals(""))txtMonto4.setText("0");
                Clases.Alquileres.AMonto4=Double.valueOf(txtMonto4.getText());
                Clases.Alquileres.AItem5=String.valueOf(cboItem5.getSelectedItem());
                Clases.Alquileres.ACant5=(int)txtCantidad5.getValue();
                if (txtMonto5.getText().equals(""))txtMonto5.setText("0");
                Clases.Alquileres.AMonto5=Double.valueOf(txtMonto5.getText());
                Clases.Alquileres.AItem6=String.valueOf(cboItem6.getSelectedItem());
                Clases.Alquileres.ACant6=(int)txtCantidad6.getValue();
                if (txtMonto6.getText().equals(""))txtMonto6.setText("0");
                Clases.Alquileres.AMonto6=Double.valueOf(txtMonto6.getText());
                Clases.Alquileres.ADestino=txtDestino.getText();
                Clases.Alquileres.ATelf=txtTelfDestino.getText();
                Clases.Alquileres.AComentarios=txtComentarios.getText();
                String Cadena1=calendario1.getText();
                String Cadena2=calendario2.getText();
                String Cadena3=calendario3.getText();
                Cadena1=Cadena1.replaceAll("-", "/");
                Cadena2=Cadena2.replaceAll("-", "/");
                Cadena3=Cadena3.replaceAll("-", "/");
                Clases.Alquileres.AFecha1=Cadena1;
                Clases.Alquileres.AFecha2=Cadena2;
                Clases.Alquileres.AFecha3=Cadena3;
                Clases.Alquileres.ADias=Integer.parseInt(txtDias.getText());
                if (txtAC.getText().equals(""))txtAC.setText("0");
                Clases.Alquileres.AAC=Double.parseDouble(txtAC.getText());
                Clases.Alquileres.ANumDep=txtNumDep.getText();

                if (EsNuevo==true){
                    Clases.Alquileres.APendiente=true;
                    Clases.Alquileres.guardarNuevoAlquiler();
                    try {
                        int index1=cboItem1.getSelectedIndex();
                        int index2=cboItem2.getSelectedIndex();
                        int index3=cboItem3.getSelectedIndex();
                        int index4=cboItem4.getSelectedIndex();
                        int index5=cboItem5.getSelectedIndex();
                        int index6=cboItem6.getSelectedIndex();
                        String NomYApe=Clases.Clientes.CNombre+" "+Clases.Clientes.CApellidos;
                        Crear_Despacho.CrearContrato(NomYApe,calendario1.getText(),index1,index2,index3,index4,index5,index6);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de querer modificar este Alquiler?")==0){
                        Clases.Alquileres.modificarAlquiler();
                    }
                }
                this.setVisible(false);
            } 
            catch (Exception ex) {       
                JOptionPane.showMessageDialog(null, "Se ha producido un error al intentar guardar,\nposiblemente alguno de los datos no es válido.\nPor favor, revíselo y vuelva a intentarlo.");
            }
        }    
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar este alquiler?") == 0) {
            try {
                Clases.Alquileres.eliminarAlquiler();
                this.setVisible(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dialogo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dialogo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void txtACKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtACKeyReleased
        calcularSaldo();
    }//GEN-LAST:event_txtACKeyReleased

    private void calendario1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calendario1KeyReleased
        try{
            calcularDias();
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
        }catch(Exception e){}
    }//GEN-LAST:event_calendario1KeyReleased

    private void calendario2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calendario2KeyReleased
        try{
            calcularDias();
            txtTotal.setText(String.valueOf(calcularTotal()));
            calcularSaldo();
            calcularDiasDep();
        }catch(Exception e){}
    }//GEN-LAST:event_calendario2KeyReleased

    private void calendario3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calendario3KeyReleased
        try{
            calcularDiasDep();
        }catch(Exception e){}
    }//GEN-LAST:event_calendario3KeyReleased

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
            java.util.logging.Logger.getLogger(Dialogo_Alquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Alquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Alquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Alquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Dialogo_Alquiler dialog = new Dialogo_Alquiler(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Dialogo_Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField calendario1;
    private javax.swing.JFormattedTextField calendario2;
    private javax.swing.JFormattedTextField calendario3;
    private javax.swing.JComboBox<String> cboItem1;
    private javax.swing.JComboBox<String> cboItem2;
    private javax.swing.JComboBox<String> cboItem3;
    private javax.swing.JComboBox<String> cboItem4;
    private javax.swing.JComboBox<String> cboItem5;
    private javax.swing.JComboBox<String> cboItem6;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdTerminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblMonto1;
    private javax.swing.JLabel lblMonto2;
    private javax.swing.JLabel lblMonto3;
    private javax.swing.JLabel lblMonto4;
    private javax.swing.JLabel lblMonto5;
    private javax.swing.JMenuItem mnuEliminar;
    private javax.swing.JMenuItem mnuGuardar;
    private javax.swing.JMenuItem mnuModificar;
    private javax.swing.JMenuItem mnuTerminar;
    private javax.swing.JTextField txtAC;
    private javax.swing.JSpinner txtCantidad1;
    private javax.swing.JSpinner txtCantidad2;
    private javax.swing.JSpinner txtCantidad3;
    private javax.swing.JSpinner txtCantidad4;
    private javax.swing.JSpinner txtCantidad5;
    private javax.swing.JSpinner txtCantidad6;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtCobradoPor;
    private javax.swing.JLabel txtCobrador;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtDiasDep;
    private javax.swing.JTextField txtMonto1;
    private javax.swing.JTextField txtMonto2;
    private javax.swing.JTextField txtMonto3;
    private javax.swing.JTextField txtMonto4;
    private javax.swing.JTextField txtMonto5;
    private javax.swing.JTextField txtMonto6;
    private javax.swing.JTextField txtNumDep;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTelfDestino;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
