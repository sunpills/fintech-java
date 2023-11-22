package br.com.fiap.troca.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TrocaParser {

	
	public static java.util.Date parseStringToDate(String d) {
		Date date = new Date();
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.parse(d);
			return date;
		} catch (ParseException e) {
			return date;
		}
    }
    
    
    public static String parseDateToString(Date date) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(date);
        return s;
    }
	
    
    public static double parseBrazilianCurrency(String input) {
        String cleanInput = input.replaceAll("[^0-9,]", "").replaceAll(",", ".").trim();

        if (cleanInput.isEmpty()) {
            return -1; 
        }

        try {
            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            return format.parse(cleanInput).doubleValue();
        } catch (ParseException e) {
            return -1; 
        }
    }
    
    
    public static String intToString(int numeroInteiro) {
        return Integer.toString(numeroInteiro);
    }
    
    public static int stringToInt(String numeroString) throws NumberFormatException {
        return Integer.parseInt(numeroString);
    }
    
    
    public static boolean parseCheckBox(String valor) {
    	boolean retorno = false;
    	
    	if (valor != null) {
    		if ( "on".equals(valor) ) {
    			retorno = true;
    		}
    	}
    	
    	return retorno;
    }
    
    
    
    
}
