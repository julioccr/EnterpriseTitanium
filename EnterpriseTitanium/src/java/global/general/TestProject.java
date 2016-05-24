/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JCortorreal
 */
public class TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        java.util.Date fecha = new Date();
        System.out.println(fechaValidaCalendar(fecha));
        
      
    }  
    
    private static String formatoFechaHoraMinutos( java.sql.Date Fecha)  {
    DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return  format1.format(Fecha);
     }
    
     private static java.util.Date fechaValidaCalendar (Date date)  {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
          // format : convierte una fecha a formato string
        // Parset : convierte un String a fecha
         java.sql.Date fecha_convert = new java.sql.Date(calendar.getTime().getTime());
        
         Date fecha_valida = null;
        try {
            fecha_valida = format1.parse( format1.format(fecha_convert));
        } catch (ParseException ex) {
            Logger.getLogger(TestProject.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    return fecha_valida; 
    }
}
