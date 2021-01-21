package org.simon.ioc.extend.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @Copyright © 2020 tiger Inc. All rights reserved.
 * @create 2020-07-12 17:08
 */
@Configuration
@ComponentScan(basePackageClasses = MyConfiguration.class)
public class MyConfiguration implements SmartLifecycle {
    public MyConfiguration(){
        System.out.println("***MyConfiguration");
    }
    @Override
    public void start() {
        System.out.println("***MyConfiguration start");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}