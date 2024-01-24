package qs.mp.servicea.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.servicea.entity.Message;
import qs.mp.servicea.serviceb.control.ServiceBRestClient;
import qs.mp.servicea.serviceb.entity.MessageB;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Timed
public class MessageService {
    private final List<Message> messages = new ArrayList<>();

    @Inject
    @RestClient
    ServiceBRestClient client;

    @Counted(name = "addMessageCount", description = "How many messages have been created")
    public void addMessage(Message message) {
        messages.add(message);
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

    public List<String> getAllMessagesAsString() {
        List<String> messagesAsString = new ArrayList<>();
        for (Message message : messages) {
            messagesAsString.add(message.toString());
        }

        List<MessageB> messagesB = client.getAll();
        for (MessageB message : messagesB) {
            messagesAsString.add(message.toString());
        }

        return messagesAsString;
    }

    @Gauge(unit = "count", name="numberOfMessagesGauge", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }

}
