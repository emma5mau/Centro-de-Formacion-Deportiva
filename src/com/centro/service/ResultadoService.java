package com.centro.service;

import com.centro.model.Competencia;
import com.centro.model.Deportista;
import com.centro.model.Resultado;
import com.centro.repository.ResultadoRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ResultadoService {

    private final ResultadoRepository repository = new ResultadoRepository();

    /**
     * Registra el resultado de un deportista en una competencia.
     * Valida que el deportista esté inscrito en la disciplina de esa competencia.
     */
    public Optional<Resultado> registrar(Deportista deportista, Competencia competencia, int posicion, String marca) {
        if (!deportista.estaInscritoEn(competencia.getDisciplina())) {
            return Optional.empty();
        }
        Resultado resultado = new Resultado(deportista, competencia, posicion, marca);
        return Optional.of(repository.registrar(resultado));
    }

    public ArrayList<Resultado> listar() {
        return repository.listarTodos();
    }

    public Optional<Resultado> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizar(Resultado resultado) {
        return repository.actualizar(resultado);
    }
}
