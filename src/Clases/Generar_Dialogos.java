package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Ventanas.Dialogo_AcercaDe;
import Ventanas.Dialogo_Alquiler;
import Ventanas.Dialogo_CargaOnLine;
import Ventanas.Dialogo_Cliente;
import Ventanas.Dialogo_Estadisticas;
import Ventanas.Dialogo_Item;
import Ventanas.Dialogo_Password;
import Ventanas.Dialogo_VerAlquileres;
import Ventanas.Dialogo_VerClientes;
import Ventanas.Dialogo_VerItems;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Kaze
 */
public class Generar_Dialogos {
    public static void mostrarVerClientes() throws FileNotFoundException, IOException{
        Dialogo_VerClientes N = new Dialogo_VerClientes(null,true);
        N.setVisible(true);
    }
    public static void mostrarVerAlquileres() throws FileNotFoundException, IOException{
        Dialogo_VerAlquileres N = new Dialogo_VerAlquileres(null,true);
        N.setVisible(true);
    }
    public static void mostrarVerItems() throws FileNotFoundException, IOException{
        Dialogo_VerItems N = new Dialogo_VerItems(null,true);
        N.setVisible(true);
    }
    public static void mostrarCliente(){
        Dialogo_Cliente N = new Dialogo_Cliente(null,true);
        N.setVisible(true);
    }
    public static void mostrarAlquiler() throws FileNotFoundException, IOException{
        Dialogo_Alquiler N = new Dialogo_Alquiler(null,true);
        N.setVisible(true);
    }
    public static void mostrarItem(){
        Dialogo_Item N = new Dialogo_Item(null,true);
        N.setVisible(true);
    }
    public static void mostrarAcercaDe() throws FileNotFoundException, IOException{
        Dialogo_AcercaDe N = new Dialogo_AcercaDe(null,true);
        N.setVisible(true);
    }
    public static void mostrarCargaOnLine() throws FileNotFoundException, IOException{
        Dialogo_CargaOnLine N = new Dialogo_CargaOnLine(null,true);
        N.setVisible(true);
    }
    public static void mostrarPassword() throws FileNotFoundException, IOException{
        Dialogo_Password N = new Dialogo_Password(null,true);
        N.setVisible(true);
    }
    public static void mostrarEstadisticas() throws FileNotFoundException, IOException{
        Dialogo_Estadisticas N = new Dialogo_Estadisticas(null,true);
        N.setVisible(true);
    }
}

