package itse1909r.borangaziyev.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

class JmsConfigTest {
    JmsConfig jmsConfig = new JmsConfig();

    @Test
    void testMyFactory() {
        JmsListenerContainerFactory<?> result = jmsConfig.myFactory(null, null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testJacksonJmsMessageConverter() {
        MessageConverter result = jmsConfig.jacksonJmsMessageConverter();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme