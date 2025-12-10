package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que registra y muestra información de un domicilio
 * Basado en el Ejemplo 5.3 del libro (Capítulo 5)
 * Adaptado a programación estructurada
 * 
 * @author ass
 */
public class Ejemplo5_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para almacenar los datos del domicilio
        String calle, ciudad, pais;
        int numero;

        // Solicitar y leer los datos del usuario
        System.out.print("Ingrese la calle: ");
        calle = scanner.nextLine();

        System.out.print("Ingrese el número: ");
        numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese la ciudad: ");
        ciudad = scanner.nextLine();

        System.out.print("Ingrese el país: ");
        pais = scanner.nextLine();

        // Imprimir los datos almacenados
        System.out.println("\n--- DATOS DEL DOMICILIO ---");
        System.out.println("Calle: " + calle);
        System.out.println("Número: " + numero);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("País: " + pais);

        scanner.close();
    }
}