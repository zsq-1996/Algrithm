package com.excel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * @ProjectName: com.excel
 * @Package: com.excel
 * @ClassName: SpringContextStarter
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/2 13:50
 * @Version: 1.0
 */
public class SpringContextStarter {
    private static final Log log = LogFactory.getLog(SpringContextStarter.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:activemq/spring-mqProducer.xml");
            context.start();
            SingleConnectionFactory factory = (SingleConnectionFactory) context.getBean("connectionFactory");
            ActiveMQQueue queue = (ActiveMQQueue)context.getBean("queueDestination");
        } catch (BeansException e) {
            log.error("context start error: ",e);
        }
        synchronized (SpringContextStarter.class){
            while (true){
                try {
                    SpringContextStarter.class.wait();
                } catch (InterruptedException e) {
                    log.error("synchronize error:",e);
                }
            }
        }
    }
}
