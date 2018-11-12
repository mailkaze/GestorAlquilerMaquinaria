package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author Kaze
 */
public class Clientes {
    public static void guardarNuevoCliente()throws FileNotFoundException, IOException{
        int ID=0;
        // Guardar los datos en una nueva fila del archivo.
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        int NumRegistros = Clientes.getLastRowNum();
        HSSFRow Fila = Clientes.createRow(NumRegistros+1);
        
        //Cargamos las variables en las celdas.        
        HSSFCell CeldaID = Fila.createCell(0);
        try{
            ID = (int) Clientes.getRow(NumRegistros).getCell(0).getNumericCellValue()+1;
            CeldaID.setCellValue(ID);
        }
        catch(IllegalStateException n){
            CeldaID.setCellValue(1);
            ID = 1;
        }
                //ESTO ES OPTIMIZABLE CON UN ARRAY DE OBJETOS!
        HSSFCell CeldaA = Fila.createCell(1);
        HSSFRichTextString textoA = new HSSFRichTextString(CNombre);
        CeldaA.setCellValue(textoA);
        
        HSSFCell CeldaB = Fila.createCell(2);
        HSSFRichTextString textoB = new HSSFRichTextString(CApellidos);
        CeldaB.setCellValue(textoB);
        
        HSSFCell CeldaC = Fila.createCell(3);
        HSSFRichTextString textoC = new HSSFRichTextString(CCI);
        CeldaC.setCellValue(textoC);
        
        HSSFCell CeldaN = Fila.createCell(4);
        HSSFRichTextString textoN = new HSSFRichTextString(CNIT);
        CeldaN.setCellValue(textoN);
        
        HSSFCell CeldaD = Fila.createCell(5);
        HSSFRichTextString textoD = new HSSFRichTextString(CTelfCasa);
        CeldaD.setCellValue(textoD);
        
        HSSFCell CeldaE = Fila.createCell(6);
        HSSFRichTextString textoE = new HSSFRichTextString(CTelfEmp);
        CeldaE.setCellValue(textoE);
        
        HSSFCell CeldaF = Fila.createCell(7);
        HSSFRichTextString textoF = new HSSFRichTextString(CCel);
        CeldaF.setCellValue(textoF);
        
        HSSFCell CeldaG = Fila.createCell(8);
        HSSFRichTextString textoG = new HSSFRichTextString(CCel2);
        CeldaG.setCellValue(textoG);
        
        HSSFCell CeldaH = Fila.createCell(9);
        HSSFRichTextString textoH = new HSSFRichTextString(CDireccion);
        CeldaH.setCellValue(textoH);
             
        HSSFCell CeldaI = Fila.createCell(10);
        CeldaI.setCellValue(CLuz);
        
        HSSFCell CeldaJ = Fila.createCell(11);
        CeldaJ.setCellValue(CAgua);
           
        HSSFCell CeldaK = Fila.createCell(12);
        HSSFRichTextString textoK = new HSSFRichTextString(CEmpresa);
        CeldaK.setCellValue(textoK);
        
        HSSFCell CeldaM = Fila.createCell(13);
        HSSFRichTextString textoM = new HSSFRichTextString(CEmail);
        CeldaM.setCellValue(textoM);
        
        HSSFCell CeldaL = Fila.createCell(14);
        CeldaL.setCellValue(CNoGrato);
        
        HSSFCell CeldaO = Fila.createCell(15);
        HSSFRichTextString textoO = new HSSFRichTextString(CProfesion);
        CeldaO.setCellValue(textoO);
        //Guardamos el archivo.
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            //Copiamos la imagen a carpeta con el ID de cliente como nombre.
            guardarFoto(ID);
            JOptionPane.showMessageDialog(null, "El cliente se ha guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void abrirCliente() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        //Buscamos el cliente con ese ID en el archivo
        int NumRegistros = Clientes.getLastRowNum();
        for (int i=1;i<= NumRegistros;i++){
            if (ID_Cliente==(int)Clientes.getRow(i).getCell(0).getNumericCellValue()){
                //Se guardan los datos en variables globales para pasarlas al JDialog.
                CNombre=Clientes.getRow(i).getCell(1).getStringCellValue();
                CApellidos=Clientes.getRow(i).getCell(2).getStringCellValue();
                CCI=Clientes.getRow(i).getCell(3).getStringCellValue();
                CNIT=Clientes.getRow(i).getCell(4).getStringCellValue();
                CTelfCasa=Clientes.getRow(i).getCell(5).getStringCellValue();
                CTelfEmp=Clientes.getRow(i).getCell(6).getStringCellValue();
                CCel=Clientes.getRow(i).getCell(7).getStringCellValue();
                CCel2=Clientes.getRow(i).getCell(8).getStringCellValue();
                CDireccion=Clientes.getRow(i).getCell(9).getStringCellValue();
                Boolean luz=Clientes.getRow(i).getCell(10).getBooleanCellValue();
                if (luz==true) CLuz=true;
                else CLuz=false;
                Boolean agua=Clientes.getRow(i).getCell(11).getBooleanCellValue();
                if (agua==true) CAgua=true;
                else CAgua=false;
                CEmpresa=Clientes.getRow(i).getCell(12).getStringCellValue();
                CEmail=Clientes.getRow(i).getCell(13).getStringCellValue();
                Boolean noGrato=Clientes.getRow(i).getCell(14).getBooleanCellValue();
                if (noGrato==true) CNoGrato=true;
                else CNoGrato=false;
                CProfesion=Clientes.getRow(i).getCell(15).getStringCellValue();
            }
        }
        General.CargarDatos=true;
    }
    public static void modificarCliente() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook    libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        int NumRegistros = Clientes.getLastRowNum();
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Cliente==(int)Clientes.getRow(i).getCell(0).getNumericCellValue()){
                HSSFCell CeldaA = Clientes.getRow(i).createCell(1);
                HSSFRichTextString textoA = new HSSFRichTextString(CNombre);
                CeldaA.setCellValue(textoA);

                HSSFCell CeldaB = Clientes.getRow(i).createCell(2);
                HSSFRichTextString textoB = new HSSFRichTextString(CApellidos);
                CeldaB.setCellValue(textoB);

                HSSFCell CeldaC = Clientes.getRow(i).createCell(3);
                HSSFRichTextString textoC = new HSSFRichTextString(CCI);
                CeldaC.setCellValue(textoC);
                
                HSSFCell CeldaM = Clientes.getRow(i).createCell(4);
                HSSFRichTextString textoM = new HSSFRichTextString(CNIT);
                CeldaM.setCellValue(textoM);

                HSSFCell CeldaD = Clientes.getRow(i).createCell(5);
                HSSFRichTextString textoD = new HSSFRichTextString(CTelfCasa);
                CeldaD.setCellValue(textoD);

                HSSFCell CeldaE = Clientes.getRow(i).createCell(6);
                HSSFRichTextString textoE = new HSSFRichTextString(CTelfEmp);
                CeldaE.setCellValue(textoE);

                HSSFCell CeldaF = Clientes.getRow(i).createCell(7);
                HSSFRichTextString textoF = new HSSFRichTextString(CCel);
                CeldaF.setCellValue(textoF);

                HSSFCell CeldaG = Clientes.getRow(i).createCell(8);
                HSSFRichTextString textoG = new HSSFRichTextString(CCel2);
                CeldaG.setCellValue(textoG);

                HSSFCell CeldaH = Clientes.getRow(i).createCell(9);
                HSSFRichTextString textoH = new HSSFRichTextString(CDireccion);
                CeldaH.setCellValue(textoH);

                HSSFCell CeldaI = Clientes.getRow(i).createCell(10);
                CeldaI.setCellValue(CLuz);

                HSSFCell CeldaJ = Clientes.getRow(i).createCell(11);
                CeldaJ.setCellValue(CAgua);

                HSSFCell CeldaK = Clientes.getRow(i).createCell(12);
                HSSFRichTextString textoK = new HSSFRichTextString(CEmpresa);
                CeldaK.setCellValue(textoK);

                HSSFCell CeldaN = Clientes.getRow(i).createCell(13);
                HSSFRichTextString textoN = new HSSFRichTextString(CEmail);
                CeldaN.setCellValue(textoN);
                
                HSSFCell CeldaL = Clientes.getRow(i).createCell(14);
                CeldaL.setCellValue(CNoGrato);
                
                HSSFCell CeldaO = Clientes.getRow(i).createCell(15);
                HSSFRichTextString textoO = new HSSFRichTextString(CProfesion);
                CeldaO.setCellValue(textoO);
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            //Copiamos la imagen a carpeta con el ID de cliente como nombre.
            guardarFoto(ID_Cliente);
            JOptionPane.showMessageDialog(null, "El Cliente se ha modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void eliminarCliente() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Clientes = libro.getSheetAt(0);
        int NumRegistros = Clientes.getLastRowNum();
        //recorremos todos los registros buscando el seleccionado.
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Cliente == (int)Clientes.getRow(i).getCell(0).getNumericCellValue()){
                //Cuando lo encontramos sustituimos todas las filas por la siguiente.
                for (int j=i;j<NumRegistros;j++){ //Para ello recorremos la hoja desde el registro seleccionado hasta el final.
                    for (int k=0;k<=15;k++){ //K es el número de campos en cada línea.
                            if (k==0){ //Si es el campo ID hay que utilizar variable númerica.
                                int valor = (int)Clientes.getRow(j+1).getCell(k).getNumericCellValue();
                                Clientes.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else if (k==10 || k==11 || k==14){
                                Boolean valor = Clientes.getRow(j+1).getCell(k).getBooleanCellValue();
                                Clientes.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else{
                                String valor = Clientes.getRow(j+1).getCell(k).getStringCellValue();
                                HSSFRichTextString Cvalor = new HSSFRichTextString(valor);
                                Clientes.getRow(j).getCell(k).setCellValue(Cvalor);
                            }
                        }
                }
                Clientes.removeRow(Clientes.getRow(NumRegistros));//Eliminamos la última línea.
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            eliminarFoto();
            JOptionPane.showMessageDialog(null, "El cliente se ha eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    
    public static void guardarFoto(int id){
        if (Clases.General.rutaImagen!=null){
            try{
                File origen = new File(Clases.General.rutaImagen);
                File destino = new File("img/"+id+".jpg");
                InputStream in = new FileInputStream(origen);
                OutputStream out = new FileOutputStream(destino);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la imagen, asegúrese de que es un archivo '.jpg' válido.\nPodrá añadir una imagen a este cliente utilizando la opción Modificar.");
            }
        }
    }
    public static void eliminarFoto(){
        File archivo = new File("img/"+ID_Cliente+".jpg");
        if (archivo.delete())
           System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
           JOptionPane.showMessageDialog(null, "No se pudo eliminar la foto de este cliente.");
    }
    public static String CNombre,CApellidos,CCI,CNIT,CTelfCasa,CTelfEmp,CCel,CCel2,CDireccion,CEmpresa,CEmail,CProfesion;
    public static Boolean CLuz,CAgua,CNoGrato;
    public static Integer ID_Cliente;
}
