package com.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MBeanImpl implements MBean {

    private static final Logger logger = Logger.getLogger(MBeanImpl.class);

    @Override
    public void changeLogLevelInfo() {
        LogManager.getRootLogger().setLevel(Level.INFO);

        logger.info("Changed log level to INFO");
    }

    @Override
    public void changeLogLevelDebug() {
        LogManager.getRootLogger().setLevel(Level.DEBUG);

        logger.info("Changed log level to DEBUG");
    }
}
