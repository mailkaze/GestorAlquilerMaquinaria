/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author Manuel
 */
public class Crear_Despacho{
        public static void CrearContrato(String NomYApe,String Fecha, int index1,int index2,int index3,int index4,int index5,int index6) throws FileNotFoundException, IOException{
            //Conectamos con la base de datos
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("SokolmetDB"));
            HSSFWorkbook libro = new HSSFWorkbook(fs);
            HSSFSheet Items = libro.getSheetAt(2);
            int NumItems = Items.getLastRowNum();
            //Conectamos con la plantilla
            POIFSFileSystem fs2 = new POIFSFileSystem(new FileInputStream("docs/PlantillaDespacho.xls"));
            HSSFWorkbook plantilla = new HSSFWorkbook(fs2);
            HSSFSheet Contrato =  plantilla.getSheetAt(0);
            
            //Creamos un estilo de celda
            CellStyle style = plantilla.createCellStyle();
            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());
            
            //metemos los datos en los campos del contrato
            HSSFCell CeldaD2 = Contrato.getRow(1).createCell(3);
            CeldaD2.setCellValue(Clases.Alquileres.ID_Alquiler);
            
            HSSFCell CeldaB2 = Contrato.getRow(1).createCell(1);
            CeldaB2.setCellValue(Fecha);   

            HSSFCell CeldaB5 = Contrato.getRow(4).createCell(1);
            CeldaB5.setCellValue(NomYApe);
            HSSFCell CeldaA23 = Contrato.getRow(22).createCell(0);
            CeldaA23.setCellValue(NomYApe);
            
            HSSFCell CeldaB4 = Contrato.getRow(3).createCell(1);
            CeldaB4.setCellValue(Clases.Alquileres.ADestino);
            
            HSSFCell CeldaD4 = Contrato.getRow(3).createCell(3);
            CeldaD4.setCellValue(Clases.Alquileres.ATelf);
            
            HSSFCell CeldaB9 = Contrato.getRow(8).createCell(1);
            CeldaB9.setCellValue(Clases.Alquileres.AItem1);
            CeldaB9.setCellStyle(style);
            HSSFCell CeldaB10 = Contrato.getRow(9).createCell(1);
            CeldaB10.setCellValue(Clases.Alquileres.AItem2);
            CeldaB10.setCellStyle(style);
            HSSFCell CeldaB11 = Contrato.getRow(10).createCell(1);
            CeldaB11.setCellValue(Clases.Alquileres.AItem3);
            CeldaB11.setCellStyle(style);
            HSSFCell CeldaB12 = Contrato.getRow(11).createCell(1);
            CeldaB12.setCellValue(Clases.Alquileres.AItem4);
            CeldaB12.setCellStyle(style);
            HSSFCell CeldaB13 = Contrato.getRow(12).createCell(1);
            CeldaB13.setCellValue(Clases.Alquileres.AItem5);
            CeldaB13.setCellStyle(style);
            HSSFCell CeldaB14 = Contrato.getRow(13).createCell(1);
            CeldaB14.setCellValue(Clases.Alquileres.AItem6);
            CeldaB14.setCellStyle(style);
            
            HSSFCell CeldaA9 = Contrato.getRow(8).createCell(0);
            CeldaA9.setCellValue(Clases.Alquileres.ACant1);
            CeldaA9.setCellStyle(style);
            HSSFCell CeldaA10 = Contrato.getRow(9).createCell(0);
            CeldaA10.setCellValue(Clases.Alquileres.ACant2);
            CeldaA10.setCellStyle(style);
            HSSFCell CeldaA11 = Contrato.getRow(10).createCell(0);
            CeldaA11.setCellValue(Clases.Alquileres.ACant3);
            CeldaA11.setCellStyle(style);
            HSSFCell CeldaA12 = Contrato.getRow(11).createCell(0);
            CeldaA12.setCellValue(Clases.Alquileres.ACant4);
            CeldaA12.setCellStyle(style);
            HSSFCell CeldaA13 = Contrato.getRow(12).createCell(0);
            CeldaA13.setCellValue(Clases.Alquileres.ACant5);
            CeldaA13.setCellStyle(style);
            HSSFCell CeldaA14 = Contrato.getRow(13).createCell(0);
            CeldaA14.setCellValue(Clases.Alquileres.ACant6);
            CeldaA14.setCellStyle(style);
            
            HSSFCell CeldaB18 = Contrato.getRow(17).createCell(1);
            CeldaB18.setCellValue(Clases.Alquileres.ADias);
            CeldaB18.setCellStyle(style);

            HSSFCell CeldaD3 = Contrato.getRow(2).createCell(3);
            CeldaD3.setCellValue(Clases.Clientes.CNIT);
            
            HSSFCell CeldaB3 = Contrato.getRow(2).createCell(1);
            CeldaB3.setCellValue(Clases.Clientes.CEmpresa);
            
            HSSFCell CeldaD5 = Contrato.getRow(4).createCell(3);
            CeldaD5.setCellValue(Clases.Clientes.CTelfCasa);
        
            HSSFCell CeldaB6 = Contrato.getRow(5).createCell(1);
            CeldaB6.setCellValue(Clases.Clientes.CDireccion);
            
            HSSFCell CeldaD6 = Contrato.getRow(5).createCell(3);
            CeldaD6.setCellValue(Clases.Clientes.CCel);
            
            HSSFCell CeldaB7 = Contrato.getRow(6).createCell(1);
            CeldaB7.setCellValue(Clases.Clientes.CEmail);
            
            HSSFCell CeldaD23 = Contrato.getRow(22).createCell(3);
            CeldaD23.setCellValue(Clases.Clientes.CCI);
            
            //Buscamos los datos de la tabla Items
            Double precio1=0.0,precio2=0.0,precio3=0.0,precio4=0.0,precio5=0.0,precio6=0.0;
            for (int i=1;i<= NumItems;i++){
                if (index1!=0 && index1==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio1=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
                if (index2!=0 && index2==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio2=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
                if (index3!=0 && index3==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio3=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
                if (index4!=0 && index4==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio4=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
                if (index5!=0 && index5==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio5=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
                if (index6!=0 && index6==(int)Items.getRow(i).getCell(0).getNumericCellValue()){
                    precio6=(Double)Items.getRow(i).getCell(2).getNumericCellValue();
                }
            }
            
            HSSFCell CeldaC9 = Contrato.getRow(8).createCell(2);
            CeldaC9.setCellValue(precio1);
            CeldaC9.setCellStyle(style);
            HSSFCell CeldaC10 = Contrato.getRow(9).createCell(2);
            CeldaC10.setCellValue(precio2);
            CeldaC10.setCellStyle(style);
            HSSFCell CeldaC11 = Contrato.getRow(10).createCell(2);
            CeldaC11.setCellValue(precio3);
            CeldaC11.setCellStyle(style);
            HSSFCell CeldaC12 = Contrato.getRow(11).createCell(2);
            CeldaC12.setCellValue(precio4);
            CeldaC12.setCellStyle(style);
            HSSFCell CeldaC13 = Contrato.getRow(12).createCell(2);
            CeldaC13.setCellValue(precio5);
            CeldaC13.setCellStyle(style);
            HSSFCell CeldaC14 = Contrato.getRow(13).createCell(2);
            CeldaC14.setCellValue(precio6);
            CeldaC14.setCellStyle(style);
            
            HSSFCell CeldaD9 = Contrato.getRow(8).createCell(3);
            CeldaD9.setCellValue(Clases.Alquileres.AMonto1);
            CeldaD9.setCellStyle(style);
            HSSFCell CeldaD10 = Contrato.getRow(9).createCell(3);
            CeldaD10.setCellValue(Clases.Alquileres.AMonto2);
            CeldaD10.setCellStyle(style);
            HSSFCell CeldaD11 = Contrato.getRow(10).createCell(3);
            CeldaD11.setCellValue(Clases.Alquileres.AMonto3);
            CeldaD11.setCellStyle(style);
            HSSFCell CeldaD12 = Contrato.getRow(11).createCell(3);
            CeldaD12.setCellValue(Clases.Alquileres.AMonto4);
            CeldaD12.setCellStyle(style);
            HSSFCell CeldaD13 = Contrato.getRow(12).createCell(3);
            CeldaD13.setCellValue(Clases.Alquileres.AMonto5);
            CeldaD13.setCellStyle(style);
            HSSFCell CeldaD14 = Contrato.getRow(13).createCell(3);
            CeldaD14.setCellValue(Clases.Alquileres.AMonto6);
            CeldaD14.setCellStyle(style);
            
            HSSFCell CeldaA18 = Contrato.getRow(17).createCell(0);
            CeldaA18.setCellValue(Clases.Alquileres.AMonto1+Clases.Alquileres.AMonto2+
                                  Clases.Alquileres.AMonto3+Clases.Alquileres.AMonto4+
                                  Clases.Alquileres.AMonto5+Clases.Alquileres.AMonto6);
            CeldaA18.setCellStyle(style);
            
            HSSFCell CeldaD15 = Contrato.getRow(14).createCell(3);
            CeldaD15.setCellValue(CeldaA18.getNumericCellValue());
            CeldaD15.setCellStyle(style);
            
            HSSFCell CeldaC18 = Contrato.getRow(17).createCell(2);
            CeldaC18.setCellValue(CeldaA18.getNumericCellValue()*CeldaB18.getNumericCellValue());
            CeldaC18.setCellStyle(style);
            
            try{
                HSSFCell CeldaC19 = Contrato.getRow(17).createCell(3);
                CeldaC19.setCellValue(Clases.Alquileres.AAC);
                CeldaC19.setCellStyle(style);
            }catch(Exception e){}
            
            try {
                FileOutputStream elFichero = new FileOutputStream("docs/Despacho-"+Clases.Alquileres.ID_Alquiler+".xls");
                plantilla.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocurrió un error al crear la hoja de despacho.");
            }
            
            Desktop desktop = Desktop.getDesktop(); //Instanciamos la clase Desktop
            String ruta="docs/Despacho-"+Clases.Alquileres.ID_Alquiler+".xls"; //Le damos la ruta del archivo.
            File archivo = new File(ruta); //Instanciamos la clase File con esa ruta.
            desktop.open(archivo); //el método open de la clase Desktop llama al programa prederminado que abre ese archivo.
        }      
}
