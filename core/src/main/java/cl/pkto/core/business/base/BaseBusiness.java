package cl.pkto.core.business.base;

import java.util.List;

/**
 * Created by Bennu on 06-12-2016.
 */
public interface BaseBusiness<T> {

    T getById(Long id);

    List<T> getAll();

    T save(T t);

    void update(T t);

    void delete(Long id);
}
