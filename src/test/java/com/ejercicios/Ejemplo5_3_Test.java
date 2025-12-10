package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ejemplo5_3_Test {

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
    public void testRegistroDomicilio() {
        String input = "Avenida Siempreviva 742\n742\nSpringfield\nMéxico\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo5_3.main(null);
        String output = normalize(outContent.toString());

        assertTrue(output.contains("Calle: Avenida Siempreviva 742"));
        assertTrue(output.contains("Número: 742"));
        assertTrue(output.contains("Ciudad: Springfield"));
        assertTrue(output.contains("País: México"));
    }
}