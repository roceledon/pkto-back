package cl.pkto.user.ms.config;

import cl.pkto.core.security.config.WebSecurityConfigGlobal;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by Bennu on 05-12-2016.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigGlobal{
}
