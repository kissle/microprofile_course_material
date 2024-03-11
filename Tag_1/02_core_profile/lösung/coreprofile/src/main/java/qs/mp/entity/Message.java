package qs.mp.entity;

public class Message {

    private String heading;

    private String body;

    public Message() {}

    public Message(String heading, String body) {
        this.heading = heading;
        this.body = body;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "Heading: " + this.heading + "; Body: " + this.body;
    }

}
