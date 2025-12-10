package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que calcula el aumento salarial de un trabajador
 * según su categoría usando estructura switch
 * 
 * @author DELL
 */
public class ejemplo_2_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables
        int categoria;
        double sueldo, aumento, nuevoSueldo;

        // Leer datos del usuario
        System.out.print("Ingrese la categoría del trabajador (1-4): ");
        categoria = scanner.nextInt();

        System.out.print("Ingrese el sueldo del trabajador: ");
        sueldo = scanner.nextDouble();

        // Estructura switch para determinar el aumento
        switch (categoria) {
            case 1:
                aumento = sueldo * 0.15;
                break;
            case 2:
                aumento = sueldo * 0.10;
                break;
            case 3:
                aumento = sueldo * 0.08;
                break;
            case 4:
                aumento = sueldo * 0.07;
                break;
            default:
                System.out.println("Categoría inválida. Debe ser entre 1 y 4.");
                scanner.close();
                return;
        }

        // Calcular nuevo sueldo
        nuevoSueldo = sueldo + aumento;

        // Imprimir resultados
        System.out.println("\n--- RESULTADO ---");
        System.out.println("Categoría del trabajador: " + categoria);
        System.out.println("Sueldo anterior: $" + sueldo);
        System.out.println("Aumento: $" + aumento);
        System.out.println("Nuevo sueldo: $" + nuevoSueldo);

        scanner.close();
    }
}