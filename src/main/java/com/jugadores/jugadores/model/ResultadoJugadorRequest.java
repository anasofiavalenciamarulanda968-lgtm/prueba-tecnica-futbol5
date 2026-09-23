package com.jugadores.jugadores.model;

public class ResultadoJugadorRequest {

    private String nombre;
    private double potenciaTiro;
    private double velocidad;
    private int pasesEfectivos;

    public ResultadoJugadorRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPotenciaTiro() {
        return potenciaTiro;
    }

    public void setPotenciaTiro(double potenciaTiro) {
        this.potenciaTiro = potenciaTiro;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getPasesEfectivos() {
        return pasesEfectivos;
    }

    public void setPasesEfectivos(int pasesEfectivos) {
        this.pasesEfectivos = pasesEfectivos;
    }
}