package qs.mp.servicea.serviceb.control;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import qs.mp.servicea.entity.IMessage;
import qs.mp.servicea.serviceb.entity.MessageB;

import java.util.List;

@Path("/messages")
@RegisterRestClient(baseUri = "http://localhost:8082")
public interface ServiceBRestClient {

    @GET
    List<IMessage> getAll();

    @POST
    MessageB add(MessageB message);
}
