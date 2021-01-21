package org.simon.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import cn.com.yusys.yusp.commons.config.core.ConfigTemplate;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-21 15:10
 */
@SpringBootApplication
public class NacosApplication {

    public static void main(String[] args) throws NacosException {
        ConfigurableApplicationContext context = SpringApplication.run(NacosApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("111");


        /*ConfigTemplate configTemplate = context.getBean(ConfigTemplate.class);
        boolean ret = configTemplate.publishProperty("test.properties", "test1", "haha1");
        System.out.println(ret);*/

        /*ConfigService configService = context.getBean(NacosConfigManager.class).getConfigService();
        boolean ret = configService.publishConfig("test.properties", "DEV", "k11=v2233");
        System.out.println(ret);*/

        //ConfigTemplate configTemplate = context.getBean(ConfigTemplate.class);
        /*String ret = configTemplate.getProperty("common-db.properties", "jdbc.url", null);
        System.out.println(ret);
        ret = configTemplate.getProperty("common-db.properties", "jdbc.url1", null);
        System.out.println(ret);
        ret = configTemplate.getProperty("common-db1.properties", "jdbc.url", "default");
        System.out.println(ret);*/

        //String ret = configTemplate.getConfig("gateway-application.json");
        //System.out.println(ret);




    }

}