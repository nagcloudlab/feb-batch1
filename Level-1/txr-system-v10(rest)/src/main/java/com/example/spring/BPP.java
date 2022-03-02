package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class BPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BPP-before init {}",beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("BPP-after init {}",beanName);
//        if(beanName.equals("transferService"))
//            throw new BeanInitializationException("oops");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
