package com.jugadores.jugadores.model;

public class TitularResponse {

    private String nombre;
    private double resultado;

    public TitularResponse() {
    }

    public TitularResponse(String nombre, double resultado) {
        this.nombre = nombre;
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}