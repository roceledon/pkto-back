package cl.pkto.persistence.iface.base;

import cl.pkto.common.ms.domain.base.BaseDomain;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public interface IBaseDao<T extends BaseDomain> {

    List<T> getAll();

    T getById(String id);

    T getByName(String name);

    void save(T rol);

    void delete(String id);

    List<T> find(T type);
}