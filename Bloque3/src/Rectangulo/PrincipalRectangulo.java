package Rectangulo;

import java.util.Scanner;

public class PrincipalRectangulo {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Rectangulo rectangulo1;
		double ancho, longitud;

		// Creamos un rectángulo con ancho y alto
		System.out.println("Introduzca el ancho: ");
		ancho = Integer.parseInt(teclado.nextLine());

		System.out.println("Introduzca la longitud: ");
		longitud = Integer.parseInt(teclado.nextLine());
		try {

			rectangulo1 = new Rectangulo(ancho, longitud);

			System.out.println("El área es " + rectangulo1.calcularArea());
			System.out.println("El perímetro es " + rectangulo1.calcularPerimetro());

			// Ahora vamos a modificarlo para probar los sets
			System.out.println("Introduzca un nuevo ancho: ");
			ancho = Integer.parseInt(teclado.nextLine());
			rectangulo1.setAncho(ancho);

			System.out.println("Introduzca una nueva longitud: ");
			longitud = Integer.parseInt(teclado.nextLine());
			rectangulo1.setLongitud(longitud);

			System.out.println("El área es " + rectangulo1.calcularArea());
			System.out.println("El perímetro es " + rectangulo1.calcularPerimetro());
		} catch (RectanguloException e) {
			System.err.println(e.getMessage());
		}
	}
}
