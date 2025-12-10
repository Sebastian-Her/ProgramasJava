package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS1_9Test {

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
    public void testCalculoRadio1() {
        // Radio = 1
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS1_9.main(null);
        String output = normalize(outContent.toString());

        // Area = 4 * PI * 1^2 = 12.566...
        // Volumen = (4/3) * PI * 1^3 = 4.188...
        assertTrue(output.contains("Área de la esfera: 12.566"));
        assertTrue(output.contains("Volumen de la esfera: 4.188"));
    }

    @Test
    public void testCalculoRadio10() {
        // Radio = 10
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS1_9.main(null);
        String output = normalize(outContent.toString());

        // Area = 4 * PI * 10^2 = 1256.6...
        // Volumen = (4/3) * PI * 10^3 = 4188.7...
        assertTrue(output.contains("Área de la esfera: 1256.6"));
        assertTrue(output.contains("Volumen de la esfera: 4188.7"));
    }
}