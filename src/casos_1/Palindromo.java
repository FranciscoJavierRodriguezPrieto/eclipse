package casos_1;

import java.text.Normalizer;

/*Reto2. PALINDROMO
 * Crea funcion reciba texto y retorne V or F segun sea un palindromo o no
 * */
public class Palindromo {

	public static void main(String[] args) {
		System.out.println(isPalindrome("Ana lleva al oso la avellana"));
		System.out.println(isPalindrome("francisco javier rodriguez prieto"));

	}
	
	private static boolean isPalindrome (String text) {
		String normalizedText = Normalizer.normalize(text.toLowerCase(), Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "")
				.replaceAll("[^a-z0-9]", "");
		return normalizedText.equals(new StringBuilder(normalizedText).reverse().toString());
	}

}
