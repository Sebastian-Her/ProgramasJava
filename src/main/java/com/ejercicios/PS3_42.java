/*
hacer operaciones

 */
package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que invierte un número entero usando operaciones matemáticas
 * Basado en el Problema Suplementario 3.42 (página 438)
 * 
 * @author imac27
 */
public class PS3_42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int n = scanner.nextInt();

        int x = 0;
        int k = 0;

        if (n > 0) {
            while (n > 0) {
                k = n % 10; // Obtener último dígito
                x = x * 10 + k; // Añadir dígito al número invertido
                n = n / 10; // Eliminar último dígito
            }

            // Imprimir el estado final de las variables
            System.out.println("\n--- RESULTADOS ---");
            System.out.println("k (último dígito procesado): " + k);
            System.out.println("x (número invertido): " + x);
            System.out.println("n (valor final): " + n);
        } else {
            System.out.println("El número ingresado no es válido. Debe ser positivo.");
        }

        scanner.close();
    }
}