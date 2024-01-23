package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import qs.mp.entity.Message;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MessageService {

    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void createMessage(String heading, String body) {
        messages.add(new Message(heading, body));
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public String getMessageAsString(Message message) {
        return message.getHeading() + ": " + message.getBody();
    }

    public Message getMessage(String heading, String body) {
        return new Message(heading, body);
    }

    public Message getHelloWorldMessage() {
        return new Message("Hello World", "Hello World from Quarkus");
    }

    public Message getMessageFromConfig(int id) {

        Message message;

        switch(id) {
            case 0:
                message = new Message();
                break;
            default:
                message = getHelloWorldMessage();
        }

        return message;
    }

}
