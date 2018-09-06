
package recursos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import view.Livros;

public class MascaraData {
    
    public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
    }
            
    java.sql.Date DataSQL = null;
    public java.sql.Date converteData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            Date data1 = sdf.parse(data);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
            String datastr = sdf2.format(data1);
            Date datafinal = new Date(datastr);
            DataSQL = new java.sql.Date(datafinal.getTime());   
            System.out.println(DataSQL);
            
        } catch (ParseException ex) {
            Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DataSQL;
    }
    
}
