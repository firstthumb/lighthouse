package net.javaci.lighthouse.frontend.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext appContext;

    // Private constructor prevents instantiation from other classes
    private SpringApplicationContext() {}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }
}
