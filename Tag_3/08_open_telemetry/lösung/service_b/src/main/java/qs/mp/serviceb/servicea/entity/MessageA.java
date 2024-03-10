package qs.mp.serviceb.servicea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qs.mp.serviceb.entity.IMessage;
import qs.mp.serviceb.entity.MessageType;

@Getter
@Setter
@NoArgsConstructor
public class MessageA implements IMessage {
    private String heading;
    private String body;

    public MessageA(String heading, String body) {
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
