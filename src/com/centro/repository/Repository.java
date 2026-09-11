package com.centro.repository;

import com.centro.model.Identifiable;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Repository<T extends Identifiable> {

    protected ArrayList<T> items = new ArrayList<>();
    private int nextId = 1;

    public T registrar(T item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    public ArrayList<T> listarTodos() {
        return new ArrayList<>(items);
    }

    public Optional<T> buscarPorId(int id) {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }

    public boolean eliminar(int id) {
        return items.removeIf(i -> i.getId() == id);
    }

    public boolean actualizar(T itemActualizado) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemActualizado.getId()) {
                items.set(i, itemActualizado);
                return true;
            }
        }
        return false;
    }

    public int cantidad() {
        return items.size();
    }
}
