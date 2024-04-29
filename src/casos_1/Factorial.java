package casos_1;

import java.util.Scanner;

/*Ej3: Factorial Recursivo
 Funcion que calcule y retorne el factorial de un numero dado
 */
public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese cualquier número: ");
		int numero = scanner.nextInt();
		scanner.close();
		
		Integer resultado = factorial (numero);
		System.out.println(resultado != null ? "El factorial de " + numero +
				" es: " + resultado : "No tiene factorial");
		
	    System.out.println(factorial(0) != null ? factorial(0) : "no factorial");

	}
	
	private static Integer factorial (int n) {
		if (n < 0) {
			return null;
		}else if (n <= 1) {
			return 1;		
		}else {
			return n * factorial(n - 1);
		}
	}

}
