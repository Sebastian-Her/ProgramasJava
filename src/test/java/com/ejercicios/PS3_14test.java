package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS3_14test {

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
    public void testCalculoCapital() {
        // 2 meses, 1000 inicial, tasa 1 = 0.1 (10%), tasa 2 = 0.1 (10%)
        String input = "2\n1000\n0.1\n0.1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS3_14.main(null);
        String output = normalize(outContent.toString());

        // Mes 1: 1000 + (1000 * 0.1) = 1100
        // Mes 2: 1100 + (1100 * 0.1) = 1100 + 110 = 1210.0
        assertTrue(output.contains("El monto final de la inversión es: 1210.0"));
    }
}