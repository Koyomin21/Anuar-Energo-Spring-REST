package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class SocketMessageTest {
    //Field dateTime of type LocalDateTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    SocketMessage socketMessage = new SocketMessage();

    @Test
    void testSetMessage() {
        socketMessage.setMessage("message");
    }

    @Test
    void testSetDateTime() {
        socketMessage.setDateTime(LocalDateTime.of(2022, Month.MAY, 18, 12, 20, 7));
    }

    @Test
    void testEquals() {
        boolean result = socketMessage.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = socketMessage.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = socketMessage.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = socketMessage.toString();
        Assertions.assertEquals("SocketMessage(message=null, dateTime=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme