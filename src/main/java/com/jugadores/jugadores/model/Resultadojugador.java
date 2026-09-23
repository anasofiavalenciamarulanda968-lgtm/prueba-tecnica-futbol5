package com.jugadores.jugadores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Resultadojugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    private Jugador jugador; 


    private double potenciaTiro;
    private double velocidad;
    private int pasesEfectivos;
    private Double resultado;

    public Resultadojugador() {
    }

    public Resultadojugador(Jugador jugador, double potenciaTiro, double velocidad,
                            int pasesEfectivos, double resultado) {
        this.jugador = jugador;
        this.potenciaTiro = potenciaTiro;
        this.velocidad = velocidad;
        this.pasesEfectivos = pasesEfectivos;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}