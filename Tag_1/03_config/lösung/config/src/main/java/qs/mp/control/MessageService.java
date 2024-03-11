package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import qs.mp.config.ConfigMessage;
import qs.mp.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@ApplicationScoped
public class MessageService {

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

    @ConfigProperty(name = "custom.greeting.message.heading")
    Supplier<String> customHeading;

    @ConfigProperty(name = "custom.greeting.message.body")
    Provider<String> customBody;

    // Injection Configuration as Object
    @Inject
    ConfigMessage configMessage;

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

    public Message getSupplierAndProviderMessage() {
        return new Message(customHeading.get(), customBody.get());
    }

    public Message getMessageFromConfig(int id) {

        return switch (id) {
            case 0 -> new Message(heading, body);
            case 1 -> new Message(configMessage.heading(), configMessage.body() + " from my ConfigMessage");
            case 2 -> new Message(envHeading, envBody);
            case 3 -> new Message(profileHeading, profileBody);
            case 4 -> getMessageFromCustomConfigSource();
            default -> getHelloWorldMessage();
        };
    }

    private Message getMessageFromCustomConfigSource() {
        String heading = ConfigProvider.getConfig().getValue("custom.greeting.message.heading", String.class);
        String body = ConfigProvider.getConfig().getValue("custom.greeting.message.body", String.class);
        return new Message(heading, body);
    }
}
