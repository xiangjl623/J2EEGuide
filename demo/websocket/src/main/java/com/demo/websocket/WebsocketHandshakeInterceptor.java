package com.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebsocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    private Logger logger = LoggerFactory.getLogger(WebsocketHandshakeInterceptor.class);

    /**
     * 当客户端与服务器端握手之前之前执行的方法
     * 取出当前存在session的用户信息，封装到WebSocket对象中的map中；
     * 由Handler处理器中获取id
     * @return
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        //将增强的request转换httpservletRequest
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
            HttpServletRequest servletRequest = serverHttpRequest.getServletRequest();
            String sUser = servletRequest.getParameter("user");
            String sPassword = servletRequest.getParameter("password");
            boolean isValid = "test".equals(sUser) && "test".equals(sPassword);
            logger.info("检查连接webSocket用户的合法性: 用户user:[{}]，password:[{}]", sUser, sPassword);
            // 如果用户不合法则拦截
            if (!isValid) {
                logger.warn("权限校验用户不合法: webSocket握手失败,用户account:[{}]没有权限连接webSocket", sUser);
                return false;
            }
            logger.info("权限校验用户合法: webSocket握手成功,用户account:[{}]有权限连接webSocket", sUser);
            return super.beforeHandshake(request, response, wsHandler, attributes);
        }
        //放行
        return true;
    }

    /**
     * 与服务器websoket建立握手之后执行的方法
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Exception exception) {
        super.afterHandshake(request, response, handler, exception);
    }
}
