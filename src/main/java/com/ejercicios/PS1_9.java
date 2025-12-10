package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que calcula el área y volumen de una esfera
 * Basado en el Problema Suplementario 1.9 (página 404)
 * 
 * @author imac22
 */
public class PS1_9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio de la esfera: ");
        double radio = sc.nextDouble();

        // Calcular área usando Fórmula 6.7
        double area = 4 * Math.PI * Math.pow(radio, 2);

        // Calcular volumen usando Fórmula 6.8
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);

        System.out.println("Área de la esfera: " + area);
        System.out.println("Volumen de la esfera: " + volumen);

        sc.close();
    }
}