package qs.mp.auth.control;

import io.quarkus.security.identity.IdentityProviderManager;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.quarkus.vertx.http.runtime.security.ChallengeData;
import io.quarkus.vertx.http.runtime.security.HttpAuthenticationMechanism;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import qs.mp.auth.entity.MyAuthRequest;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Alternative
@Priority(1)
@ApplicationScoped
public class MyAuthMechanism implements HttpAuthenticationMechanism {


    private static final Logger LOG = Logger.getLogger(MyAuthMechanism.class);

    @Override
    public Uni<SecurityIdentity> authenticate(RoutingContext context, IdentityProviderManager identityProviderManager) {
        LOG.info("MyCustom HTTPAuthenticationMechanism is working!");

        String token = context.request().headers().get("Authorization");

        if (token == null) {
            LOG.error("Token is null");
            return Uni.createFrom().optional(Optional.empty());
        } else {
            LOG.info("Token: " + token);
            return identityProviderManager.authenticate(new MyAuthRequest(token));
        }
    }

    @Override
    public Uni<ChallengeData> getChallenge(RoutingContext context) {
        // TODO
        return Uni.createFrom().optional(Optional.empty());
    }

    @Override
    public Set<Class<? extends AuthenticationRequest>> getCredentialTypes() {
        LOG.info("MyCustom getCredentialTypes");
        return Collections.singleton(MyAuthRequest.class);
    }
}
