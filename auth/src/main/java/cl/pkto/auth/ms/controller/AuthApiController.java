package cl.pkto.auth.ms.controller;

import cl.pkto.auth.ms.api.AuthApi;
import cl.pkto.common.ms.dto.JwtAuthenticationRequest;
import cl.pkto.common.ms.dto.JwtAuthenticationResponse;
import cl.pkto.core.security.config.WebSecurityConfiguration;
import cl.pkto.core.security.manager.CustomAuthenticationManager;
import cl.pkto.core.security.util.JwtTokenUtil;
import cl.pkto.core.security.dto.JwtUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bennu on 30-11-2016.
 */
@CrossOrigin
@RestController
public class AuthApiController implements AuthApi {
    @Value("${jwt.header}")
    private String tokenHeader;
    private CustomAuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;

    public AuthApiController() {
        this.jwtTokenUtil = new JwtTokenUtil();
        this.userDetailsService = new WebSecurityConfiguration().userDetailsService();
        this.authenticationManager = new CustomAuthenticationManager();
    }

    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
