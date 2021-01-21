package org.simon.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-08-26
 * @since 2.4.2
 */
public class ApplicationContextInitializerTest implements ApplicationContextInitializer<ConfigurableApplicationContext>, EnvironmentPostProcessor, Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("***");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("***");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}