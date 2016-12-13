package cl.pkto.core.business;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.base.BaseBusiness;
import cl.pkto.core.persistence.dao.UserDao;
import cl.pkto.core.persistence.factory.AppFactory;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class UserBusiness implements BaseBusiness<User> {
    private static UserBusiness instance = new UserBusiness();

    public static UserBusiness getInstance() {
        return instance;
    }

    private static final UserDao userDao = AppFactory.getUserDao();

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user){
        userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }
}
