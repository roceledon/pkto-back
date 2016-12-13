package cl.pkto.core.persistence.dao;

import cl.pkto.common.ms.domain.Authority;
import cl.pkto.core.persistence.dao.base.BaseDao;
import cl.pkto.core.persistence.mapper.AuthorityMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bennu on 06-12-2016.
 */
@Component
public class AuthorityDao extends BaseDao implements AuthorityMapper {
    private SqlSession session;

    @Override
    public List<Authority> getAll() {
        List<Authority> authority = null;
        session = openSession();

        try {
            authority = session.selectList("getAllAuthority");
        } finally {
            session.close();
        }

        return authority;
    }

    @Override
    public Authority getById(Long id) {
        Authority authority = null;
        session = openSession();

        try {
            authority = session.selectOne("getAuthorityById", id);
        } finally {
            session.close();
        }

        return authority;
    }

    @Override
    public Authority save(Authority authority) {
        session = openSession();

        try {
            session.insert("saveAuthority", authority);
        } finally {
            session.commit();
            session.close();
        }

        return authority;
    }

    @Override
    public void update(Authority obj) {
        session = openSession();

        try {
            session.update("updateAuthority", obj);
        } finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        session = openSession();

        try {
            session.delete("deleteAuthority", id);
        } finally {
            session.commit();
            session.close();
        }
    }

    public List<Authority> findByUserId(Long id){
        List<Authority> authority = null;
        session = openSession();

        try {
            authority = session.selectList("findAuthoritysByUserId",id);
        } finally {
            session.close();
        }

        return authority;
    }
}
