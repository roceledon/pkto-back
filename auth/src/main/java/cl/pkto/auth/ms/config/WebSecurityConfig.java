package cl.pkto.auth.ms.config;

import cl.pkto.core.security.config.WebSecurityConfigGlobal;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.ResourceBundle;

/**
 * Created by Bennu on 05-12-2016.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigGlobal{
    public WebSecurityConfig() {
        String path;

        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        path = resourceBundle.getString("api.version.url").trim();
        path += "/";
        path += resourceBundle.getString("jwt.route.authentication.path").trim();

        setExclusion(path);
    }
}
