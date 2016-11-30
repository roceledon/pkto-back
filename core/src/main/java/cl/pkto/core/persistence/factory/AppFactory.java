package cl.pkto.core.persistence.factory;

import cl.pkto.core.persistence.dao.UserDao;

/**
 * Created by Bennu on 27-11-2016.
 */
public class AppFactory {
    public static UserDao getUserDao() {
        return new UserDao();
    }
}
