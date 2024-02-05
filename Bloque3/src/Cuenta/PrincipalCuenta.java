package Cuenta;

import java.util.Scanner;

public class PrincipalCuenta {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Cuenta cuenta1 = new Cuenta(1000);
			Cuenta cuenta2 = new Cuenta(100);
			Cuenta cuenta3 = new Cuenta(500);	
			cuenta1.realizarReintegro(100);
			cuenta2.realizarReintegro(50);
			cuenta3.realizarReintegro(200);
		} catch (CuentaException e) {
			e.getMessage();
		}
		

		System.out.println(Cuenta.gettotalDineroSacado());

//		int opcion;
//		double saldoInicial;
//		Cuenta cuenta;
//		char salir;
//
//		saldoInicial = pedirSaldoInicial();
//		cuenta = new Cuenta(saldoInicial);
//
//		do {
//			opcion = menu(); //  Muestra el menú y solicita la opción
//			salir = tratarMenu(opcion, cuenta); // Trata cada una de las opciones del menú
//		} while (salir == 'n');
	}

	private static double pedirSaldoInicial() {
		double saldoInicial;

		do {
			System.out.println("Introduce el saldo inicial: ");
			saldoInicial = Double.parseDouble(teclado.nextLine());
		} while (saldoInicial < 0);

		return saldoInicial;
	}

	private static int menu() {
		int opcion;

		do {
			System.out.println("Elige una opción:");
			System.out.println("1. Hacer un ingreso.");
			System.out.println("2. Hacer un reintegro.");
			System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados.");
			System.out.println("4. Finalizar las operaciones.");
			opcion = Integer.parseInt(teclado.nextLine());

			if (opcion < 1 || opcion > 4)
				System.out.println("Error. Opción incorrecta.");
		} while (opcion < 1 || opcion > 4);

		return opcion;
	}

	private static char tratarMenu(int opcion, Cuenta cuenta) {
		double cantidad;
		char salir = 'n';

		switch (opcion) {
		case 1: {
			System.out.println("Introduce la cantidad a ingresar: ");
			cantidad = Double.parseDouble(teclado.nextLine());
			try {
				cuenta.realizarIngreso(cantidad);
			} catch (CuentaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 2: {
			System.out.println("Introduce la cantidad a retirar: ");
			cantidad = Double.parseDouble(teclado.nextLine());
			try {
				cuenta.realizarReintegro(cantidad);
			} catch (CuentaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			System.out.println(cuenta);
			break;
		}
		case 4: {
			do {
				System.out.println("¿Estás seguro (s/n)? ");
				salir = teclado.nextLine().charAt(0);
				// Esto convierte el carácter salir a minúsculas
				salir = Character.toLowerCase(salir);
			} while (salir != 's' && salir != 'n');

			if (salir == 's') {
				System.out.println("Dispones de " + cuenta.getSaldo() + "€ de saldo.");
			}

			break;
		}
		}
		return salir;
	}
}
