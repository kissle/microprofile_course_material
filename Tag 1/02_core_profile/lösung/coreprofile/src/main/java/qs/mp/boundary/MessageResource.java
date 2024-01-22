package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import qs.mp.control.MessageService;
import qs.mp.entity.Message;

import java.util.List;

@Path("/messages")
public class MessageResource {

    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        return Response.ok(messageService.getAllMessages()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMessage(Message message) {
        this.messageService.addMessage(message);
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloWorld() {
        return Response.ok(messageService.getHelloWorldMessage()).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@RestQuery("heading") String heading, @RestQuery("body") String body) {
        return Response.ok(new Message(heading, body)).build();
    }

    @POST
    @Path("/string")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAsString(Message message) {
        return Response.ok(message.toString()).build();
    }
}
