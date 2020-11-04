package com.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName: com.excel
 * @Package: com.activemq.topic
 * @ClassName: MqTopicConsumer
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/2 8:46
 * @Version: 1.0
 */
public class MqTopicConsumer {
    private static final String URL = "tcp://localhost:61616";
    
    private static final String TOPIC = "test-topic";
    
    
    public void testTopicConsumer() throws Exception{
        //创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        //创建连接
        Connection connection = factory.createConnection();
        //开始连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建topic
        Topic topic = session.createTopic(TOPIC);
        //创建consumer
        MessageConsumer consumer = session.createConsumer(topic);
        //consumer设置监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    try {
                        String msg = ((TextMessage) message).getText();
                        System.out.println(msg);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //程序等待接收消息
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new MqTopicConsumer().testTopicConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
