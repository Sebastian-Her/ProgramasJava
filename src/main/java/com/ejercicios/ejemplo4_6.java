package com.ejercicios;

import java.math.BigInteger;

/**
 * Programa que genera los primeros 100 números de Fibonacci
 * y los almacena en un arreglo unidimensional
 * Basado en el Problema Suplementario 4.6 (página 442) del libro
 * 
 * @author imac28
 */
public class ejemplo4_6 {
    public static void main(String[] args) {
        // Crear un arreglo para almacenar 100 elementos
        BigInteger[] fibonacci = new BigInteger[100];

        // Inicializar los dos primeros valores de la secuencia
        fibonacci[0] = BigInteger.ZERO; // 0
        fibonacci[1] = BigInteger.ONE; // 1

        // Bucle for desde i=2 hasta 99
        for (int i = 2; i < 100; i++) {
            // Calcular sumando los dos anteriores
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        // Bucle for para imprimir el arreglo completo
        System.out.println("Los primeros 100 números de Fibonacci:\n");

        for (int i = 0; i < 100; i++) {
            System.out.println("F[" + i + "] = " + fibonacci[i]);
        }

        System.out.println("\n¡El número F(99) tiene " +
                fibonacci[99].toString().length() + " dígitos!");
    }
}