package com.centro.service;

import com.centro.model.Disciplina;
import com.centro.model.Entrenador;
import com.centro.model.Entrenamiento;
import com.centro.repository.EntrenamientoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class EntrenamientoService {

    private final EntrenamientoRepository repository = new EntrenamientoRepository();

    public Entrenamiento programar(Disciplina disciplina, Entrenador entrenador,
                                   LocalDate fecha, LocalTime hora, String lugar) {
        Entrenamiento entrenamiento = new Entrenamiento(disciplina, entrenador, fecha, hora, lugar);
        return repository.registrar(entrenamiento);
    }

    public ArrayList<Entrenamiento> listar() {
        return repository.listarTodos();
    }

    public Optional<Entrenamiento> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Entrenamiento entrenamiento) {
        return repository.actualizar(entrenamiento);
    }
}