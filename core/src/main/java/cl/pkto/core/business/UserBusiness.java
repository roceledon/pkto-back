package cl.pkto.core.business;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.persistence.factory.AppFactory;
import cl.pkto.core.persistence.mapper.UserMapper;

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
        UserMapper userDao = AppFactory.getUserDao();
        return userDao.getById(id);
    }

    public List<User> getUserAll() {
        UserMapper userDao = AppFactory.getUserDao();
        return userDao.getAll();
    }

    public Long saveUser(User user) {
        UserMapper userDao = AppFactory.getUserDao();
        return userDao.save(user);
    }

    public void updateUser(User user){
        UserMapper userDao = AppFactory.getUserDao();
        userDao.update(user);
    }

    public void deleteUser(Long id) {
        UserMapper userDao = AppFactory.getUserDao();
        userDao.delete(id);
    }
}
