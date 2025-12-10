package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que maneja un sistema de reservas de teatro
 * Basado en el Problema Suplementario 4.30 (página 452)
 * 
 * @author imac28
 */
public class PS4_30 {

    // Método estático para verificar si el teatro está completamente lleno
    static boolean verificarTeatroLleno(String[][] teatro) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 10; j++) {
                if (teatro[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación del arreglo bidimensional para el teatro
        String[][] TEATRO = new String[26][10];

        // Inicialización del arreglo con asientos vacíos
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 10; j++) {
                TEATRO[i][j] = "";
            }
        }

        // Variable para controlar la disponibilidad del teatro
        boolean teatroLleno = false;

        while (!teatroLleno) {
            // Mostrar estado actual del teatro
            System.out.println("\nEstado actual del teatro:");
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i) + " ");
                for (int j = 0; j < 10; j++) {
                    if (TEATRO[i][j].equals("")) {
                        System.out.print("[_] ");
                    } else {
                        System.out.print("[X] ");
                    }
                }
                System.out.println();
            }

            // Pedir al usuario la elección de asiento
            try {
                System.out.print("\nIngrese la fila (A-Z) del asiento: ");
                char fila = scanner.next().charAt(0);
                scanner.nextLine(); // Limpiar el buffer

                System.out.print("Ingrese el número (1-10) del asiento: ");
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Validar rango de fila y número de asiento
                if (fila < 'A' || fila > 'Z' || numero < 1 || numero > 10) {
                    System.out.println("Opción no válida o fuera de rango. Por favor, intente nuevamente.");
                    continue; // Volver al inicio del ciclo
                }

                // Validar disponibilidad del asiento
                if (TEATRO[fila - 'A'][numero - 1].equals("")) {
                    // Asiento disponible, pedir el nombre del cliente
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    // Reservar el asiento
                    TEATRO[fila - 'A'][numero - 1] = nombre;

                    System.out.println("Reserva realizada con éxito.");

                    // Verificar si el teatro está lleno
                    teatroLleno = verificarTeatroLleno(TEATRO);

                    // Preguntar si el usuario desea salir del programa
                    if (!teatroLleno) {
                        System.out.print("¿Desea salir del programa? (s/n): ");
                        char opcion = scanner.next().charAt(0);
                        scanner.nextLine(); // Limpiar el buffer

                        if (opcion == 's' || opcion == 'S') {
                            teatroLleno = true;
                        }
                    }
                } else {
                    System.out.println("El asiento seleccionado ya está reservado. Por favor, elija otro asiento.");
                }
            } catch (Exception e) {
                System.out.println("Opción no válida o formato incorrecto. Por favor, intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        System.out.println("El teatro está completamente lleno. ¡Gracias por su visita!");
    }

}