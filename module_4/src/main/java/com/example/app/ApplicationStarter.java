package com.example.app;

import com.example.MBean;
import com.example.MBeanImpl;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class ApplicationStarter {
    public static void main(String[] args) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException, MalformedObjectNameException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        StandardMBean mbean = new StandardMBean(new MBeanImpl(), MBean.class);

        ObjectName mbeanName = new ObjectName("com.example:type=MBean");

        mbs.registerMBean(mbean, mbeanName);

        // Запуск програми
        CaseConverter caseConverter = new CaseConverter();
        caseConverter.startProgram();

        // Зупинка програми

    }
}
