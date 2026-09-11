package com.centro.service;

import com.centro.model.Deportista;
import com.centro.model.Disciplina;
import com.centro.repository.DeportistaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class DeportistaService {

    private final DeportistaRepository repository = new DeportistaRepository();

    public Deportista registrar(String nombre, String apellido, LocalDate fechaNacimiento) {
        Deportista deportista = new Deportista(nombre, apellido, fechaNacimiento);
        return repository.registrar(deportista);
    }

    public ArrayList<Deportista> listar() {
        return repository.listarTodos();
    }

    public Optional<Deportista> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Deportista deportista) {
        return repository.actualizar(deportista);
    }

    /**
     * Inscribe a un deportista en una disciplina.
     * Devuelve false si el deportista no existe o ya estaba inscrito.
     */
    public boolean inscribirEnDisciplina(int idDeportista, Disciplina disciplina) {
        Optional<Deportista> deportistaOpt = repository.buscarPorId(idDeportista);
        if (deportistaOpt.isEmpty()) {
            return false;
        }
        return deportistaOpt.get().inscribirEnDisciplina(disciplina);
    }
}
