package org.simon.retry.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import org.springframework.retry.interceptor.StatefulRetryOperationsInterceptor;
import org.springframework.retry.stats.DefaultStatisticsRepository;
import org.springframework.retry.stats.StatisticsListener;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2021-01-21
 * @since 1.0.0
 */
@Configuration
public class RetryConfiguration {

    @Bean("myInterceptor")
    public RetryOperationsInterceptor myInterceptor() {
        return RetryInterceptorBuilder.stateless()
                .backOffOptions(1000, 2, 5000)
                .maxAttempts(5).build();
    }

    @Bean
    public StatisticsListener statisticsListener(){
        DefaultStatisticsRepository repository = new DefaultStatisticsRepository();
        return new StatisticsListener(repository);
    }

}