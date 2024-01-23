package qs.mp.entity;

import lombok.Data;

@Data
public class Message {

    private String heading;
    private String body;
    private Author author;

    public Message(String heading, String body, Author author) {
        this.heading = heading;
        this.body = body;
        this.author = author;
    }

    public String toString() {
        return "(" + this.getAuthor() + ") " + this.getHeading() + ": " + this.getBody();
    }
}
