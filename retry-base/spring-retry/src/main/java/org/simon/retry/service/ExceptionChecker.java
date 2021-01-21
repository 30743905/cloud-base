package org.simon.retry.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2021-01-21
 * @since 1.0.0
 */
@Slf4j
@Component
public class ExceptionChecker {

    public boolean shouldRetry(Exception e){
         log.info("shouldRetry receive exception:{}", e.getMessage());
         return true;
    }

}