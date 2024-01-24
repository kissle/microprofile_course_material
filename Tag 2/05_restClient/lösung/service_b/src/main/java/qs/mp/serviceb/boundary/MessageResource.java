package qs.mp.serviceb.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import qs.mp.serviceb.control.MessageService;
import qs.mp.serviceb.entity.IMessage;
import qs.mp.serviceb.entity.Message;

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
    public IMessage add(IMessage message) {
        return messageService.addMessage(message);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/string")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getAllAsString() {
        return messageService.getAllMessageAsString();
    }
}
