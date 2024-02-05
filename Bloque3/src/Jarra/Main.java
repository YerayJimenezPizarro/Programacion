package Jarra;

import java.util.Scanner;

public class Main {
public static Scanner teclado=new Scanner(System.in);

    public static void main(String[] args) {
        
        Jarra jarraA, jarraB;
        double capacidadA, capacidadB;

        try {
            System.out.print("Ingrese la capacidad de la jarra A: ");
            capacidadA = Double.parseDouble(teclado.nextLine());
            jarraA = new Jarra(capacidadA);

            System.out.print("Ingrese la capacidad de la jarra B: ");
            capacidadB = Double.parseDouble(teclado.nextLine());
            jarraB = new Jarra(capacidadB);

            int opcionMenu;
            do {
                System.out.println("\nMenú:");
                System.out.println("1. Llenar jarra");
                System.out.println("2. Vaciar jarra");
                System.out.println("3. Volcar jarra A en B");
                System.out.println("4. Volcar jarra B en A");
                System.out.println("5. Ver estado de las jarras");
                System.out.println("6. Salir");

                System.out.print("Seleccione una opción (1-6): ");
                opcionMenu = teclado.nextInt();

                switch (opcionMenu) {
                    case 1:
                        llenarJarra(jarraA, jarraB);
                        break;
                    case 2:
                        vaciarJarra(jarraA, jarraB);
                        break;
                    case 3:
                        jarraA.volcarJarra(jarraB);
                        break;
                    case 4:
                        jarraB.volcarJarra(jarraA);
                        break;
                    case 5:
                        mostrarEstadoJarras(jarraA, jarraB);
                        break;
                    case 6:
                        System.out.println("El total de agua que se ha gastado llenando jarras es " + Jarra.getTotalAguaConsumida() + " litros");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }

            } while (opcionMenu != 6);

        } catch (JarraException e) {
            System.out.println("Error al crear las jarras: " + e.getMessage());
        }
    }

    private static void llenarJarra(Jarra jarraA, Jarra jarraB) {
        System.out.print("¿Qué jarra desea llenar (A/B)? ");
        char opcionJarra = teclado.next().charAt(0);

        if (opcionJarra == 'A' || opcionJarra == 'a') {
            jarraA.llenarJarra();
        } else if (opcionJarra == 'B' || opcionJarra == 'b') {
            jarraB.llenarJarra();
        } else {
            System.out.println("Opción no válida. Por favor, seleccione A o B.");
        }
    }

    private static void vaciarJarra(Jarra jarraA, Jarra jarraB) {
        System.out.print("¿Qué jarra desea vaciar (A/B)? ");
        char opcion = teclado.next().charAt(0);

        if (opcion == 'A' || opcion == 'a') {
            jarraA.vaciarJarra();
        } else if (opcion == 'B' || opcion == 'b') {
            jarraB.vaciarJarra();
        } else {
            System.out.println("Opción no válida. Por favor, seleccione A o B.");
        }
    }

    private static void mostrarEstadoJarras(Jarra jarraA, Jarra jarraB) {
        System.out.println("\nEstado de la jarra A:");
        System.out.println("Capacidad: " + jarraA.getCapacidad() + " litros");
        System.out.println("Cantidad de agua: " + jarraA.getCantidadDeAgua() + " litros");

        System.out.println("\nEstado de la jarra B:");
        System.out.println("Capacidad: " + jarraB.getCapacidad() + " litros");
        System.out.println("Cantidad de agua: " + jarraB.getCantidadDeAgua() + " litros");
    }
}
