package qs.mp.auth.control;

import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import qs.mp.auth.entity.MyAuthRequest;

@ApplicationScoped
public class MyIdentityProvider implements IdentityProvider<MyAuthRequest> {

    @Inject
    @RestClient
    AuthClient authClient;

    private static final Logger LOG = Logger.getLogger(MyIdentityProvider.class);

    @Override
    public Class<MyAuthRequest> getRequestType() {
        return MyAuthRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(MyAuthRequest myAuthRequest, AuthenticationRequestContext authenticationRequestContext) {
        LOG.info("MyIdentityProvider");

        String authorization = myAuthRequest.getToken();

        return authClient.validateToken(authorization).onItem().transform(isValid -> {
            LOG.info("Validating Token. Issuer: " + isValid);
            if (isValid) {
                // If credentials are valid, create and return the SecurityIdentity
                QuarkusSecurityIdentity identity = QuarkusSecurityIdentity.builder()
                        .setPrincipal(() -> authorization) // Set the principal
                        .addRole("User")
                        .addRole("Admin")// Add roles as necessary
                        .build();

                LOG.error("Identity: " + identity.getRoles());

                return identity;
            } else {
                // If credentials are invalid, return null or handle accordingly
                LOG.error("You shall not pass!");
                return null;
            }
        });
    }
}
