package com.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler")
                .addInterceptors(webSocketHandshakeInterceptor()) //声明拦截器
                .setAllowedOrigins("*"); //声明允许访问的主机列表
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MessageHandler();
    }

    @Bean
    public WebsocketHandshakeInterceptor webSocketHandshakeInterceptor(){
        return new WebsocketHandshakeInterceptor();
    }
}