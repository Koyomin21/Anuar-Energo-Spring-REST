package itse1909r.borangaziyev.jms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JmsMessageTest {
    JmsMessage jmsMessage = new JmsMessage("from", "message");

    @Test
    void testSetFrom() {
        jmsMessage.setFrom("from");
    }

    @Test
    void testSetMessage() {
        jmsMessage.setMessage("message");
    }

    @Test
    void testEquals() {
        boolean result = jmsMessage.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = jmsMessage.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = jmsMessage.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = jmsMessage.toString();
        Assertions.assertEquals("JmsMessage(from=from, message=message)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme