package cl.pkto.core.security.service;

import cl.pkto.core.security.dto.JwtUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Bennu on 05-12-2016.
 */
public interface CustomUserDetailsService extends UserDetailsService {
    JwtUser loadUserByUsername(String var1) throws UsernameNotFoundException;
}
