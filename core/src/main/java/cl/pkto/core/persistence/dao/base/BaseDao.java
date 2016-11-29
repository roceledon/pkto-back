package cl.pkto.core.persistence.dao.base;

import cl.pkto.core.persistence.factory.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Bennu on 29-11-2016.
 */
public class BaseDao {
    private static final SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

    protected static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
