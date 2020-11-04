package com.activemq.pointToPoing;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MqProducer {

    /**
     * @Author Administrator
     * @Version  1.0
     * @Description
     * @Return
     * @Date 2020/7/1 15:53
     */
    public void testMqProducer() throws Exception{
        //创建工厂连接对象
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //使用连接工厂创建一个连接对象
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用会话对象创建目标，包含queue和topic
        Queue queue = session.createQueue("test-queue");
        //使用会话对象创建producer
        MessageProducer producer = session.createProducer(queue);
        //使用会话对象创建消息对象
        TextMessage textMessage = session.createTextMessage("hello");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new MqProducer().testMqProducer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
