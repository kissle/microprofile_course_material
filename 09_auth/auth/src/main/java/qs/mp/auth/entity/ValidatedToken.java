package qs.mp.auth.entity;

import jakarta.ws.rs.core.SecurityContext;
import lombok.Getter;
import lombok.Setter;

import java.security.Principal;

@Getter
@Setter
public class ValidatedToken implements SecurityContext {

    private String token;
    private LoginInfo loginInfo;

    public ValidatedToken(String token, LoginInfo loginInfo) {
        this.token = token;
        this.loginInfo = loginInfo;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.getLoginInfo();
    }

    @Override
    public boolean isUserInRole(String s) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}
