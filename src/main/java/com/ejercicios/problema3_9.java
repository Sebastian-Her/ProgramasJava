package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que calcula la suma de la serie: 1^1 + 2^2 + 3^3 + ... + N^N
 * Basado en el Problema 3.9 del libro
 * 
 * @author imac28
 */
public class problema3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de términos (N): ");
        int n = scanner.nextInt();

        // Validación de entrada
        if (n <= 0) {
            System.out.println("Error: El número debe ser positivo.");
            scanner.close();
            return;
        }

        double sumaSerie = calcularSumaSerie(n);

        System.out.println("La suma de la serie es: " + sumaSerie);

        scanner.close();
    }

    /**
     * Método estático que calcula la suma de la serie 1^1 + 2^2 + 3^3 + ... + n^n
     * 
     * @param n Número de términos de la serie
     * @return La suma total de la serie
     */
    static double calcularSumaSerie(int n) {
        double suma = 0;

        for (int i = 1; i <= n; i++) {
            suma += Math.pow(i, i);
        }

        return suma;
    }
}