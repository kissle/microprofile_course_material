package qs.mp.servicea.serviceb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qs.mp.servicea.entity.IMessage;
import qs.mp.servicea.entity.MessageType;

@Getter
@Setter
@NoArgsConstructor
public class MessageB implements IMessage {

    private String heading;
    private String body;
    private Author author;

    public MessageB(String heading, String body, Author author) {
        this.heading = heading;
        this.body = body;
        this.author = author;
    }

    public String toString() {
        String authorName = "";
        if (this.getAuthor() != null) {
             authorName = this.getAuthor().getName();
        }
        return "(" + authorName + ") " + this.getHeading() + ": " + this.getBody();
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.MESSAGE_B;
    }
}
