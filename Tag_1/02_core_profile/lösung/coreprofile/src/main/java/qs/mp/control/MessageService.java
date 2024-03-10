package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import qs.mp.Logged;
import qs.mp.entity.Message;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MessageService {

    private final List<Message> messages = new ArrayList<>();

    public Message getHelloWorldMessage() {
        return new Message("Hello, World!", "Hello, from Quarkus");
    }

    public Message getAsMessage(String heading, String body) {
        return new Message(heading, body);
    }

    public String getMessageAsString(Message message) {
        return message.toString();
    }

    @Logged
    public List<Message> getAllMessages() {
        return messages;
    }

    @Logged
    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
