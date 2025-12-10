package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class problema3_9test {

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
    public void testSumaSerieN3() {
        // N = 3
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        problema3_9.main(null);
        String output = normalize(outContent.toString());

        // 1^1 + 2^2 + 3^3 = 1 + 4 + 27 = 32.0
        assertTrue(output.contains("La suma de la serie es: 32.0"));
    }

    @Test
    public void testSumaSerieNInvalido() {
        // N = 0
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        problema3_9.main(null);
        String output = normalize(outContent.toString());

        assertTrue(output.contains("Error: El número debe ser positivo."));
    }
}