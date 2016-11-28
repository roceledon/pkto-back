package cl.pkto.persistence.factory;

import cl.pkto.persistence.dao.UserDao;
import cl.pkto.persistence.iface.IUserDao;

/**
 * Created by Bennu on 27-11-2016.
 */
public class AppFactory {
    public static IUserDao getUserDao() {
        return new UserDao();
    }
}
