package cl.pkto.common.ms.dto;

import java.io.Serializable;

/**
 * Created by Bennu on 03-12-2016.
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
