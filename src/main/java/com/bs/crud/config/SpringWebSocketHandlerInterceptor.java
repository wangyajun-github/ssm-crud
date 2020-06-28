package com.bs.crud.config;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        System.out.println("Before Handshake");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //ʹ��userName����WebSocketHandler���Ա㶨������Ϣ
                String userName = (String) session.getAttribute("SESSION_USERNAME");  //һ��ֱ�ӱ���userʵ��
                if (userName!=null) {
                    attributes.put("WEBSOCKET_USERID",userName);
                }
 
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
 
    }
 
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception ex) {
    	System.out.println("after Handshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
 
}
