package casos_1;
/*Reto1. ELIMINANDO CARACTERES
 * Crea funcion reciba dos cadenas parámetro (str1 y str2) e imprima otras dos 
 * str1 caracteres de primera cadena pero no pressentes en la segunda
 * str2 caracteres segunda cadena pero no de la primera
 * */
public class E_caract {
	public class Main {
	    public static void main(String[] args) {
	        printNonCommon("fran", "rodriguez");
	        printNonCommon("aldeadavila de la ribera", "gomecello");

	       // printNonCommonWithFilter("rocio", "enamorado");
	    }

	    private static void printNonCommon(String str1, String str2) {
	        System.out.println("out1: " + findNonCommon(str1, str2));
	        System.out.println("out2: " + findNonCommon(str2, str1));
	    }

	    private static String findNonCommon(String str1, String str2) {
	        StringBuilder out = new StringBuilder();
	        for (char c : str2.toLowerCase().toCharArray()) {
	            if (!str1.toLowerCase().contains(String.valueOf(c))) {
	                out.append(c);
	            }
	        }
	        return out.toString();
	    }

	   /* private static void printNonCommonWithFilter(String str1, String str2) {
	        System.out.println("out1: " + str1.toLowerCase().replaceAll("[" + str2.toLowerCase() + "]", ""));
	        System.out.println("out2: " + str2.toLowerCase().replaceAll("[" + str1.toLowerCase() + "]", ""));
	    }*/
	}
}


