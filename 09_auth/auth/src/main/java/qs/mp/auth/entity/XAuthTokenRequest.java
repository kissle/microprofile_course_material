package qs.mp.auth.entity;

import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.security.identity.request.BaseAuthenticationRequest;
import lombok.Getter;

@Getter
public class XAuthTokenRequest extends BaseAuthenticationRequest {

    private final String token;


    public XAuthTokenRequest(String token) {
        this.token = token;
    }

}
