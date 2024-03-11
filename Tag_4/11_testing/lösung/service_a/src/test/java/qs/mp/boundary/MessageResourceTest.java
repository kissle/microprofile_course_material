package qs.mp.boundary;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import qs.mp.servicea.control.MessageService;
import qs.mp.servicea.entity.IMessage;
import qs.mp.servicea.entity.Message;

import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MessageResourceTest {

    @InjectMock
    MessageService service;

    @Test
    public void testGetEmployees() throws InterruptedException {
        Message message = new Message("Hello", "World");
        Mockito.when(service.getAllMessages()).thenReturn(List.of(message));

        List<IMessage> messages = service.getAllMessages();

        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message, messages.get(0));
    }

    @Test
    void testCreateEndpoint() {
        Message message = new Message("Hello", "World");

        given()
                .contentType("application/json")
                .body(message)
                .when().post("/messages")
                .then()
                .statusCode(204);
    }

}