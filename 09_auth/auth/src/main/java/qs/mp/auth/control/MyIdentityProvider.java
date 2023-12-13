package qs.mp.auth.control;

import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;
import qs.mp.auth.AuthRole;
import qs.mp.auth.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyIdentityProvider implements IdentityProvider<XAuthTokenRequest> {
    @Override
    public Class<XAuthTokenRequest> getRequestType() {
        return null;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(XAuthTokenRequest request, AuthenticationRequestContext authenticationRequestContext) {
        final String token = request.getToken();

        final ValidatedToken[] validatedTokens = new ValidatedToken[]{null};

        // E.g. Request UserRights from different service
        // Mocking Example here.
        List<UserRights> userRights = new ArrayList<>();
        userRights.add(new UserRights(List.of("read", "write")));

        return Uni.createFrom().optional(Optional.of(this.buildIdentity(userRights, validatedTokens[0], token)));
    }

    protected SecurityIdentity buildIdentity(List<UserRights> userRights, ValidatedToken validatedToken, String token) {
        var builder = QuarkusSecurityIdentity.builder().setPrincipal(validatedToken.getUserPrincipal());

        List<String> roles = new ArrayList<>();
        for (UserRights right: userRights) {
            for (String scope : right.getScopes()) {
                builder.addRole(scope);
                roles.add(scope);
            }
        }

        validatedToken.getLoginInfo().setToken(token);
        return builder.build();
    }

    protected Uni<ValidatedToken> validateToken(String token) {
        // Custom Validation Logic
        // Possible Requests to Validation Services
        MyUser user = new MyUser(0, "Max Mustermann", List.of(AuthRole.ADMIN));
        return Uni.createFrom().optional(Optional.of(new ValidatedToken(token, new LoginInfo(user, token))));
    }
}
