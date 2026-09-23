package com.jugadores.jugadores.model;

import java.util.List;

public class Entrenamiento {

    private int numeroEntrenamiento;
    private List<ResultadoJugadorRequest> resultados;

    public Entrenamiento() {
    }

    public Entrenamiento(int numeroEntrenamiento, List<ResultadoJugadorRequest> resultados) {
        this.numeroEntrenamiento = numeroEntrenamiento;
        this.resultados = resultados;
    }

    public int getNumeroEntrenamiento() {
        return numeroEntrenamiento;
    }

    public List<ResultadoJugadorRequest> getResultados() {
        return resultados;
    }

    public void setNumeroEntrenamiento(int numeroEntrenamiento) {
        this.numeroEntrenamiento = numeroEntrenamiento;
    }

    public void setResultados(List<ResultadoJugadorRequest> resultados) {
        this.resultados = resultados;
    }
}