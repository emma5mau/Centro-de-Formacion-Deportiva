package com.centro.model;

public class Resultado implements Identifiable {

    private int id;
    private Deportista deportista;
    private Competencia competencia;
    private int posicion;
    private String marca; // ej: "10.23 seg", "5.60 m", "200 pts"

    public Resultado(Deportista deportista, Competencia competencia, int posicion, String marca) {
        this.deportista = deportista;
        this.competencia = competencia;
        this.posicion = posicion;
        this.marca = marca;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + deportista.getNombreCompleto() + " - " + competencia.getNombre()
                + " -> Posición: " + posicion + ", Marca: " + marca;
    }
}