package com.centro.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deportista implements Identifiable {

    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private ArrayList<Disciplina> disciplinas;

    public Deportista(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.disciplinas = new ArrayList<>();
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    /**
     * Inscribe al deportista en una disciplina, evitando duplicados.
     */
    public boolean inscribirEnDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            return false;
        }
        disciplinas.add(disciplina);
        return true;
    }

    public boolean estaInscritoEn(Disciplina disciplina) {
        return disciplinas.contains(disciplina);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + getNombreCompleto() + " (Nacimiento: " + fechaNacimiento + ")";
    }
}
