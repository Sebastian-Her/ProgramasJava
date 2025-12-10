
package com.ejercicios;

/**
 * Programa que almacena y muestra información de empleados usando arreglos
 * Basado en el Ejemplo 5.4 del libro (página 345)
 * Adaptado a programación estructurada
 * 
 * @author zenri
 */
public class Ejemplo5_4 {
    public static void main(String[] args) {
        // Arreglos paralelos para almacenar datos de 2 empleados
        int[] numeros = { 1, 2 };
        String[] nombres = { "Juan Pérez", "María López" };
        String[] departamentos = { "Ventas", "Recursos Humanos" };
        int[] niveles = { 2, 3 };
        double[] sueldos = { 2500.50, 3000.75 };

        // Mostrar datos de ambos empleados usando función
        for (int i = 0; i < 2; i++) {
            mostrarEmpleado(i + 1, numeros[i], nombres[i], departamentos[i], niveles[i], sueldos[i]);
        }
    }

    // Método estático para mostrar los datos de un empleado
    static void mostrarEmpleado(int indice, int numero, String nombre,
            String departamento, int nivel, double sueldo) {
        System.out.println("Datos del empleado " + indice + ":");
        System.out.println("Número: " + numero);
        System.out.println("Nombre: " + nombre);
        System.out.println("Departamento: " + departamento);
        System.out.println("Nivel: " + nivel);
        System.out.println("Sueldo: " + sueldo);
        System.out.println();
    }
}