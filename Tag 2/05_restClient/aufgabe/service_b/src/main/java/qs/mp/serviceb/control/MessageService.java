package qs.mp.serviceb.control;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import qs.mp.serviceb.entity.Author;
import qs.mp.serviceb.entity.Message;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Timed
public class MessageService {

    private final List<Message> messages = new ArrayList<>();

    @Counted(name = "addMessageCount", description = "How many messages have been created")
    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public String getMessageAsString(Message message) {
        return message.toString();
    }

    public Message sayHelloWorld() {
        return new Message("Hello World", "Hello World from Quarkus", new Author("My Service B"));
    }

    @Gauge(unit = "count", name="numberOfMessagesGauge", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }
}
