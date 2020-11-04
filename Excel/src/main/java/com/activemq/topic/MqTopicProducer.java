package com.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName: com.excel
 * @Package: com.activemq.topic
 * @ClassName: MqTopicProducer
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/2 8:37
 * @Version: 1.0
 */
public class MqTopicProducer {
    private final static String URL = "tcp://localhost:61616";

    private final static String TOPIC = "test-topic";

    private final static String MESSAGE = "test-message";

    public void testTopicProducer() throws Exception{
        //创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        //创建连接对象
        Connection connection = factory.createConnection();
        //开始连接
        connection.start();
        //创建会话对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //会话创建主题
        Topic topic = session.createTopic(TOPIC);
        //会话创建producer
        MessageProducer producer = session.createProducer(topic);
        //会话创建消息
        TextMessage textMessage = session.createTextMessage(MESSAGE);
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new MqTopicProducer().testTopicProducer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
