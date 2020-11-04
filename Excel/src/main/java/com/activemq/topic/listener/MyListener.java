package com.activemq.topic.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @ProjectName: com.excel
 * @Package: com.activemq.topic.listener
 * @ClassName: MyListener
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/2 13:35
 * @Version: 1.0
 */
public class MyListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
