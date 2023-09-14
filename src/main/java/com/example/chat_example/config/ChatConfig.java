package com.example.chat_example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 해당 내용: https://rmcodestar.github.io/websocket/2019/02/11/spring-websocket/
 * 참고: https://velog.io/@rainbowweb/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-STOMP%EB%A1%9C-%EC%B1%84%ED%8C%85%EB%B0%A9-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
 */
@Configuration
@EnableWebSocketMessageBroker //Websocket 기능을 활성화시킨다.
public class ChatConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/queue", "/topic");

        registry.setApplicationDestinationPrefixes("/app");
    }

}
