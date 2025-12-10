/*
SUELDO _HORAS_EXTRAS
{El program a calcula lo que hay que pagarle a un trabajador teniendo en cuenta su
sueldo, horas extras y su categoría}
 */

package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que cuenta calificaciones por rangos
 * Basado en el Problema Suplementario 3.13 (página 422)
 */
public class PS3_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declarar variables para contar las calificaciones en cada rango
        int conteo1 = 0; // 0...3.99
        int conteo2 = 0; // 4...5.99
        int conteo3 = 0; // 6...7.99
        int conteo4 = 0; // 8...10

        System.out.print("Ingrese una calificación (-1 para finalizar): ");
        double calificacion = scanner.nextDouble();

        // Leer las calificaciones y contar en cada rango hasta que se ingrese -1
        while (calificacion != -1) {
            if (calificacion >= 0 && calificacion <= 3.99) {
                conteo1++;
            } else if (calificacion >= 4 && calificacion <= 5.99) {
                conteo2++;
            } else if (calificacion >= 6 && calificacion <= 7.99) {
                conteo3++;
            } else if (calificacion >= 8 && calificacion <= 10) {
                conteo4++;
            }

            System.out.print("Ingrese una calificación (-1 para finalizar): ");
            calificacion = scanner.nextDouble();
        }

        // Imprimir los resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Calificaciones en el rango 0...3.99: " + conteo1);
        System.out.println("Calificaciones en el rango 4...5.99: " + conteo2);
        System.out.println("Calificaciones en el rango 6...7.99: " + conteo3);
        System.out.println("Calificaciones en el rango 8...10: " + conteo4);

        scanner.close();
    }
}