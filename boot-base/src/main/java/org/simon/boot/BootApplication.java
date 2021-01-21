package org.simon.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-08-28
 * @since 2.4.2
 */
@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        System.getProperties().put("spring.application.json", "{ \"people.name\": \"zhangsan\", \"people.address\": \"chengdu\"}");
        SpringApplication.run(BootApplication.class, args);
    }
}