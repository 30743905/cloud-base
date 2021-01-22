package org.simon.retry;

import org.simon.retry.service.IRetryService;
import org.simon.retry.service.RetryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.stats.StatisticsListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2021-01-21
 * @since 1.0.0
 */
@Slf4j
@EnableRetry(proxyTargetClass = false)
@SpringBootApplication
public class RetryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cxt = SpringApplication.run(RetryApplication.class, args);
        IRetryService retryService = cxt.getBean(IRetryService.class);
        log.info("retryService:{}", retryService.getClass());
        retryService.retryTestService();

        StatisticsListener statisticsListener = cxt.getBean(StatisticsListener.class);
        System.out.println(statisticsListener);
    }

}