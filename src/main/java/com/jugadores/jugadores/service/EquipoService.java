package com.jugadores.jugadores.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jugadores.jugadores.model.Entrenamiento;
import com.jugadores.jugadores.model.Jugador;
import com.jugadores.jugadores.model.ResultadoJugadorRequest;
import com.jugadores.jugadores.model.Resultadojugador;
import com.jugadores.jugadores.model.TitularResponse;

@Service
public class EquipoService {

    private final Map<Integer, List<Resultadojugador>> entrenamientos;

    public EquipoService() {
        entrenamientos = new HashMap<>();
    }

    public void guardarEntrenamiento(Entrenamiento entrenamiento) {

        List<Resultadojugador> resultados = new ArrayList<>();

        for (ResultadoJugadorRequest request : entrenamiento.getResultados()) {

            Jugador jugador = new Jugador(request.getNombre());

            double puntaje = calcularResultado(
                    request.getPotenciaTiro(),
                    request.getVelocidad(),
                    request.getPasesEfectivos()
            );

            Resultadojugador resultado = new Resultadojugador(
                    jugador,
                    request.getPotenciaTiro(),
                    request.getVelocidad(),
                    request.getPasesEfectivos(),
                    puntaje
            );

            resultados.add(resultado);
        }

        entrenamientos.put(
                entrenamiento.getNumeroEntrenamiento(),
                resultados
        );
    }

    public double calcularResultado(
            double potenciaTiro,
            double velocidad,
            int pasesEfectivos) {

        return (potenciaTiro * 0.20)
                + (velocidad * 0.30)
                + (pasesEfectivos * 0.50);
    }

    public boolean tieneTresEntrenamientos() {
        return entrenamientos.size() == 3;
    }

    public List<Resultadojugador> obtenerResultados() {

        List<Resultadojugador> resultados = new ArrayList<>();

        for (List<Resultadojugador> entrenamiento : entrenamientos.values()) {
            resultados.addAll(entrenamiento);
        }

        return resultados;
    }

    public List<TitularResponse> obtenerTitulares() {

        Map<String, List<Double>> puntajesPorJugador = new HashMap<>();

        for (List<Resultadojugador> entrenamiento : entrenamientos.values()) {

            for (Resultadojugador resultado : entrenamiento) {

                String nombre = resultado.getJugador().getNombre();

                puntajesPorJugador
                        .computeIfAbsent(nombre, key -> new ArrayList<>())
                        .add(resultado.getResultado());
            }
        }

        List<TitularResponse> titulares = new ArrayList<>();

        for (Map.Entry<String, List<Double>> entry : puntajesPorJugador.entrySet()) {

            double promedio = entry.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);

            titulares.add(
                    new TitularResponse(
                            entry.getKey(),
                            promedio
                    )
            );
        }

        titulares.sort(
                Comparator.comparing(TitularResponse::getResultado)
                        .reversed()
        );

        return titulares.stream()
                .limit(5)
                .toList();
    }
}