package com.log4j2;

/**
 * @ProjectName: com.excel
 * @Package: com.log4j2
 * @ClassName: TestLog4j2
 * @Author: ZhuShiQiang
 * @Description: ${description}
 * @Date: 2020/7/2 14:46
 * @Version: 1.0
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestLog4j2 {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
        System.out.println("Hello World!");
    }

    /**
     * @Author ZhuShiQiang
     * @Version  1.0
     * @Description //TODO 通过类加载器获取配置文件
     * @Param
     * @Return
     * @Date 2020/7/20 11:03
     */
    @Test
    public void getProByClassLoader(){
        try {
            //获取类加载器
            ClassLoader classLoader = this.getClass().getClassLoader();
            //加载配置文件
            InputStream inputStream = classLoader.getResourceAsStream("log4j.properties");
            InputStream inputStream1 = classLoader.getResource("log4j.properties").openStream();//第二种方式
            InputStream inputStream2 = classLoader.getResource("log4j.properties").openConnection().getInputStream();//第三种方式
            //创建配置文件对象
            Properties properties = new Properties();

            //从输入流中读取属性列表
            properties.load(inputStream);
            Object o = properties.get("log4j.appender.stdout");
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
