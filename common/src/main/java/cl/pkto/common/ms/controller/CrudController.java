package cl.pkto.common.ms.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public abstract class CrudController<T> implements ICrud<T> {
    @Override
    public ResponseEntity<List<T>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<T> get(Long id) {
        return null;
    }

    @Override
    public void save(T type) {}

    @Override
    public void delete(Long id) {}

    @Override
    public ResponseEntity<List<T>> find(T type) {
        return null;
    }
}
