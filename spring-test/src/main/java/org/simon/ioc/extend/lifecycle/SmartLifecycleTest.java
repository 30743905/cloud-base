package org.simon.ioc.extend.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author Administrator
 * @Copyright © 2020 tiger Inc. All rights reserved.
 * @create 2020-07-12 17:05
 */
public class SmartLifecycleTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        System.out.println("===context构建完成");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(x -> System.out.println("beanName:"+x));
        System.out.println("===context将要关闭");
        context.close();
    }
}