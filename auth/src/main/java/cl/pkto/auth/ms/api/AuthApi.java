package cl.pkto.auth.ms.api;

import cl.pkto.common.ms.dto.JwtAuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bennu on 30-11-2016.
 */
@RequestMapping("${api.version.url}")
public interface AuthApi {
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException;

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request);
}