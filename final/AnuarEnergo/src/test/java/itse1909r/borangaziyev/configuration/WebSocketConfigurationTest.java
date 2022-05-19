package itse1909r.borangaziyev.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import static org.mockito.Mockito.mock;

class WebSocketConfigurationTest {
    WebSocketConfiguration webSocketConfiguration = new WebSocketConfiguration();

    @Test
    void testConfigureMessageBroker() {
        MessageBrokerRegistry reg = mock(MessageBrokerRegistry.class);
        webSocketConfiguration.configureMessageBroker(reg);
    }

    @Test
    void testRegisterStompEndpoints() {
        StompEndpointRegistry reg = mock(StompEndpointRegistry.class);
        webSocketConfiguration.registerStompEndpoints(reg);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme