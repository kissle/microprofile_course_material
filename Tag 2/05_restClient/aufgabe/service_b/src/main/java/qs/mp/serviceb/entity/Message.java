package qs.mp.serviceb.entity;

import lombok.Data;

@Data
public class Message {

    private String heading;
    private String body;
    private qs.mp.serviceb.entity.Author author;

    public Message(String heading, String body, qs.mp.serviceb.entity.Author author) {
        this.heading = heading;
        this.body = body;
        this.author = author;
    }

    public String toString() {
        return "(" + this.getAuthor() + ") " + this.getHeading() + ": " + this.getBody();
    }
}
