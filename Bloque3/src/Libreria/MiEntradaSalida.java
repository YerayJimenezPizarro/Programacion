package Libreria;

import java.util.Scanner;

public class MiEntradaSalida {
	private static Scanner teclado = new Scanner(System.in);

	public static int solicitarEntero(String mensaje) {
		int numero = 0;
		boolean entradaValida = false;
		do {
			try {
				System.out.print(mensaje);
				numero = teclado.nextInt();
				entradaValida = true;
			} catch (NumberFormatException e) {
				System.out.println("Error: Ingresa un número entero válido.");
			}
		} while (!entradaValida);
		return numero;
	}

	public static int solicitarEnteroPositivo(String mensaje) {
		int numero;
		do {
			numero = solicitarEntero(mensaje);
			if (numero <= 0) {
				System.out.println("Error: Ingresa un número entero positivo.");
			}
		} while (numero <= 0);
		return numero;
	}

	public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
		int numero;
		do {
			numero = solicitarEntero(mensaje);
			if (numero < limiteInferior || numero > limiteSuperior) {
				System.out.println(
						"Error: Ingresa un número dentro del rango [" + limiteInferior + ", " + limiteSuperior + "].");
			}

		} while (numero < limiteInferior || numero > limiteSuperior);
		return numero;
	}

	public static char solicitarCaracter(String mensaje) {
		char caracter = ' ';
		boolean entradaValida = false;
		do {
			try {
				System.out.print(mensaje);
				caracter = teclado.next().charAt(0);
				entradaValida = true;
			} catch (Exception e) {
				System.out.println("Error: Ingresa un carácter válido.");
			}
		} while (!entradaValida);
		return caracter;
	}

	public static char solicitarCaracterSN(String mensaje) {
		char caracter;
		do {
			caracter = Character.toUpperCase(solicitarCaracter(mensaje));
			if (caracter != 'S' && caracter != 'N') {
				System.out.println("Error: Ingresa 'S' o 'N'.");
			}
		} while (caracter != 'S' && caracter != 'N');
		return caracter;
	}

	public static String solicitarCadena(String mensaje) {
		System.out.print(mensaje);
		String cadena=teclado.next();
		return cadena;
	}
}