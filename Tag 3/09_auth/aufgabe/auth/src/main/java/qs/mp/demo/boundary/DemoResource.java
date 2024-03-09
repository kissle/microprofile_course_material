package qs.mp.demo.boundary;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.jboss.logging.Logger;

@Path("/demo")
@RequestScoped
public class DemoResource {

    @Inject
    Logger LOG;

    @GET
    @Path("/hello")
    @Authenticated
    public String hello() {
        LOG.info("hello");
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("permit-all")
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    @GET
    @Path("roles-allowed")
    @RolesAllowed({ "User" })
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRolesAllowed(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    private String getResponseString(SecurityContext ctx) {
        LOG.info("getResponseString");
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else {
            name = ctx.getUserPrincipal().getName();
        }

        return "Hallo " + name;
    }

}
