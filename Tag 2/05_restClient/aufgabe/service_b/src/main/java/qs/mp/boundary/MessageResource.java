package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import qs.mp.control.MessageService;
import qs.mp.entity.Message;

import java.util.List;

@Path("/messages")
public class MessageResource {

    @Inject
    MessageService messageService;

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Message hello() {
        return messageService.sayHelloWorld();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message add(Message message) {
        messageService.addMessage(message);
        return message;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/string")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString(Message message) {
        return messageService.getMessageAsString(message);
    }
}
