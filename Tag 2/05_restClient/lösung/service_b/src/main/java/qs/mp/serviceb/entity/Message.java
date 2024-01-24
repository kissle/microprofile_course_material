package qs.mp.serviceb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message implements IMessage {

    private MessageType messageType = MessageType.MESSAGE_B;

    private String heading;
    private String body;
    private Author author;

    public Message(String heading, String body, qs.mp.serviceb.entity.Author author) {
        this.heading = heading;
        this.body = body;
        this.author = author;
    }

    public String toString() {
        return "(" + this.getAuthor().getName() + ") " + this.getHeading() + ": " + this.getBody();
    }
}
