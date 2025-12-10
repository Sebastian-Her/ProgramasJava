package com.javatutor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class AppTest {

    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testCategoria1() {
        // Categoría 1 (15%), Sueldo 1000 -> Aumento 150, Nuevo 1150
        provideInput("1\n1000");
        App.main(new String[] {});

        String output = outputStreamCaptor.toString();

        // Validamos cálculos clave
        assertTrue(output.contains("150.0") || output.contains("150,0"),
                "El cálculo del aumento para Cat 1 es incorrecto (debería ser 150.0)");
        assertTrue(output.contains("1150.0") || output.contains("1150,0"),
                "El cálculo del nuevo sueldo para Cat 1 es incorrecto (debería ser 1150.0)");
    }

    @Test
    void testCategoria2() {
        // Categoría 2 (10%), Sueldo 2000 -> Aumento 200, Nuevo 2200
        provideInput("2\n2000");
        App.main(new String[] {});

        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("200.0") || output.contains("200,0"),
                "El cálculo del aumento para Cat 2 es incorrecto");
        assertTrue(output.contains("2200.0") || output.contains("2200,0"), "El nuevo sueldo para Cat 2 es incorrecto");
    }

    @Test
    void testCategoria3() {
        // Categoría 3 (8%), Sueldo 1000 -> Aumento 80, Nuevo 1080
        provideInput("3\n1000");
        App.main(new String[] {});

        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("80.0") || output.contains("80,0"),
                "El cálculo del aumento para Cat 3 es incorrecto");
        assertTrue(output.contains("1080.0") || output.contains("1080,0"), "El nuevo sueldo para Cat 3 es incorrecto");
    }

    @Test
    void testCategoria4() {
        // Categoría 4 (7%), Sueldo 1000 -> Aumento 70, Nuevo 1070
        provideInput("4\n1000");
        App.main(new String[] {});

        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("70.0") || output.contains("70,0"),
                "El cálculo del aumento para Cat 4 es incorrecto");
        assertTrue(output.contains("1070.0") || output.contains("1070,0"), "El nuevo sueldo para Cat 4 es incorrecto");
    }

    @Test
    void testCategoriaInvalida() {
        provideInput("5\n1000");
        App.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.toLowerCase().contains("inválida") || output.contains("invalida"),
                "Debe mostrar mensaje de categoría inválida");
    }
}