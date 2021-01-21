package org.simon.boot.boot;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-08-27
 * @since 2.4.2
 */
public final class ApplicationListenerTest
        implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println(event);
        Environment environment = event.getEnvironment();
        System.out.println(environment.getProperty("jdbc.url"));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}