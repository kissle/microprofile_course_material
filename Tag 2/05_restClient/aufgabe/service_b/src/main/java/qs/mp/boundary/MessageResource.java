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

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Message get(@QueryParam("heading") String heading, @QueryParam("body") String body) {
        return messageService.getMessage(heading, body);
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
    public String getString(@QueryParam("heading") String heading, @QueryParam("body") String body) {
        return messageService.getMessageAsString(messageService.getMessage(heading, body));
    }

    @GET
    @Path("/config/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageFromConfig(@PathParam("id") int id) {
        return messageService.getMessageFromConfig(id);
    }
}
