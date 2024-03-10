package qs.mp.serviceb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import qs.mp.serviceb.servicea.entity.MessageA;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Message.class, name = "MESSAGE_B"),
        @JsonSubTypes.Type(value = MessageA.class, name = "MESSAGE_A")
})
public interface IMessage {

    String toString();

    MessageType getMessageType();
}
