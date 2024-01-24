package qs.mp.servicea.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import qs.mp.servicea.serviceb.entity.MessageB;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Message.class, name = "MESSAGE_A"),
        @JsonSubTypes.Type(value = MessageB.class, name = "MESSAGE_B")
})
public interface IMessage {

    String toString();
    @JsonIgnore
    MessageType getMessageType();
}
