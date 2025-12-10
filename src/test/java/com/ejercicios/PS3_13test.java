package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS3_13test {

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
    public void testConteoRangos() {
        // 2 en R1, 1 en R2, 1 en R3, 3 en R4
        String input = "2.5\n9.0\n8.1\n4.5\n7.9\n10.0\n0.0\n-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS3_13.main(null);
        String output = normalize(outContent.toString());

        assertTrue(output.contains("rango 0...3.99: 2"));
        assertTrue(output.contains("rango 4...5.99: 1"));
        assertTrue(output.contains("rango 6...7.99: 1"));
        assertTrue(output.contains("rango 8...10: 3"));
    }
}