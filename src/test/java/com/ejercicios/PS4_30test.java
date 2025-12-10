package com.ejercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PS4_30test {

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
    public void testReservaYAsientoOcupado() {
        // 1. Reservar A-1 para "Juan"
        // 2. No salir (n)
        // 3. Intentar reservar A-1 (debe fallar)
        // 4. Reservar B-2 para "Maria"
        // 5. Salir (s)
        String input = "A\n1\nJuan\nn\nA\n1\nB\n2\nMaria\ns\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS4_30.main(null);
        String output = normalize(outContent.toString());

        // Verificar la primera reserva exitosa
        assertTrue(output.contains("Reserva realizada con éxito."));

        // Verificar el intento de reservar asiento ocupado
        assertTrue(output.contains("El asiento seleccionado ya está reservado. Por favor, elija otro asiento."));

        // Verificar la segunda reserva (el texto "Reserva realizada" aparecerá dos
        // veces)
        int firstSuccess = output.indexOf("Reserva realizada con éxito.");
        int secondSuccess = output.indexOf("Reserva realizada con éxito.", firstSuccess + 1);
        assertTrue(secondSuccess > -1);
    }

    @Test
    public void testEntradaInvalida() {
        // 1. Intentar reservar Z-50 (fuera de rango)
        // 2. Salir (s)
        String input = "Z\n50\ns\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS4_30.main(null);
        String output = normalize(outContent.toString());

        assertTrue(output.contains("Opción no válida o fuera de rango. Por favor, intente nuevamente."));
    }
}