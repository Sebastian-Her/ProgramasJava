package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS3_42test {

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
    public void testInvertirNumero() {
        String input = "12345\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS3_42.main(null);
        String output = normalize(outContent.toString());

        // k (ultimo digito) = 1
        // x (invertido) = 54321
        // n (final) = 0
        assertTrue(output.contains("k (último dígito procesado): 1"));
        assertTrue(output.contains("x (número invertido): 54321"));
        assertTrue(output.contains("n (valor final): 0"));
    }

    @Test
    public void testNumeroInvalido() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS3_42.main(null);
        String output = normalize(outContent.toString());

        assertTrue(output.contains("El número ingresado no es válido. Debe ser positivo."));
    }
}