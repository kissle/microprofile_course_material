package qs.mp.servicea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message implements IMessage {

    private String heading;
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
