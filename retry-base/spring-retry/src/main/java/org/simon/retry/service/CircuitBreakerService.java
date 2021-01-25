package org.simon.retry.service;

import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2021-01-25
 * @since 1.0.0
 */
@Slf4j
@Component
public class CircuitBreakerService {

    // 实现类正常方法
// openTimeout时间范围内失败maxAttempts次数后，熔断打开resetTimeout时长
    @CircuitBreaker(maxAttempts = 3, openTimeout = 3000L, resetTimeout = 5000L)
    public String normalMethod(String param) {
        log.info("======== normalMethod ======== " + param);
        if (true) {
            throw new RuntimeException("方法异常");
        }
        return param;
    }

    // 降级方法
    @Recover
    public String recoverMethod(Throwable t, String param) {
        log.info("======== recoverMethod ======== " + param);
        return param;
    }
}