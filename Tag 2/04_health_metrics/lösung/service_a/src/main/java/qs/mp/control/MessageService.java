package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import qs.mp.config.ConfigMessage;
import qs.mp.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
@Timed
public class MessageService {

    private final Random random = new Random();

    // Injection Configuration
    @ConfigProperty(name = "greeting.message.heading")
    String heading;

    @ConfigProperty(name = "greeting.message.body")
    String body;

    @ConfigProperty(name = "envgreeting.message.heading")
    String envHeading;

    @ConfigProperty(name = "envgreeting.message.body")
    String envBody;

    @ConfigProperty(name = "profile.greeting.message.heading")
    String profileHeading;

    @ConfigProperty(name = "profile.greeting.message.body")
    String profileBody;

    // Injection Configuration as Object
    @Inject
    ConfigMessage configMessage;

    private List<Message> messages = new ArrayList<>();


    @Counted(name = "addMessageCount", description = "How many messages have been created")
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

    public Message sayHelloWorld() {

        try {
            Thread.sleep(randomDelay());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new Message("Hello World", "Hello World from Quarkus");
    }


    public Message getMessageFromConfig(int id) {

        return switch (id) {
            case 0 -> new Message(heading, body);
            case 1 -> new Message(configMessage.heading(), configMessage.body() + " from my ConfigMessage");
            case 2 -> new Message(envHeading, envBody);
            case 3 -> new Message(profileHeading, profileBody);
            case 4 -> getMessageFromCustomConfigSource();
            default -> sayHelloWorld();
        };
    }

    private Message getMessageFromCustomConfigSource() {
        String heading = ConfigProvider.getConfig().getValue("custom.greeting.message.heading", String.class);
        String body = ConfigProvider.getConfig().getValue("custom.greeting.message.body", String.class);
        return new Message(heading, body);
    }

    @Gauge(unit = "count", name = "numberOfMessages", description = "How many messages are in the list")
    public int numberOfMessages() {
        return messages.size();
    }

    @Gauge(unit = "milliseconds", name = "randomDelay", description = "Random delay in milliseconds")
    public int randomDelay() {
        return random.nextInt(5000);
    }
}
