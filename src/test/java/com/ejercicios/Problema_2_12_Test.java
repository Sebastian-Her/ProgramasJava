package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Problema_2_12_Test {

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
    public void testCalculoCategoria2Menos30Horas() {
        // Sueldo 1000, Cat 2 ($38/h), 20 horas, No repetir
        String input = "1000\n2\n20\nN\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        problema2_12.main(null);
        String output = normalize(outContent.toString());

        // 1000 + (20 * 38) = 1000 + 760 = 1760.0
        assertTrue(output.contains("MONTO TOTAL A PAGAR:      $1760.0"));
    }

    @Test
    public void testCalculoCategoria4Mas30Horas() {
        // Sueldo 2000, Cat 4 ($70/h), 50 horas (tope 30), No repetir
        String input = "2000\n4\n50\nN\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        problema2_12.main(null);
        String output = normalize(outContent.toString());

        // 2000 + (30 * 70) = 2000 + 2100 = 4100.0
        assertTrue(output.contains("Nota: El trabajador tiene 50 horas extras, pero solo se pagan máximo 30."));
        assertTrue(output.contains("MONTO TOTAL A PAGAR:      $4100.0"));
    }

    @Test
    public void testCalculoCategoriaInvalida() {
        // Sueldo 1000, Cat 9 ($0/h), 10 horas, No repetir
        String input = "1000\n9\n10\nN\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        problema2_12.main(null);
        String output = normalize(outContent.toString());

        // 1000 + (10 * 0) = 1000.0
        assertTrue(output.contains("Categoría inválida. No se pagarán horas extras."));
        assertTrue(output.contains("MONTO TOTAL A PAGAR:      $1000.0"));
    }
}