package funcionesControl;

import java.util.regex.Pattern;

public class Controles {
	
	public static boolean isAlpha(String s) {
		
		if (s.isEmpty()==true) {
		return false;
		}
	    char[] charArr = s.toCharArray();
	    for(char c : charArr) {
	        if(!Character.isLetter(c) || Character.isSpaceChar(charArr[0])||Character.isWhitespace(charArr[0])) {
	        	return false; 
	        }
	      }
		return true;
	}
	


	
	public static boolean isNumeric(String cadena) {

		   if (cadena.isEmpty()==true) {
			   return false;
		   }
		        try {
		            Integer.parseInt(cadena);
		            return true;
		        } catch (NumberFormatException excepcion) {
		            return false;
		        }

		   }
	
	public static boolean isDir(String cadena) {
		if (cadena.isEmpty()==true) {
			   return false;
		   }
		if(Pattern.matches("(^([0-9]|[a-z]|[A-Z]|á|Á|é|É|í|Í|ó|Ó|ú|Ú|ñ|Ñ|ü|Ü|\\.|\\s|')+|^)$", cadena)) {
			return true;
		}
		else {
			return false;
		}
	}
		
		
		public static boolean isEmail(String cadena) {
			if (cadena.isEmpty()==true) {
				   return false;
			   }
			if(Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", cadena)) {
				return true;
			}
			else {
				return false;
			}	
		}
		
		public static boolean isAño(String cadena) {
			if(cadena.isEmpty()==true){
				return false;
			}
			if(Pattern.matches("\\d{4}", cadena)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		public static boolean isLegajo(String cadena) {
			if(cadena.isEmpty()==true){
				return false;
			}
			if(Pattern.matches("\\d{6}", cadena)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public static boolean isISBN(String cadena) {
			if(cadena.isEmpty()==true){
				return false;
			}
			if(Pattern.matches("\\d{5}", cadena)) {
				return true;
			}
			else {
				return false;
			}
		}
		

}
