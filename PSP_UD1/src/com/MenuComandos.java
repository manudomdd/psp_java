package com;

import java.util.Scanner;

public class MenuComandos {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            limpiarConsola();
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1 -> ejecutarComando("uname -a");
                case 2 -> ejecutarComando("hostnamectl");
                case 3 -> ejecutarComando("lscpu");
                case 4 -> ejecutarComando("timedatectl status");
                case 5 -> {
                    System.out.println("Programa finalizado.");
                    return;
                }
                default -> System.out.println("Seleccione una opción válida.");
            }

            esperarEnter();
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. uname -a");
        System.out.println("2. hostnamectl");
        System.out.println("3. lscpu");
        System.out.println("4. timedatectl status");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    private static int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Intente nuevamente: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void ejecutarComando(String comando) {
        try {
            ProcessBuilder pb = new ProcessBuilder(Utils.sh(comando));
            pb.inheritIO();
            Process proceso = pb.start();

            int rc = proceso.waitFor();
            System.out.println("RC = " + rc);

            if (rc == 0) {
                System.out.println("El comando se ejecutó correctamente.");
            } else {
                System.out.println("El comando terminó con errores.");
            }

        } catch (Exception e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
        }
    }

    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void esperarEnter() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine(); 
        scanner.nextLine(); 
    }
}

