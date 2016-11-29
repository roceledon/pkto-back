package cl.pkto.core.persistence.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

/**
 * Created by Bennu on 29-11-2016.
 */
public class MyBatisConnectionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    private static MyBatisConnectionFactory instance = new MyBatisConnectionFactory();

    public static MyBatisConnectionFactory getInstance() {
        return instance;
    }

    private MyBatisConnectionFactory(){
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatisConfig");
            String env = resourceBundle.getString("mybatis.env").trim();
            String resource = resourceBundle.getString("mybatis.file").trim();
            Reader reader = Resources.getResourceAsReader(resource);

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,env);
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}