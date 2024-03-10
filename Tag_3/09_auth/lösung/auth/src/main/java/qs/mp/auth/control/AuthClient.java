package qs.mp.auth.control;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/auth")
@RegisterRestClient(configKey = "auth-api")
public interface AuthClient {

    @GET
    @Path("/login")
    public Uni<String> getJwtToken();

    @GET
    @Path("/validate")
    Uni<Boolean> validateToken(@HeaderParam("authorization") String authorization);
}
