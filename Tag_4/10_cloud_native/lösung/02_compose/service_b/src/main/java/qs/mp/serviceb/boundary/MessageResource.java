package qs.mp.serviceb.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
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
    @Operation(summary = "Say hello", description = "Say hello to the world")
    @APIResponse(responseCode = "200", description = "Hello world")
    @APIResponse(responseCode = "404", description = "Hello world not found")
    public Message hello() {
        return messageService.sayHelloWorld();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a message", description = "Add a message by heading and body")
    @APIResponse(responseCode = "200", description = "Message added")
    @APIResponse(responseCode = "400", description = "Message not added")
    public IMessage add(IMessage message) {
        return messageService.addMessage(message);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all messages", description = "Get all messages")
    @APIResponse(responseCode = "200", description = "Messages found")
    @APIResponse(responseCode = "404", description = "Messages not found")
    public List<Message> getAll() throws InterruptedException {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/string")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get all messages as string", description = "Get all messages as string")
    @APIResponse(responseCode = "200", description = "Messages found")
    public List<String> getAllAsString() {
        return messageService.getAllMessageAsString();
    }
}
