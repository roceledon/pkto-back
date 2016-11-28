package cl.pkto.core.persistence.dao;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.persistence.mapper.UserMapper;

import java.util.List;

/**
 * Created by Bennu on 28-11-2016.
 */
public class UserDao implements UserMapper {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Long save(User obj) {
        return null;
    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(Long id) {

    }
}
