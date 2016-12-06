package cl.pkto.core.security.config;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.UserBusiness;
import cl.pkto.core.security.dto.JwtUser;
import cl.pkto.core.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Bennu on 03-12-2016.
 */
@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public CustomUserDetailsService userDetailsService() {
        return email -> {
            User user = UserBusiness.getInstance().findUserLoginByEmail(email);
            if(user != null) {
                return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"), user.getEnabled(), user.getLastPasswordResetDate());
            } else {
                throw new UsernameNotFoundException("could not find the user whit email'" + email + "'");
            }
        };
    }
}
