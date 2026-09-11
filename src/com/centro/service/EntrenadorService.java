package com.centro.service;

import com.centro.model.Entrenador;
import com.centro.repository.EntrenadorRepository;

import java.util.ArrayList;
import java.util.Optional;

public class EntrenadorService {

    private final EntrenadorRepository repository = new EntrenadorRepository();

    public Entrenador registrar(String nombre, String apellido, String especialidad) {
        Entrenador entrenador = new Entrenador(nombre, apellido, especialidad);
        return repository.registrar(entrenador);
    }

    public ArrayList<Entrenador> listar() {
        return repository.listarTodos();
    }

    public Optional<Entrenador> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Entrenador entrenador) {
        return repository.actualizar(entrenador);
    }
}
