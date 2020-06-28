package com.bs.crud.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SpringWebSocketHandler extends TextWebSocketHandler {
    
	 
    private static final Map<String, WebSocketSession> users;  //Map���洢WebSocketSession��key��USER_ID �������û��б�
 
    //�û���ʶ
    private static final String USER_ID = "WEBSOCKET_USERID";   //��Ӧ�������ӵ�key
 
 
    static {
        users =  new HashMap<String, WebSocketSession>();
    }
 
    public SpringWebSocketHandler() {}
 
    /**
     * ���ӳɹ�ʱ�򣬻ᴥ��ҳ����onopen����
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
 
        System.out.println("�ɹ�����websocket����!");
        String userId = (String) session.getAttributes().get(USER_ID);
        users.put(userId,session);
        System.out.println("��ǰ�����û�����:"+users.size());
 
        //����ʵ���Լ�ҵ�񣬱��磬���û���¼�󣬻��������Ϣ���͸��û�
        //TextMessage returnMessage = new TextMessage("�ɹ�����socket���ӣ��㽫�յ�������");
        //session.sendMessage(returnMessage);
    }
 
    /**
     * �ر�����ʱ����
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        String userId= (String) session.getAttributes().get(USER_ID);
        System.out.println("�û�"+userId+"���˳���");
        users.remove(userId);
        System.out.println("ʣ�������û�"+users.size());
    }
 
    /**
     * js����websocket.sendʱ�򣬻���ø÷���
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
 
        super.handleTextMessage(session, message);
 
        /**
         * �յ���Ϣ���Զ��崦����ƣ�ʵ��ҵ��
         */
        System.out.println("�������յ���Ϣ��"+message);
 
        if(message.getPayload().startsWith("#anyone#")){ //����ĳ��
 
             sendMessageToUser((String)session.getAttributes().get(USER_ID), new TextMessage("������������" +message.getPayload())) ;
 
        }else if(message.getPayload().startsWith("#everyone#")){
 
             sendMessageToUsers(new TextMessage("������Ⱥ����" +message.getPayload()));
 
        }else{
        	 sendMessageToUsers(new TextMessage("������Ⱥ����" +message.getPayload()));
        }
 
    }
 
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        System.out.println("��������쳣���ر�websocket����... ");
        String userId= (String) session.getAttributes().get(USER_ID);
        users.remove(userId);
    }
 
    public boolean supportsPartialMessages() {
 
        return false;
    }
 
 
    /**
     * ��ĳ���û�������Ϣ
     *
     * @param userId
     * @param message
     */
    public void sendMessageToUser(String userId, TextMessage message) {
        for (String id : users.keySet()) {
            if (id.equals(userId)) {
                try {
                    if (users.get(id).isOpen()) {
                        users.get(id).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
 
    /**
     * �����������û�������Ϣ
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                if (users.get(userId).isOpen()) {
                    users.get(userId).sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
}