package Linea;

import java.util.Scanner;

public class LineaPrincipal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
// Solicitar puntos por teclado
		System.out.println("Ingrese las coordenadas del primer punto:");
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();
		Punto punto1 = new Punto(x1, y1);
		System.out.println("Ingrese las coordenadas del segundo punto:");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		Punto punto2 = new Punto(x2, y2);
		try {
			// Crear línea
			Linea linea = new Linea(punto1, punto2);
			int opcion;
			do {
				// Mostrar menú
				System.out.println("\nMenú:");
				System.out.println("1. Mover línea");
				System.out.println("2. Mostrar línea");
				System.out.println("3. Salir");
				System.out.print("Seleccione una opción: ");
				opcion = scanner.nextInt();
				switch (opcion) {
				case 1:
					// Mover línea
					System.out.println("Seleccione el movimiento (A-arriba, B-abajo, I-izquierda,D-derecha): ");

					char movimiento = scanner.next().charAt(0);
					switch (movimiento) {
					case 'A':
						System.out.print("Ingrese la distancia hacia arriba: ");
						double distanciaArriba = scanner.nextDouble();
						linea.moverArriba(distanciaArriba);
						break;
					case 'B':
						System.out.print("Ingrese la distancia hacia abajo: ");
						double distanciaAbajo = scanner.nextDouble();
						linea.moverAbajo(distanciaAbajo);

						break;
					case 'I':
						System.out.print("Ingrese la distancia hacia la izquierda: ");
						double distanciaIzquierda = scanner.nextDouble();
						linea.moverIzquierda(distanciaIzquierda);
						break;
					case 'D':
						System.out.print("Ingrese la distancia hacia la derecha: ");
						double distanciaDerecha = scanner.nextDouble();
						linea.moverDerecha(distanciaDerecha);
						break;
					default:
						System.out.println("Movimiento no válido.");
					}
					break;
				case 2:
					// Mostrar línea
					System.out.println("Línea actual: " + linea.toString());
					break;
				case 3:
					// Salir
					System.out.println("Saliendo del programa.");
					break;
				default:
					System.out.println("Opción no válida. Intente nuevamente.");
				}
			} while (opcion != 3);
		} catch (LineaException e) {
			System.out.println("Error al crear la línea: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}