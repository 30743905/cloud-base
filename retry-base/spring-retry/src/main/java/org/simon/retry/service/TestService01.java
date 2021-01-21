package org.simon.retry.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2021-01-21
 * @since 1.0.0
 */
@Component
public class TestService01 {

    public TestService01(){
        System.out.println("+++++++++++++");
    }

    public int getMax(){
        System.out.println("******>>>");
        return 5;
    }

}