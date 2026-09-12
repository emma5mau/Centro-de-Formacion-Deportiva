package com.centro.service;

import com.centro.model.Competencia;
import com.centro.model.Disciplina;
import com.centro.repository.CompetenciaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class CompetenciaService {

    private final CompetenciaRepository repository = new CompetenciaRepository();

    public Competencia registrar(String nombre, LocalDate fecha, String lugar, Disciplina disciplina) {
        Competencia competencia = new Competencia(nombre, fecha, lugar, disciplina);
        return repository.registrar(competencia);
    }

    public ArrayList<Competencia> listar() {
        return repository.listarTodos();
    }

    public Optional<Competencia> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Competencia competencia) {
        return repository.actualizar(competencia);
    }
}
