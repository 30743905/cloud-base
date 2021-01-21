package org.simon.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.com.yusys.yusp.commons.config.core.ChangeEvent;
import cn.com.yusys.yusp.commons.config.core.ChangeItem;
import cn.com.yusys.yusp.commons.config.core.ChangeListener;
import cn.com.yusys.yusp.commons.config.core.ConfigTemplate;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-26 12:49
 */
@SpringBootApplication
public class ApolloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApolloApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();
        String value = env.getProperty("test01.key01");
        ConfigTemplate configTemplate = context.getBean(ConfigTemplate.class);
        /*boolean ret = configTemplate.publishProperty("test01.properties", "test01.key01", "hahah:" + System.currentTimeMillis());
        System.out.println(ret);
        ret = configTemplate.publishProperty("test02.json", "content", "{'key':'vvv'}");
        System.out.println(ret);*/


        /*String ret = configTemplate.getConfig("test02.json");
        System.out.println(ret);

        ret = configTemplate.getProperty("test02.json", "test01.key01", null);
        System.out.println(ret);*/


       /* configTemplate.addListener("test01.properties", new ChangeListener() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                Map<String, ChangeItem> changes = changeEvent.getChanges();
                Set<Map.Entry<String, ChangeItem>> entries = changes.entrySet();
                for(Map.Entry<String, ChangeItem> entry:entries){
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                }
            }
        });*/

        /*configTemplate.addListener("test02.json", new ChangeListener() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                Map<String, ChangeItem> changes = changeEvent.getChanges();
                Set<Map.Entry<String, ChangeItem>> entries = changes.entrySet();
                for(Map.Entry<String, ChangeItem> entry:entries){
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                }
            }
        });*/

        Set<String> keys = new HashSet<>();
        keys.add("test.key01");
        configTemplate.addListener("test01.properties", keys, new ChangeListener() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                Map<String, ChangeItem> changes = changeEvent.getChanges();
                Set<Map.Entry<String, ChangeItem>> entries = changes.entrySet();
                for(Map.Entry<String, ChangeItem> entry:entries){
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                }
            }
        });

    }

}