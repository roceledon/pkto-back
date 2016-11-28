package cl.pkto.core.business;

import cl.pkto.common.ms.domain.User;
import cl.pkto.persistence.factory.AppFactory;
import cl.pkto.persistence.iface.IUserDao;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class PktoBusiness {
    private static PktoBusiness instance = new PktoBusiness();

    public static PktoBusiness getInstance() {
        return instance;
    }

    //user method
    public List<User> getUserAll() {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getAll();
    }

    public void saveUser(User user) {
        IUserDao userDao = AppFactory.getUserDao();
        userDao.save(user);
    }

    public void deleteUser(String id) {
        IUserDao userDao = AppFactory.getUserDao();
        userDao.delete(id);
    }

    public User getUserById(String id) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getById(id);
    }

    public User getUserByName(String name) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getByName(name);
    }

    public List<User> findUser(User user) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.find(user);
    }

}
