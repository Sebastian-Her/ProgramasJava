/*
Construya un diagrama de flujo que almacene en un arreglo unidimensional todos los años bisiestos y perfectos comprendidos desde el año 1 hasta el año 2020.Cabe aclarar que un año es bisiesto si es divisible entre 4, sin embargo no se considera bisiesto si es divisible entre 100 a menos que sea divisible entre 400.Por otra parte, un número se considera perfecto si es igual a la suma de sus divisores, incluyendo al 1 y exceptuando a él mismo. Por ejemplo, el 6 es perfecto (6 = 1 + 2 + 3).
*/
package com.ejercicios;

/**
 * Programa que encuentra años bisiestos y números perfectos del 1 al 2020
 * Basado en el Problema Suplementario 4.14 (página 445)
 * 
 * @author DELL
 */
public class PS4_14 {
    public static void main(String[] args) {
        int[] bisiestos = new int[2020]; // Arreglo para almacenar años bisiestos
        int[] perfectos = new int[2020]; // Arreglo para almacenar años perfectos

        int contadorBisiestos = 0; // Contador de años bisiestos
        int contadorPerfectos = 0; // Contador de años perfectos

        for (int year = 1; year <= 2020; year++) {
            if (esBisiesto(year)) {
                bisiestos[contadorBisiestos] = year;
                contadorBisiestos++;
            }

            if (esPerfecto(year)) {
                perfectos[contadorPerfectos] = year;
                contadorPerfectos++;
            }
        }

        // Imprimir años bisiestos
        System.out.println("Años bisiestos:");
        for (int i = 0; i < contadorBisiestos; i++) {
            System.out.print(bisiestos[i] + " ");
        }
        System.out.println();

        // Imprimir años perfectos
        System.out.println("\nAños perfectos:");
        for (int i = 0; i < contadorPerfectos; i++) {
            System.out.print(perfectos[i] + " ");
        }
    }

    // Método estático para verificar si un año es bisiesto
    public static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Método estático para verificar si un número es perfecto
    public static boolean esPerfecto(int num) {
        int sumaDivisores = 1; // Comienza con 1 ya que todo número es divisible por 1

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }

        return sumaDivisores == num;
    }
}