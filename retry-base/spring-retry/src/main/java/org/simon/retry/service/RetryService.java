package org.simon.retry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
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
public class RetryService implements IRetryService{

    @Retryable(/*interceptor = "myInterceptor", *//*value = Exception.class, *//*maxAttempts = 3,*/
            /*maxAttemptsExpression = "#{@testService01.getMax()}",*/
            backoff = @Backoff(delay = 2000, multiplier = 1.5, maxDelay = 5000)
            /*exceptionExpression = "@exceptionChecker.shouldRetry(#root)",*/
            /*listeners = "retryListener01"*/)
    //@Retryable(interceptor = "myInterceptor")
    public void retryTestService() {
        log.info("begin=========>");
        try {
            int a = 2 / 0;
        }catch (Exception e){
            throw new RuntimeException("exception:this can be retried finish");
        }

        log.info("finish========>");
    }

    @Recover
    public void recover1(Exception e) {
        log.error("1==>执行异常，需要恢复", e);
    }

    @Recover
    public void recover2(Exception e) {
        log.error("2==>执行异常，需要恢复", e);
    }


    public int getMax(){
        System.out.println("####******>>>");
        return 6;
    }

    //@Value("#{testConstant.showProperty()?.toUpperCase}")





}