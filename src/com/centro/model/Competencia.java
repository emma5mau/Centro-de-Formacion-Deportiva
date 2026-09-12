package com.centro.model;

import java.time.LocalDate;

public class Competencia implements Identifiable {

    private int id;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private Disciplina disciplina;

    public Competencia(String nombre, LocalDate fecha, String lugar, Disciplina disciplina) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.disciplina = disciplina;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (" + disciplina.getNombre() + ") - " + fecha + " en " + lugar;
    }
}