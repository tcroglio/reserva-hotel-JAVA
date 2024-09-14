package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author tiago
 */
public class Utils {
    
    public Utils() {}
    
    public static Date converterStringToDate(String texto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        
        try {
            data = formato.parse(texto);
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
            
        }
        
        return data;
    }
    
     public static String converterDateToString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = "";
        
        try {
            texto = formato.format(data);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
            
        }
        
        return texto;
    }
}
