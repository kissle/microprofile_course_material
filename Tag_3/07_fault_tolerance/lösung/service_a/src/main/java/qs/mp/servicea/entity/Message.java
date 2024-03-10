package qs.mp.servicea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Message", description = "Message entity")
public class Message implements IMessage {

    @Schema(name = "heading", description = "Message heading", example = "My Heading")
    private String heading;
    @Schema(name = "body", description = "Message body", example = "My Body")
    private String body;

    public Message(String heading, String body) {
        this.heading = heading;
        this.body = body;
    }

    public String toString() {
        return this.getHeading() + ": " + this.getBody();
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.MESSAGE_A;
    }
}
