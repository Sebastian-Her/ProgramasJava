package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que calcula el monto final de una inversión con interés mensual
 * Basado en el Problema Suplementario 3.14 (página 422)
 * 
 * @author imac13
 */
public class PS3_14 {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.println("Ingrese el número de meses: ");
        int meses = dato.nextInt();

        System.out.println("Ingrese el capital inicial: ");
        double capIni = dato.nextDouble();

        double[] tasas = new double[meses];

        for (int i = 0; i < meses; i++) {
            System.out.println("Ingrese el interés mensual " + (i + 1) + ": ");
            tasas[i] = dato.nextDouble();
        }

        double montoFinal = calcularMonto(capIni, tasas);
        System.out.println("El monto final de la inversión es: " + montoFinal);

        dato.close();
    }

    // Método estático para calcular el monto final
    public static double calcularMonto(double capIni, double[] tasas) {
        double montoFinal = capIni;

        for (double tasa : tasas) {
            montoFinal += montoFinal * tasa;
        }

        return montoFinal;
    }
}