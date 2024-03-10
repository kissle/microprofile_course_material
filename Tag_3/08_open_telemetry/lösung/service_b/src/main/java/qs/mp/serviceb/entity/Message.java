package qs.mp.serviceb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message implements IMessage {


    private String heading;
    private String body;
    private Author author;

    public Message(String heading, String body, qs.mp.serviceb.entity.Author author) {
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
