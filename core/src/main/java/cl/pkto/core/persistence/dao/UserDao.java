package cl.pkto.core.persistence.dao;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.persistence.dao.base.BaseDao;
import cl.pkto.core.persistence.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bennu on 28-11-2016.
 */
@Component
public class UserDao extends BaseDao implements UserMapper {
    private SqlSession session = null;

    @Override
    public List<User> getAll() {
        List<User> list = null;
        session = openSession();

        try {
            list = session.selectList("getAllUser");
        } finally {
            session.close();
        }

        return list;
    }

    @Override
    public User getById(Long id) {
        User user = null;
        session = openSession();

        try {
            user = session.selectOne("getUserById",id);
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User save(User user) {
        session = openSession();

        try {
            session.insert("saveUser", user);
        } finally {
            session.commit();
            session.close();
        }

        return user;
    }

    @Override
    public void update(User user) {
        session = openSession();
        try {
            session.update("updateUser", user);
        } finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        session = openSession();
        try {
            session.delete("deleteUser",id);
        } finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public User findUserLoginByEmail(String email) {
        User account = null;

        session = openSession();
        try {
            account = session.selectOne("findUserByEmail",email);
        } finally {
            session.commit();
            session.close();
        }

        return account;
    }
}