package cl.pkto.core.persistence.mapper.base;

import java.util.List;

/**
 * Created by Bennu on 28-11-2016.
 */
public interface BaseMapper<T> {
    List<T> getAll();

    T getById(Long id);

    Long save(T obj);

    void update(T obj);

    void delete(Long id);
}
