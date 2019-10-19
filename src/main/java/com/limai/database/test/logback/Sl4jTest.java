package com.limai.database.test.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhang bin
 * @date 2019/9/26
 */
public class Sl4jTest {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.trace("-------trace------");
        logger.debug("-------debug------");
        logger.info("--------info-------");
        logger.warn("--------warm-------");
        logger.error("-------error-----");
    }
}
