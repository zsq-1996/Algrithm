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

}
