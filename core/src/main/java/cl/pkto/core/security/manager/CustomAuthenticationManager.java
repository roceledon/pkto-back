package cl.pkto.core.security.manager;

import cl.pkto.common.ms.domain.Authority;
import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.AuthorityBusiness;
import cl.pkto.core.business.UserBusiness;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bennu on 05-12-2016.
 */
public class CustomAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserBusiness userBusiness = UserBusiness.getInstance();

        User user = userBusiness.findByEmail(email);

        if (user == null) {
            throw new BadCredentialsException("1000");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }

        List<Authority> authority = AuthorityBusiness.getInstance().findByUserId(user.getId());
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        for(Authority auth : authority){
            grantedAuths.add(new SimpleGrantedAuthority(auth.getName()));
        }

        return new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
    }
}
