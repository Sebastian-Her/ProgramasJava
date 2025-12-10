package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ejemplo4_6test {

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
    public void testGeneracionFibonacci() {
        // No hay entrada
        ejemplo4_6.main(null);
        String output = normalize(outContent.toString());

        // Verificar valores iniciales
        assertTrue(output.contains("F[0] = 0"));
        assertTrue(output.contains("F[1] = 1"));
        assertTrue(output.contains("F[2] = 1"));

        // Verificar un valor más adelante
        assertTrue(output.contains("F[7] = 13"));

        // Verificar la línea final
        assertTrue(output.contains("¡El número F(99) tiene 21 dígitos!"));
    }
}