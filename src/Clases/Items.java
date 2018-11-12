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
public class Items {
    public static void guardarNuevoItem() throws IOException{
        // Guardar los datos en una nueva fila del archivo.
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        int NumRegistros = Items.getLastRowNum();
        HSSFRow Fila = Items.createRow(NumRegistros+1);
        
        //Cargamos las variables en las celdas.        
        HSSFCell CeldaID = Fila.createCell(0);
        try{
            int ID = (int) Items.getRow(NumRegistros).getCell(0).getNumericCellValue()+1;
            CeldaID.setCellValue(ID);
        }
        catch(IllegalStateException n){
            CeldaID.setCellValue(1);
        }
                
        HSSFCell CeldaA = Fila.createCell(1);
        HSSFRichTextString textoA = new HSSFRichTextString(INombre);
        CeldaA.setCellValue(textoA);
        
        HSSFCell CeldaB = Fila.createCell(2);
        CeldaB.setCellValue(IPrecio);
        
        HSSFCell CeldaC = Fila.createCell(3);
        CeldaC.setCellValue(IStock);
        
        //Guardamos el archivo.
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El ítem se ha guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void abrirItem() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        //Buscamos el item con ese ID en el archivo
        int NumRegistros = Items.getLastRowNum();
        for (int i=1;i<= NumRegistros;i++){
            if (ID_Item==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                //Se guardan los datos en variables globales para pasarlas al JDialog.
                INombre=Items.getRow(i).getCell(1).getStringCellValue();
                IPrecio=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                IStock=(int)Items.getRow(i).getCell(3).getNumericCellValue();
            }
        }
        General.CargarDatos=true;
    }
    public static void modificarItem() throws FileNotFoundException, IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook    libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        int NumRegistros = Items.getLastRowNum();
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Item==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                HSSFCell CeldaA = Items.getRow(i).createCell(1);
                HSSFRichTextString textoA = new HSSFRichTextString(INombre);
                CeldaA.setCellValue(textoA);

                HSSFCell CeldaB = Items.getRow(i).createCell(2);
                CeldaB.setCellValue(IPrecio);

                HSSFCell CeldaC = Items.getRow(i).createCell(3);
                CeldaC.setCellValue(IStock);
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El Item se ha modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    public static void eliminarItem() throws IOException{
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
        HSSFWorkbook libro = new HSSFWorkbook(fs);
        HSSFSheet Items = libro.getSheetAt(2);
        int NumRegistros = Items.getLastRowNum();
        //recorremos todos los registros buscando el seleccionado.
        for (int i=1;i<=NumRegistros;i++){
            if (ID_Item == (int)Items.getRow(i).getCell(0).getNumericCellValue()){
                //Cuando lo encontramos sustituimos todas las filas por la siguiente.
                for (int j=i;j<NumRegistros;j++){ //Para ello recorremos la hoja desde el registro seleccionado hasta el final.
                    for (int k=0;k<=3;k++){
                            if (k==0 || k==3){ //Si es el campo ID hay que utilizar variable númerica.
                                int valor = (int)Items.getRow(j+1).getCell(k).getNumericCellValue();
                                Items.getRow(j).getCell(k).setCellValue(valor);
                            }
                            else if (k==1){
                                String valor = Items.getRow(j+1).getCell(k).getStringCellValue();
                                HSSFRichTextString Cvalor = new HSSFRichTextString(valor);
                                Items.getRow(j).getCell(k).setCellValue(Cvalor);
                            }
                            else if (k==2){
                                Double valor = (Double)Items.getRow(j+1).getCell(k).getNumericCellValue();
                                Items.getRow(j).getCell(k).setCellValue(valor);
                            }
                        }
                }
                Items.removeRow(Items.getRow(NumRegistros));
                break;
            }
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("SokolmetDB");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "El ítem se ha eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la base de datos\nporque está siendo utilizada en este momento.");
        }
    }
    
    public static String INombre;
    public static Double IPrecio;
    public static Integer IStock;
    public static Integer ID_Item;
}
