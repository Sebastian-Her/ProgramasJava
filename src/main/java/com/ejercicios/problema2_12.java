package com.ejercicios;

import java.util.Scanner;

/**
 * Programa que calcula el pago total a un trabajador
 * Implementa reglas de negocio para pago de horas extras según categoría
 * Basado en el Problema 2.12 del libro
 */
public class problema2_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repetir = true;

        while (repetir) {
            // Variables
            double sueldo, pagoHoraExtra, montoTotal;
            int categoria, horasExtras, horasPagadas;

            // Entrada de datos
            System.out.println("=== CÁLCULO DE PAGO TOTAL ===\n");

            System.out.print("Ingrese el sueldo base del trabajador: $");
            sueldo = sc.nextDouble();

            System.out.print("Ingrese la categoría del trabajador (1-4): ");
            categoria = sc.nextInt();

            System.out.print("Ingrese las horas extras trabajadas: ");
            horasExtras = sc.nextInt();

            // Determinar pago por hora extra según categoría
            if (categoria == 1) {
                pagoHoraExtra = 30;
            } else if (categoria == 2) {
                pagoHoraExtra = 38;
            } else if (categoria == 3) {
                pagoHoraExtra = 50;
            } else if (categoria == 4) {
                pagoHoraExtra = 70;
            } else {
                System.out.println("\nCategoría inválida. No se pagarán horas extras.");
                pagoHoraExtra = 0;
            }

            // Aplicar límite máximo de 30 horas extras pagables
            if (horasExtras > 30) {
                horasPagadas = 30;
                montoTotal = sueldo + (30 * pagoHoraExtra);
                System.out.println("\nNota: El trabajador tiene " + horasExtras +
                        " horas extras, pero solo se pagan máximo 30.");
            } else {
                horasPagadas = horasExtras;
                montoTotal = sueldo + (horasExtras * pagoHoraExtra);
            }

            // Mostrar resultados
            System.out.println("\n========== RESUMEN DE PAGO ==========");
            System.out.println("Sueldo base:              $" + sueldo);
            System.out.println("Categoría:                " + categoria);
            System.out.println("Pago por hora extra:      $" + pagoHoraExtra);
            System.out.println("Horas extras trabajadas:  " + horasExtras);
            System.out.println("Horas extras pagadas:     " + horasPagadas);
            System.out.println("Pago por horas extras:    $" + (horasPagadas * pagoHoraExtra));
            System.out.println("-------------------------------------");
            System.out.println("MONTO TOTAL A PAGAR:      $" + montoTotal);
            System.out.println("=====================================\n");

            System.out.print("¿Desea calcular otro pago? (S/N): ");
            String respuesta = sc.next();
            repetir = respuesta.equalsIgnoreCase("S");
            System.out.println();
        }

        sc.close();
        System.out.println("Programa finalizado. ¡Hasta pronto!");
    }
}