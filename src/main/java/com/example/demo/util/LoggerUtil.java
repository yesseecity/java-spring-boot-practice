package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

    private final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public void debug(String message) {
        logger.debug(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    // Other logging utility methods
}