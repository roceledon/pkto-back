package cl.pkto.core.business;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.persistence.dao.UserDao;
import cl.pkto.core.persistence.factory.AppFactory;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class UserBusiness {
    private static UserBusiness instance = new UserBusiness();

    public static UserBusiness getInstance() {
        return instance;
    }

    //user method
    public User getUserById(Long id) {
        UserDao userDao = AppFactory.getUserDao();
        return userDao.getById(id);
    }

    public List<User> getUserAll() {
        UserDao userDao = AppFactory.getUserDao();
        return userDao.getAll();
    }

    public Long saveUser(User user) {
        UserDao userDao = AppFactory.getUserDao();
        return userDao.save(user);
    }

    public void updateUser(User user){
        UserDao userDao = AppFactory.getUserDao();
        userDao.update(user);
    }

    public void deleteUser(Long id) {
        UserDao userDao = AppFactory.getUserDao();
        userDao.delete(id);
    }
}
