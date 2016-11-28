package cl.pkto.core.persistence.factory;

import cl.pkto.core.persistence.dao.UserDao;
import cl.pkto.core.persistence.mapper.UserMapper;

/**
 * Created by Bennu on 27-11-2016.
 */
public class AppFactory {
    public static UserMapper getUserDao() {
        return new UserDao();
    }
}
