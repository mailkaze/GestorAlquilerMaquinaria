package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author Kaze
 */
public class General {
    public static void comprobarArchivo() throws FileNotFoundException, IOException{
        //Comprobar si ya existe el archivo xls, sino, se crea.
        try{
            FileInputStream f1 = new FileInputStream("SokolmetDB");
            InputStreamReader f2 = new InputStreamReader(f1);
            BufferedReader linea = new BufferedReader(f2);
            //JOptionPane.showMessageDialog(rootPane, "SokolmetDB existe y se puede leer ;)");
        }
        catch (IOException ioe){
            if (JOptionPane.showConfirmDialog(null, "No se encuentra el archivo SokolmetDB, ¿Desea crearlo ahora?") == 0){
                HSSFWorkbook libro = new HSSFWorkbook();
                HSSFSheet Clientes = libro.createSheet("Clientes");
                String[] CCabeceras = new String[]{ //Array dinámico con los nombres de las cabeceras.
                    "ID_Cliente","Nombre","Apellidos","C.I.","NIT","Telf.Casa","Telf.Emp.","Celular",
                    "Celular 2","Dirección","Factura Luz","Factura Agua","Empresa Cliente","E-Mail","Cliente No Grato","Profesión"
                };                
                HSSFRow CabeceraClientes = Clientes.createRow(0); //Crea la cabecera de la tabla Clientes.
                for (int i=0;i<=15;i++){
                    CabeceraClientes.createCell(i).setCellValue(CCabeceras[i]); //Se asignan a las cabeceras las posiciones del Array.
                }
                HSSFSheet Alquileres = libro.createSheet("Alquileres"); //Crea la cabecera de la tabla Alquileres.
                String[] ACabeceras = new String[]{
                    "ID_Alquiler","ID_Cliente","Destino","Telf.Destino","Item 1","Cantidad 1","Monto 1","Item 2",
                    "Cantidad 2","Monto 2","Item 3","Cantidad 3","Monto 3","Item 4","Cantidad 4","Monto 4","Item 5",
                    "Cantidad 5","Monto 5","Item 6","Cantidad 6","Monto 6","Fecha de Inicio","Fecha de Entrega",
                    "Comentarios","¿Pendiente?","Días a Cobrar","Cobrador","Pagado","Nº Deposito","Fecha de Depósito"
                };
                HSSFRow CabeceraAlquileres = Alquileres.createRow(0);
                for (int i=0;i<=30;i++){
                    CabeceraAlquileres.createCell(i).setCellValue(ACabeceras[i]);
                }
                HSSFSheet Items = libro.createSheet("Items"); //Crea la cabecera de la tabla Items.
                String[] ICabeceras = new String[]{
                    "ID_Item","Nombre","Precio","Stock Total"
                };
                HSSFRow CabeceraItems = Items.createRow(0);
                for (int i=0;i<=3;i++){
                    CabeceraItems.createCell(i).setCellValue(ICabeceras[i]);
                }
                String Ruta = "SokolmetDB";
                File Archivo = new File(Ruta);
                try (FileOutputStream archivosalida = new FileOutputStream(Archivo)) {
                    libro.write(archivosalida);
                }
                catch (IOException e){
                    JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "La aplicación no puede funcionar sin este archivo y se cerrará.");
                System.exit(1);
            }
        }
    }
    public static Integer calcularStockDisponible(int Columna) throws FileNotFoundException, IOException{
        String NombreItem="";
        int StockTotal=0, Alquilados=0,StockDisponible;
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        HSSFSheet Items =libro.getSheetAt(2);
        int NumAlquileres = Alquileres.getLastRowNum();
        NombreItem=Items.getRow(Columna).getCell(1).getStringCellValue();
        StockTotal=(int)Items.getRow(Columna).getCell(3).getNumericCellValue();
        for (int j=1;j<=NumAlquileres;j++){
            if (Alquileres.getRow(j).getCell(25).getBooleanCellValue()==true){//Si está pendiente es que las cantidades están fuera aún.
                for (int k=4;k<=19;k++){
                    if ((k==4||k==7||k==10||k==13||k==16||k==19)&&(Alquileres.getRow(j).getCell(k).getStringCellValue().equals(NombreItem))){
                        Alquilados+=(int)Alquileres.getRow(j).getCell(k+1).getNumericCellValue();//sumamos la cantidad a Alquilados.
                    }
                }
            }
        }
        StockDisponible=StockTotal-Alquilados;
        return StockDisponible;
    }
    public static void abrirManual() throws IOException{
        Desktop desktop = Desktop.getDesktop(); //Instanciamos la clase Desktop
        String ruta="docs/Manual del Usuario de SOKOLMET.pdf"; //Le damos la ruta del archivo.
        File archivo = new File(ruta); //Instanciamos la clase File con esa ruta.
        desktop.open(archivo); //el método open de la clase Desktop llama al programa prederminado que abre ese archivo.
    }
    public static boolean esValido(Character Caracter, Boolean DebeSerEntero){
        char c = Caracter.charValue();
        if (DebeSerEntero){//Si el campo requiere un número entero.
            if (Character.isDigit(c)||c=='-'||c==8){ 
                //Si es un número, signo menos o 'backspace', es válido.
                return true;
            }
            else return false;
        }else{
            if (Character.isDigit(c)||c=='-'||c==','||c=='.'||c==8){ 
                //Si es un número, un punto, coma, signo menos o 'backspace', es válido.
                return true;
            }
            else return false;
        }
        
    }
    public static void subirArchivoPorFTP(){
        String server="mailkaze.99k.org/", user="mailkaze_99k", pass="kiheitai2004", localPath="SokolmetDB", remotePath="SokolmetDB";
        try {
            URL url = new URL("ftp://" + user + ":" + pass + "@" + server + remotePath + ";type=i");
            URLConnection urlc = url.openConnection();
            System.out.println("Conexión establecida.");
            OutputStream destino = urlc.getOutputStream();
            InputStream origen = null;
            File fichero = new File(localPath);
            origen = new FileInputStream(fichero);
            byte bytes[] = new byte[1024];
            int readCount = 0;
            while ((readCount = origen.read(bytes)) > 0) {
                destino.write(bytes, 0, readCount);
                System.out.println(".");
            }
            destino.flush();
            destino.close();
            origen.close();
            bajarArchivoPorFTP("Test_Sokolmet");//Descargamos el archivo para comprobar que se subió correctamente.
            String localPath2="Test_Sokolmet";
            File fichero2 =new File(localPath2);
            if (fichero.length()==fichero2.length()){
                System.out.println("Tamaño archivo original:"+fichero.length()+" Tamaño archivo de comprobación:"+fichero2.length());
                JOptionPane.showMessageDialog(null, "El archivo SokolmetDB se copió correctamente en el servidor.");
            }else {
                System.out.println("Tamaño archivo original:"+fichero.length()+" Tamaño archivo de comprobación:"+fichero2.length());
                JOptionPane.showMessageDialog(null, "Parece que el archivo no se copió correctamente,\npor favor, vuelva a intentarlo.");
            }
            fichero2.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar acceder al servidor.\nPor favor, vuelva a intentarlo.");
        }
    }
    
    public static void bajarArchivoPorFTP(String localPath){
        String server="mailkaze.99k.org/", user="mailkaze_99k", pass="kiheitai2004", remotePath="SokolmetDB";
        try {
            URL url = new URL("ftp://" + user + ":" + pass + "@" + server + remotePath + ";type=i");
            URLConnection urlc = url.openConnection();
            System.out.println("Conexión establecida.");
            InputStream origen = urlc.getInputStream();
            File fichero = new File(localPath);
            OutputStream destino = new FileOutputStream(fichero);
            byte bytes[] = new byte[1024];
            int readCount = 0;
            while ((readCount = origen.read(bytes)) > 0) {
                destino.write(bytes, 0, readCount);
                System.out.println(".");
            }
            destino.flush();
            destino.close();
            origen.close();
            if (localPath.equals("SokolmetDB")){
                JOptionPane.showMessageDialog(null, "La copia de seguridad se ha descargado correctamente del servidor.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if (localPath.equals("SokolmetDB")){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar acceder al servidor.\nPor favor, vuelva a intentarlo.");
            }
        }
    }
    public static double redondear(double numero){
	       return Math.rint(numero*100)/100;
	}
    public static String rutaImagen;
    public static Boolean CargarDatos,AbrirAlquiler;
    public static DefaultTableModel ModeloTablaClientes = new DefaultTableModel();
    public static DefaultTableModel ModeloTablaAlquileres = new DefaultTableModel();
    public static DefaultTableModel ModeloTablaItems = new DefaultTableModel();
    public static DefaultTableModel ModeloTablaIngresos = new DefaultTableModel();
    public static DefaultTableModel ModeloTablaDeuda = new DefaultTableModel();
    public static DefaultTableModel ModeloTablaDemora = new DefaultTableModel();
}
