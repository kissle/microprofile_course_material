package qs.mp.auth;

import jakarta.ws.rs.core.SecurityContext;
import lombok.NoArgsConstructor;
import qs.mp.auth.entity.LoginInfo;
import qs.mp.auth.entity.MyUser;
import qs.mp.auth.entity.ValidatedToken;

import java.util.List;

@NoArgsConstructor
public class AuthRole {

    public static final String AUTH_TOKEN = "X-Auth-Token";

    public static final String ADMIN = "resource.employee.admin";

    public static SecurityContext getInternalSecurityContext() {
        final int internalUserId = 0;
        final String internalUserToken = "INTERNAL_USER";
        final String internalUserName = "INTERNAL_USER";

        return new ValidatedToken(internalUserToken,
                new LoginInfo(new MyUser(internalUserId,
                        internalUserName,
                        List.of()), internalUserToken));
    }
}
