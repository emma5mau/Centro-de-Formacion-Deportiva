package com.centro.service;

import com.centro.model.Disciplina;
import com.centro.repository.DisciplinaRepository;

import java.util.ArrayList;
import java.util.Optional;

public class DisciplinaService {

    private final DisciplinaRepository repository = new DisciplinaRepository();

    public Disciplina registrar(String nombre, String descripcion) {
        Disciplina disciplina = new Disciplina(nombre, descripcion);
        return repository.registrar(disciplina);
    }

    public ArrayList<Disciplina> listar() {
        return repository.listarTodos();
    }

    public Optional<Disciplina> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Disciplina disciplina) {
        return repository.actualizar(disciplina);
    }
}
