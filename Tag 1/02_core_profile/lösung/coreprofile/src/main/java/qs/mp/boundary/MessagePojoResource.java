package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;
import qs.mp.Logged;
import qs.mp.control.MessageService;
import qs.mp.entity.Message;

import java.util.List;

@Path("/pojo_messages")
public class MessagePojoResource {

    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public void addMessage(Message message) {
        this.messageService.addMessage(message);
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public Message getHelloWorld() {
        return messageService.getHelloWorldMessage();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public Message getMessage(@RestQuery("heading") String heading, @RestQuery("body") String body) {
        return new Message(heading, body);
    }

    @POST
    @Path("/string")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Logged
    public String getAsString(Message message) {
        return message.toString();
    }
}
