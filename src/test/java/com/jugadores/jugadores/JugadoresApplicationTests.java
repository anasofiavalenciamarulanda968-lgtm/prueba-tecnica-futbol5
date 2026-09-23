package com.jugadores.jugadores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jugadores.jugadores.service.EquipoService;

class JugadoresApplicationTests {

    @Test
    void debeCalcularResultadoCorrectamente() {

        EquipoService equipoService = new EquipoService();

        double resultado = equipoService.calcularResultado(
                10,
                5,
                25
        );

        assertEquals(16.0, resultado, 0.001);
    }
}