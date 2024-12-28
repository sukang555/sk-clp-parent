package com.skse.framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.ManagedBean;

/**
 * @author sukang on 2019/11/25 10:12
 */
@ManagedBean
public class ApplicationUtils implements ApplicationContextAware {

    public static ApplicationContext APPLICATION_CONTEXT = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationUtils.APPLICATION_CONTEXT == null){
            ApplicationUtils.APPLICATION_CONTEXT = applicationContext;
        }
    }


    public static Object getBeanByName(String name){
        return APPLICATION_CONTEXT.getBean(name);
    }

    public static <T> T getBeanByName(String name,Class<T> clazz){
        return APPLICATION_CONTEXT.getBean(name,clazz);
    }


}
