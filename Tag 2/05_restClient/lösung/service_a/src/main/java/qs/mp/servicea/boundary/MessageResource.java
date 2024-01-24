package qs.mp.servicea.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import qs.mp.servicea.control.MessageService;
import qs.mp.servicea.entity.Message;

import java.util.List;

@Path("/messages")
public class MessageResource {

    @Inject
    MessageService messageService;


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
    public List<String> getAllAsString() {
        return messageService.getAllMessagesAsString();
    }
}
