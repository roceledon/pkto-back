package cl.pkto.core.persistence.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Bennu on 29-11-2016.
 */
public class MyBatisConnectionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    @Value("${myBatis.env}")
    private static String env;

    static {
        try {
            String resource = "mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,env);
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
