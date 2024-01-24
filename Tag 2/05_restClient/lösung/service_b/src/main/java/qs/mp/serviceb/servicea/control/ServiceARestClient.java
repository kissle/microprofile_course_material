package qs.mp.serviceb.servicea.control;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import qs.mp.serviceb.servicea.entity.MessageA;

import java.util.List;

@Path("/messages")
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface ServiceARestClient {

    @GET
    List<MessageA> getAll();

    @POST
    MessageA add(MessageA message);
}
