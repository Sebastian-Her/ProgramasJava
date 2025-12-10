package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS4_14test {

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
    public void testBisiestosYPerfectos() {
        PS4_14.main(null);
        String output = normalize(outContent.toString());

        // Verificar bisiestos
        assertTrue(output.contains("Años bisiestos:"));
        assertTrue(output.contains(" 2000 ")); // Divisible por 400
        assertTrue(output.contains(" 2004 ")); // Divisible por 4
        assertTrue(output.contains(" 2020 ")); // Ultimo
        assertFalse(output.contains(" 1900 ")); // Divisible por 100 pero no 400

        // Verificar perfectos
        assertTrue(output.contains("Años perfectos:"));
        assertTrue(output.contains(" 6 "));
        assertTrue(output.contains(" 28 "));
        assertTrue(output.contains(" 496 "));
    }
}