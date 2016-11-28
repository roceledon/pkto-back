package cl.pkto.user.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Bennu on 27-11-2016.
 */
@MapperScan("cl.pkto.core.mappers")
@SpringBootApplication
public class UserMS {
    public static void main(String[] args) {
        SpringApplication.run(UserMS.class, args);
    }
}
