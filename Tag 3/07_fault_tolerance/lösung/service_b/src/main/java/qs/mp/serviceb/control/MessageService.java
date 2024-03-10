package qs.mp.serviceb.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.serviceb.entity.Author;
import qs.mp.serviceb.entity.IMessage;
import qs.mp.serviceb.entity.Message;
import qs.mp.serviceb.entity.MessageType;
import qs.mp.serviceb.servicea.control.ServiceARestClient;
import qs.mp.serviceb.servicea.entity.MessageA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@ApplicationScoped
@Timed
public class MessageService {

    @Inject
    @RestClient
    ServiceARestClient serviceARestClient;

    private final List<Message> messages = new ArrayList<>();

    Logger logger = Logger.getLogger(MessageService.class.getName());

    @Counted(name = "addMessageCount", description = "How many messages have been created")
    public IMessage addMessage(IMessage message) {
        if (message.getMessageType() == MessageType.MESSAGE_A) {
            return serviceARestClient.add((MessageA) message);
        }
        messages.add((Message) message);
        return message;
    }

    public List<Message> getAllMessages() throws InterruptedException {
        Random random = new Random();

        int randomNumber = random.nextInt(5);

        if (randomNumber < 3) {
            throw new RuntimeException("Some error occured");
        }

        Thread.sleep(randomNumber * 1000);

        return messages;
    }

    public Message sayHelloWorld() {
        return new Message("Hello World", "Hello World from Quarkus", new Author("My Service B"));
    }

    public List<String> getAllMessageAsString() {
        List<String> messageAsString = new ArrayList<>();
        for (Message message : messages) {
            messageAsString.add(message.toString());
        }

        List<IMessage> messagesA = getAllMessagesFromServiceA();
        for (IMessage messageA : messagesA) {
            messageAsString.add(messageA.toString());
        }

        return messageAsString;
    }

    @Gauge(unit = "count", name="numberOfMessagesGauge", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }


    // @Retry(maxRetries = 3)
    @Timeout(3000)
    @Fallback(fallbackMethod = "getAllMessagesFromServiceAFallback")
    public List<IMessage> getAllMessagesFromServiceA() {
        return serviceARestClient.getAll();
    }

    private List<IMessage> getAllMessagesFromServiceAFallback() {
        logger.warning("Fallback method called");
        return new ArrayList<>();
    }
}
