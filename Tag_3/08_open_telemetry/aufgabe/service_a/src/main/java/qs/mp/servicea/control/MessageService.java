package qs.mp.servicea.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.servicea.entity.IMessage;
import qs.mp.servicea.entity.Message;
import qs.mp.servicea.entity.MessageType;
import qs.mp.servicea.serviceb.control.ServiceBRestClient;
import qs.mp.servicea.serviceb.entity.MessageB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@ApplicationScoped
@Timed
public class MessageService {
    private final List<IMessage> messages = new ArrayList<>();

    @Inject
    @RestClient
    ServiceBRestClient client;

    Logger logger = Logger.getLogger(MessageService.class.getName());

    @Counted(name = "addMessageCount", description = "How many messages have been created")
    public IMessage addMessage(IMessage message) {
        if (message.getMessageType() == MessageType.MESSAGE_B) {
            return client.add((MessageB) message);
        } else {
            messages.add(message);
            return message;
        }
    }

    public List<IMessage> getAllMessages() throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        if (randomNumber < 3) {
            throw new RuntimeException("Some error occured");
        }

        Thread.sleep(randomNumber * 1000);
        return messages;
    }
    public Message getMessage(String heading, String body) {
        return new Message(heading, body);
    }

    public List<String> getAllMessagesAsString() {
        List<String> messagesAsString = new ArrayList<>();
        for (IMessage message : messages) {
            messagesAsString.add(message.toString());
        }

        List<IMessage> messagesB = getAllMessagesFromServiceB();
        for (IMessage message : messagesB) {
            messagesAsString.add(message.toString());
        }

        return messagesAsString;
    }

    @Gauge(unit = "count", name="numberOfMessagesGauge", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }

    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "getAllMessagesFromServiceBFallback")
    @Timeout(4000)
    public List<IMessage> getAllMessagesFromServiceB() {
        return client.getAll();
    }

    private List<IMessage> getAllMessagesFromServiceBFallback() {
        logger.warning("Fallback method called");
        return new ArrayList<>();
    }

}
