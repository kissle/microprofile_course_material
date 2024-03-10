package qs.mp.control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qs.mp.servicea.control.MessageService;
import qs.mp.servicea.entity.Message;

public class EmployeeServiceTest {

    private MessageService service;

    @BeforeEach
    public void setUp() {
        service = new MessageService();
    }

    @Test
    public void testAddMessage() throws InterruptedException {
        Message message = new Message("Hello", "World");
        service.addMessage(message);
        Assertions.assertTrue(service.getAllMessages().contains(message));
    }

    @Test
    public void testIfMessageIsCreated() {
        Message message = new Message("Hello", "World");
        Message newMessage = service.getMessage(message.getHeading(), message.getBody());
        Assertions.assertEquals(message.getHeading(), newMessage.getHeading());
        Assertions.assertEquals(message.getBody(), newMessage.getBody());
    }
}