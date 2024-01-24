package qs.mp.serviceb.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.serviceb.entity.Author;
import qs.mp.serviceb.entity.Message;
import qs.mp.serviceb.servicea.control.ServiceARestClient;
import qs.mp.serviceb.servicea.entity.MessageA;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Timed
public class MessageService {

    @Inject
    @RestClient
    ServiceARestClient serviceARestClient;

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

    public List<String> getAllMessageAsString() {
        List<String> messageAsString = new ArrayList<>();
        for (Message message : messages) {
            messageAsString.add(message.toString());
        }

        List<MessageA> messagesA = serviceARestClient.getAll();
        for (MessageA messageA : messagesA) {
            messageAsString.add(messageA.toString());
        }

        return messageAsString;
    }

    @Gauge(unit = "count", name="numberOfMessagesGauge", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }
}
