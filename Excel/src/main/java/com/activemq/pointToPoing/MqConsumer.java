package com.activemq.pointToPoing;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName: com.excel
 * @Package: com.activemq
 * @ClassName: MqConsumer
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/1 16:20
 * @Version: 1.0
 */
public class MqConsumer {
    /**
     * @Author ZhuShiQiang
     * @Version  1.0
     * @Description 接收者
     * @Param
     * @Return
     * @Date 2020/7/1 16:20
     */
    public void testMqConsumer() throws Exception{
        //创建工厂连接对象
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //工厂创建连接对象
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //连接对象创建会话对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //会话创建目标，包含queue和topic
        Queue queue = session.createQueue("test-queue");
        //会话创建接收者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //向consumer对象中创建一个消息监听对象
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String msg = textMessage.getText();
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
            new MqConsumer().testMqConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
