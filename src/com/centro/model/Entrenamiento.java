package com.centro.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrenamiento implements Identifiable {

    private int id;
    private Disciplina disciplina;
    private Entrenador entrenador;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;

    public Entrenamiento(Disciplina disciplina, Entrenador entrenador, LocalDate fecha, LocalTime hora, String lugar) {
        this.disciplina = disciplina;
        this.entrenador = entrenador;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + disciplina.getNombre() + " - " + fecha + " " + hora
                + " en " + lugar + " (Entrenador: " + entrenador.getNombreCompleto() + ")";
    }
}