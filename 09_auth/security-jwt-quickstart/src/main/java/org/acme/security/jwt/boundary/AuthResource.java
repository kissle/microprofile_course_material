package org.acme.security.jwt.boundary;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import org.acme.security.jwt.control.AuthService;

import java.util.List;

@Path("/auth")
public class AuthResource {

    @Inject
    AuthService authService;

    @GET
    @Path("/login")
    @PermitAll
    public String getJwtToken() {
        return authService.getJwtToken();
    }

    @GET
    @Path("/validate")
    @PermitAll
    public Boolean validateToken(@HeaderParam("authorization") String authorization, @Context SecurityContext ctx) {
        return authService.validateToken(ctx);
    }
}
