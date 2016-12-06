package cl.pkto.auth.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bennu on 30-11-2016.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class AuthMS {
    final static Logger logger = LoggerFactory.getLogger(AuthMS.class);

    public static void main(String[] args) {
            SpringApplication.run(AuthMS.class, args);
    }
}
