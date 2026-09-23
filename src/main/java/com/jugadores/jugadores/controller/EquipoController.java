package com.jugadores.jugadores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jugadores.jugadores.model.Entrenamiento;
import com.jugadores.jugadores.model.TitularResponse;
import com.jugadores.jugadores.service.EquipoService;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping("/entrenamiento")
    public String guardarEntrenamiento(
            @RequestBody Entrenamiento entrenamiento) {

        equipoService.guardarEntrenamiento(entrenamiento);

        return "Entrenamiento guardado correctamente";
    }

    @GetMapping("/titulares")
    public Object obtenerTitulares() {

        if (!equipoService.tieneTresEntrenamientos()) {
            return "Información insuficiente: se necesitan los 3 entrenamientos de la semana.";
        }

        List<TitularResponse> titulares = equipoService.obtenerTitulares();

        return titulares;
    }
}