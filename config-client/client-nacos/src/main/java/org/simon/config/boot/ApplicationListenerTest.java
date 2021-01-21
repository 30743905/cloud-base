package org.simon.config.boot;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-08-27
 * @since 2.4.2
 */
public final class ApplicationListenerTest
        implements ApplicationListener<ApplicationStartedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(event);
        ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
        System.out.println(environment.getProperty("test01.key01"));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    public ApplicationListenerTest(){
        System.out.println("********--->");
    }


}