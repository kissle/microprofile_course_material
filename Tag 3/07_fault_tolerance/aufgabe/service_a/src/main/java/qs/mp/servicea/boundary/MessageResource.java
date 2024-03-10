package qs.mp.servicea.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import qs.mp.servicea.control.MessageService;
import qs.mp.servicea.entity.IMessage;
import qs.mp.servicea.entity.Message;

import java.util.List;

@Path("/messages")
public class MessageResource {

    @Inject
    MessageService messageService;


    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a message", description = "Get a message by heading and body")
    @APIResponse(responseCode = "200", description = "Message found")
    @APIResponse(responseCode = "404", description = "Message not found")
    public Message get(@QueryParam("heading") String heading, @QueryParam("body") String body) {
        return messageService.getMessage(heading, body);
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
    public List<IMessage> getAll() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/string")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get all messages as string", description = "Get all messages as string")
    @APIResponse(responseCode = "200", description = "Messages found")
    @APIResponse(responseCode = "404", description = "Messages not found")
    public List<String> getAllAsString() {
        return messageService.getAllMessagesAsString();
    }
}
