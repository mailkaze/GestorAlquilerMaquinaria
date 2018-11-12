package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class Alquileres {
    public static void guardarNuevoAlquiler() throws IOException{
        // Guardar los datos en una nueva fila del archivo.
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        int NumRegistros = Alquileres.getLastRowNum();
        HSSFRow Fila = Alquileres.createRow(NumRegistros+1);
        
        //Cargamos las variables en las celdas.        
        HSSFCell CeldaID = Fila.createCell(0);
        try{
            int ID = (int) Alquileres.getRow(NumRegistros).getCell(0).getNumericCellValue()+1;
            CeldaID.setCellValue(ID);
            ID_Alquiler=ID;//Esto es para mandarlo a la hoja de despacho.
        }
        catch(IllegalStateException n){
            CeldaID.setCellValue(1);
            ID_Alquiler=1;//Esto es para mandarlo a la hoja de despacho.
        }     
        HSSFCell CeldaA = Fila.createCell(1);
        CeldaA.setCellValue(Clientes.ID_Cliente);
        
        HSSFCell CeldaB = Fila.createCell(2);
        CeldaB.setCellValue(ADestino);
        
        HSSFCell CeldaC = Fila.createCell(3);
        CeldaC.setCellValue(ATelf);
        
        HSSFCell CeldaD = Fila.createCell(4);
        CeldaD.setCellValue(AItem1);
        
        HSSFCell CeldaE = Fila.createCell(5);
        CeldaE.setCellValue(ACant1);
        
        HSSFCell CeldaF = Fila.createCell(6);
        CeldaF.setCellValue(AMonto1);
        
        HSSFCell CeldaG = Fila.createCell(7);
        CeldaG.setCellValue(AItem2);
        
        HSSFCell CeldaH = Fila.createCell(8);
        CeldaH.setCellValue(ACant2);
        
        HSSFCell CeldaI = Fila.createCell(9);
        CeldaI.setCellValue(AMonto2);
        
        HSSFCell CeldaJ = Fila.createCell(10);
        CeldaJ.setCellValue(AItem3);
        
        HSSFCell CeldaK = Fila.createCell(11);
        CeldaK.setCellValue(ACant3);
        
        HSSFCell CeldaL = Fila.createCell(12);
        CeldaL.setCellValue(AMonto3);
        
        HSSFCell CeldaM = Fila.createCell(13);
        CeldaM.setCellValue(AItem4);
        
        HSSFCell CeldaN = Fila.createCell(14);
        CeldaN.setCellValue(ACant4);
        
        HSSFCell CeldaO = Fila.createCell(15);
        CeldaO.setCellValue(AMonto4);
        
        HSSFCell CeldaP = Fila.createCell(16);
        CeldaP.setCellValue(AItem5);
        
        HSSFCell CeldaQ = Fila.createCell(17);
        CeldaQ.setCellValue(ACant5);
        
        HSSFCell CeldaR = Fila.createCell(18);
        CeldaR.setCellValue(AMonto5);
        
        HSSFCell CeldaS = Fila.createCell(19);
        CeldaS.setCellValue(AItem6);
        
        HSSFCell CeldaT = Fila.createCell(20);
        CeldaT.setCellValue(ACant6);
        
        HSSFCell CeldaU = Fila.createCell(21);
        CeldaU.setCellValue(AMonto6);
        
        HSSFCell CeldaV = Fila.createCell(22);
        HSSFRichTextString textoV = new HSSFRichTextString(AFecha1);
        CeldaV.setCellValue(textoV);
        
        HSSFCell CeldaW = Fila.createCell(23);
        HSSFRichTextString textoW = new HSSFRichTextString(AFecha2);
        CeldaW.setCellValue(textoW);
        
        HSSFCell CeldaX = Fila.createCell(24);
        CeldaX.setCellValue(AComentarios);
        
        HSSFCell CeldaY = Fila.createCell(25);
        CeldaY.setCellValue(APendiente);
        
        HSSFCell CeldaZ = Fila.createCell(26);
        CeldaZ.setCellValue(ADias);
        
        HSSFCell CeldaAA = Fila.createCell(27);
        CeldaAA.setCellValue("-No Cobrado-");
        
        HSSFCell CeldaBB = Fila.createCell(28);
        CeldaBB.setCellValue(AAC);
        
        HSSFCell CeldaCC = Fila.createCell(29);
        CeldaCC.setCellValue(ANumDep);
        
        HSSFCell CeldaDD = Fila.createCell(30);
        CeldaDD.setCellValue(AFecha3);
        //Guardamos el archivo.
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El alquiler se ha iniciado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void abrirAlquiler() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        //Buscamos el Dialogo_Alquiler con ese ID en el archivo
        int NumRegistros = Alquileres.getLastRowNum();
        for (int i=1;i<= NumRegistros;i++){
            if (ID_Alquiler==(int)Alquileres.getRow(i).getCell(0).getNumericCellValue()){
                //Se guardan los datos en variables globales para pasarlas al JDialog.
                Clientes.ID_Cliente=(int)Alquileres.getRow(i).getCell(1).getNumericCellValue();
                ADestino=Alquileres.getRow(i).getCell(2).getStringCellValue();
                ATelf=Alquileres.getRow(i).getCell(3).getStringCellValue();
                AItem1=Alquileres.getRow(i).getCell(4).getStringCellValue();
                ACant1=(int)Alquileres.getRow(i).getCell(5).getNumericCellValue();
                AMonto1=(double)Alquileres.getRow(i).getCell(6).getNumericCellValue();
                AItem2=Alquileres.getRow(i).getCell(7).getStringCellValue();
                ACant2=(int)Alquileres.getRow(i).getCell(8).getNumericCellValue();
                AMonto2=(double)Alquileres.getRow(i).getCell(9).getNumericCellValue();
                AItem3=Alquileres.getRow(i).getCell(10).getStringCellValue();
                ACant3=(int)Alquileres.getRow(i).getCell(11).getNumericCellValue();
                AMonto3=(double)Alquileres.getRow(i).getCell(12).getNumericCellValue();
                AItem4=Alquileres.getRow(i).getCell(13).getStringCellValue();
                ACant4=(int)Alquileres.getRow(i).getCell(14).getNumericCellValue();
                AMonto4=(double)Alquileres.getRow(i).getCell(15).getNumericCellValue();
                AItem5=Alquileres.getRow(i).getCell(16).getStringCellValue();
                ACant5=(int)Alquileres.getRow(i).getCell(17).getNumericCellValue();
                AMonto5=(double)Alquileres.getRow(i).getCell(18).getNumericCellValue();
                AItem6=Alquileres.getRow(i).getCell(19).getStringCellValue();
                ACant6=(int)Alquileres.getRow(i).getCell(20).getNumericCellValue();
                AMonto6=(double)Alquileres.getRow(i).getCell(21).getNumericCellValue();
//                Date fecha = new Date();
//                fecha=Alquileres.getRow(i).getCell(22).getDateCellValue();
//                AFecha1.setTime(fecha);
                AFecha1=Alquileres.getRow(i).getCell(22).getStringCellValue();
                AFecha2=Alquileres.getRow(i).getCell(23).getStringCellValue();
                AComentarios=Alquileres.getRow(i).getCell(24).getStringCellValue();
                Boolean Pendiente=Alquileres.getRow(i).getCell(25).getBooleanCellValue();
                ADias=(int)Alquileres.getRow(i).getCell(26).getNumericCellValue();
                ACobrador=Alquileres.getRow(i).getCell(27).getStringCellValue();
                try{//Necesario por ser un campo añadido a posteriori y puede estar vacío.
                    AAC=(double)Alquileres.getRow(i).getCell(28).getNumericCellValue();
                }catch(Exception e){}
                try{//Necesario por ser un campo añadido a posteriori y puede estar vacío.
                    ANumDep=Alquileres.getRow(i).getCell(29).getStringCellValue();
                }catch(Exception e){}
                try{//Necesario por ser un campo añadido a posteriori y puede estar vacío.
                    AFecha3=Alquileres.getRow(i).getCell(30).getStringCellValue();
                }catch(Exception e){}
                if (Pendiente==true) APendiente=true;
                else APendiente=false;
            }
        }
        General.CargarDatos=true;
    }
    public static void modificarAlquiler() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook    libro = new HSSFWorkbook(fs);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        int NumRegistros = Alquileres.getLastRowNum();
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Alquiler==(int)Alquileres.getRow(i).getCell(0).getNumericCellValue()){
                HSSFCell CeldaB = Alquileres.getRow(i).createCell(2);
                CeldaB.setCellValue(ADestino);
                
                HSSFCell CeldaC = Alquileres.getRow(i).createCell(3);
                CeldaC.setCellValue(ATelf);
                
                HSSFCell CeldaD = Alquileres.getRow(i).createCell(4);
                CeldaD.setCellValue(AItem1);
                
                HSSFCell CeldaE = Alquileres.getRow(i).createCell(5);
                CeldaE.setCellValue(ACant1);
                
                HSSFCell CeldaF = Alquileres.getRow(i).createCell(6);
                CeldaF.setCellValue(AMonto1);
                
                HSSFCell CeldaG = Alquileres.getRow(i).createCell(7);
                CeldaG.setCellValue(AItem2);
                
                HSSFCell CeldaH = Alquileres.getRow(i).createCell(8);
                CeldaH.setCellValue(ACant2);
                
                HSSFCell CeldaI = Alquileres.getRow(i).createCell(9);
                CeldaI.setCellValue(AMonto2);
                
                HSSFCell CeldaJ = Alquileres.getRow(i).createCell(10);
                CeldaJ.setCellValue(AItem3);
                
                HSSFCell CeldaK = Alquileres.getRow(i).createCell(11);
                CeldaK.setCellValue(ACant3);
                
                HSSFCell CeldaL = Alquileres.getRow(i).createCell(12);
                CeldaL.setCellValue(AMonto3);
                
                HSSFCell CeldaM = Alquileres.getRow(i).createCell(13);
                CeldaM.setCellValue(AItem4);
                
                HSSFCell CeldaN = Alquileres.getRow(i).createCell(14);
                CeldaN.setCellValue(ACant4);
                
                HSSFCell CeldaO = Alquileres.getRow(i).createCell(15);
                CeldaO.setCellValue(AMonto4);
                
                HSSFCell CeldaP = Alquileres.getRow(i).createCell(16);
                CeldaP.setCellValue(AItem5);
                
                HSSFCell CeldaQ = Alquileres.getRow(i).createCell(17);
                CeldaQ.setCellValue(ACant5);
                
                HSSFCell CeldaR = Alquileres.getRow(i).createCell(18);
                CeldaR.setCellValue(AMonto5);
                
                HSSFCell CeldaS = Alquileres.getRow(i).createCell(19);
                CeldaS.setCellValue(AItem6);
                
                HSSFCell CeldaT = Alquileres.getRow(i).createCell(20);
                CeldaT.setCellValue(ACant6);
                
                HSSFCell CeldaU = Alquileres.getRow(i).createCell(21);
                CeldaU.setCellValue(AMonto6);
                
                HSSFCell CeldaV = Alquileres.getRow(i).createCell(22);
                CeldaV.setCellValue(AFecha1);
                
                HSSFCell CeldaW = Alquileres.getRow(i).createCell(23);
                CeldaW.setCellValue(AFecha2);
                
                HSSFCell CeldaX = Alquileres.getRow(i).createCell(24);
                CeldaX.setCellValue(AComentarios);
                
                HSSFCell CeldaY = Alquileres.getRow(i).createCell(25);
                CeldaY.setCellValue(APendiente);
                
                HSSFCell CeldaZ = Alquileres.getRow(i).createCell(26);
                CeldaZ.setCellValue(ADias);
                //el cobrador es inmodificable.
                HSSFCell CeldaAA = Alquileres.getRow(i).createCell(28);
                CeldaAA.setCellValue(AAC);
                
                HSSFCell CeldaBB = Alquileres.getRow(i).createCell(29);
                CeldaBB.setCellValue(ANumDep);
                
                HSSFCell CeldaCC = Alquileres.getRow(i).createCell(30);
                CeldaCC.setCellValue(AFecha3);
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El alquiler se ha modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void eliminarAlquiler() throws IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Alquileres = libro.getSheetAt(1);
        int NumRegistros = Alquileres.getLastRowNum();
        //recorremos todos los registros buscando el seleccionado.
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Alquiler == (int)Alquileres.getRow(i).getCell(0).getNumericCellValue()){
                //Cuando lo encontramos sustituimos todas las filas por la siguiente.
                for (int j=i;j<NumRegistros;j++){ //Para ello recorremos la hoja desde el registro seleccionado hasta el final.
                    for (int k=0;k<=29;k++){
                            if (k==0 || k==1 || k==5 || k==8 || k==11 || k==14 || k==17 || k==20 || k==26){ //Campos integer.
                                int valor = (int)Alquileres.getRow(j+1).getCell(k).getNumericCellValue();
                                Alquileres.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else if (k==25){ //Campos Boolean.
                                Boolean valor = Alquileres.getRow(j+1).getCell(k).getBooleanCellValue();
                                Alquileres.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else if (k==6 || k==9 || k==12 || k==15 || k==18 || k==21 || k==28){ //Campos Double.
                                Double valor = (Double)Alquileres.getRow(j+1).getCell(k).getNumericCellValue();
                                Alquileres.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else{ //Campos String, incluidas las fechas.
                                String valor = Alquileres.getRow(j+1).getCell(k).getStringCellValue();
                                HSSFRichTextString Cvalor = new HSSFRichTextString(valor);
                                Alquileres.getRow(j).getCell(k).setCellValue(Cvalor);
                            }
                        }
                }
                Alquileres.removeRow(Alquileres.getRow(NumRegistros));
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El alquiler se ha eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    
    public static String ADestino,ATelf,AItem1,AItem2,AItem3,AItem4,AItem5,AItem6,AComentarios,AFecha1,AFecha2,ACobrador,ANumDep,AFecha3;
    public static Integer ACant1,ACant2,ACant3,ACant4,ACant5,ACant6,ADias;
    public static Double AMonto1,AMonto2,AMonto3,AMonto4,AMonto5,AMonto6,AAC;
    public static Boolean APendiente;
    public static Integer ID_Alquiler;
}
