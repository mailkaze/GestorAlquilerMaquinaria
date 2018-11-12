package Clases;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorearTablas extends DefaultTableCellRenderer{

    private int columna_patron;
    private boolean pendiente;

    public ColorearTablas(int Colpatron, boolean esPendiente)
    {
        this.columna_patron = Colpatron;
        this.pendiente = esPendiente;
        
    }

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yy");
        try {
            Date fechaEntrega = formatoDeFecha.parse(String.valueOf(table.getValueAt(row,columna_patron)));
            java.util.Date hoy = new Date(); //Cargamos la fecha del sistema
            
            if (fechaEntrega.before(hoy)&& pendiente==true){
                setBackground(Color.red);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ColorearTablas.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }

}