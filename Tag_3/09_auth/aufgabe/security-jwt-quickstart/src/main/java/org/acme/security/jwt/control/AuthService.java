package org.acme.security.jwt.control;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RequestScoped
public class AuthService {

    @Inject
    JsonWebToken jwt;
    @Inject
    @Claim(standard = Claims.birthdate)
    String birthdate;

    @Inject
    Logger LOG;

    public String getJwtToken() {

        return "Bearer " + Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
    }


    public Boolean validateToken(SecurityContext ctx) {
        LOG.info("Validating Token. Issuer: " + jwt.getRawToken());
        LOG.info(ctx.getUserPrincipal());
        if (jwt != null) {
            return jwt.getIssuer().equals("https://example.com/issuer");
        }
        return false;
    }
}
