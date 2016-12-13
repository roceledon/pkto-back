package cl.pkto.core.business;

import cl.pkto.common.ms.domain.Authority;
import cl.pkto.core.business.base.BaseBusiness;
import cl.pkto.core.persistence.dao.AuthorityDao;
import cl.pkto.core.persistence.factory.AppFactory;

import java.util.List;

/**
 * Created by Bennu on 06-12-2016.
 */
public class AuthorityBusiness implements BaseBusiness<Authority> {
    private static AuthorityBusiness instance = new AuthorityBusiness();

    private static final AuthorityDao authorityDao = AppFactory.getAuthorityDao();

    public static AuthorityBusiness getInstance() {
        return instance;
    }

    public List<Authority> findByUserId(Long id){
        return authorityDao.findByUserId(id);
    }


    @Override
    public Authority getById(Long id) {
        return null;
    }

    @Override
    public List<Authority> getAll() {
        return null;
    }

    @Override
    public Authority save(Authority authority) {
        return null;
    }

    @Override
    public void update(Authority authority) {

    }

    @Override
    public void delete(Long id) {

    }
}
