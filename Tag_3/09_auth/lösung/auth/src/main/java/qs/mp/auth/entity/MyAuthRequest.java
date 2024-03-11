package qs.mp.auth.entity;

import io.quarkus.security.identity.request.BaseAuthenticationRequest;
import lombok.Getter;

@Getter
public class MyAuthRequest extends BaseAuthenticationRequest {

    private final String token;

    public MyAuthRequest(String token) {
        this.token = token;
    }
}
