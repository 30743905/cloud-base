package org.simon.client;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-25 15:14
 */
@Slf4j
public class ConfigServiceTest {

    @Test
    public void test01() throws InterruptedException {
        System.setProperty("env", "DEV");
        /**
         * properties文件加不加后缀都可以
         *
         * properties文件监听，只会发送变更key信息
         *
         *
         *
         */
        Config config = ConfigService.getConfig("gateway-application");
        System.out.println(config.getPropertyNames());

        Set<String> interestedKeys = new HashSet<>();
        interestedKeys.add("yusp.gateway.key1");
        interestedKeys.add("yusp.gateway.key2");

        config.addChangeListener(event -> {
            log.info("receive change, keys:{}", event.changedKeys());
        });

        System.out.println("8888");
        TimeUnit.SECONDS.sleep(1000);

    }


    @Test
    public void test02() throws InterruptedException {
        System.setProperty("env", "PROD");
        /**
         * properties文件加不加后缀都可以
         *
         * properties文件监听，只会发送变更key信息
         *
         *
         *
         */
        Config config = ConfigService.getConfig("test02");



        System.out.println(config.getPropertyNames());

        Set<String> interestedKeys = new HashSet<>();
        interestedKeys.add("yusp.gateway.key1");
        interestedKeys.add("yusp.gateway.key2");

        config.addChangeListener(event -> {
            log.info("receive change, keys:{}", event.changedKeys());
        });

        System.out.println("8888");
        TimeUnit.SECONDS.sleep(1000);

    }


}