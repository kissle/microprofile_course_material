package qs.mp.auth.entity;

import lombok.Setter;

import javax.security.auth.Subject;
import java.security.Principal;

public class LoginInfo implements Principal {

    @Setter
    private String token;
    private MyUser user;

    public LoginInfo(MyUser user, String token) {
        this.user = user;
        this.token = token;
    }
    @Override
    public String getName() {
        return user.getUsername();
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

}
