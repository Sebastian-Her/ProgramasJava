package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ejemplo5_4_Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private String normalize(String s) {
        return s.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Test
    public void testMostrarEmpleados() {
        // No hay entrada
        Ejemplo5_4.main(null);
        String output = normalize(outContent.toString());

        // Verificar Empleado 1
        assertTrue(output.contains("Datos del empleado 1:"));
        assertTrue(output.contains("Nombre: Juan Pérez"));
        assertTrue(output.contains("Departamento: Ventas"));
        assertTrue(output.contains("Sueldo: 2500.5"));

        // Verificar Empleado 2
        assertTrue(output.contains("Datos del empleado 2:"));
        assertTrue(output.contains("Nombre: María López"));
        assertTrue(output.contains("Departamento: Recursos Humanos"));
        assertTrue(output.contains("Sueldo: 3000.75"));
    }
}