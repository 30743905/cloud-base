package org.simon.config.resource;



import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import org.simon.config.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import cn.com.yusys.yusp.commons.config.core.ChangeEvent;
import cn.com.yusys.yusp.commons.config.core.ChangeListener;
import cn.com.yusys.yusp.commons.config.core.ConfigTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-21 15:21
 */
@Slf4j
@RefreshScope
@RestController
public class TestResource {

    @Autowired
    private ConfigTemplate configTemplate;

    @Value("${yusp.config.key1:default}")
    private String key1;

    @Value("${yusp.config.key2:default}")
    private String key2;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/test01")
    public String test01(){
      return key1+":"+key2;
    }

    @GetMapping("/test02")
    public String test02(){
        return propertyService.getKey1()+":"+propertyService.getKey2();
    }

    @GetMapping("/listener01")
    public void listener01(String dataId){
        log.info("receive listener01, dataId:{}", dataId);
        configTemplate.addListener(dataId, new ChangeListener() {
            public void onChange(ChangeEvent changeEvent) {
                log.info("receive change01:{}", changeEvent);
            }
        });
    }

    @GetMapping("/listener02")
    public void listener02(String dataId, Set<String> keys){
        log.info("receive listener02, dataId:{}, keys:{}", dataId, keys);
        configTemplate.addListener(dataId, keys, new ChangeListener() {
            public void onChange(ChangeEvent changeEvent) {
                log.info("receive change02:{}", JSON.toJSONString(changeEvent.getChanges(), true));
            }
        });
    }

    @GetMapping("/getProperty")
    public String getProperty(String dataId, String key, String defaultValue){
        String ret = configTemplate.getProperty(dataId, key, defaultValue);
        log.info("ret:{}", ret);
        return ret;
    }

    @GetMapping("/getConfig")
    public String getConfig(String dataId){
        String ret = configTemplate.getConfig(dataId);
        log.info("ret:{}", ret);
        return ret;
    }

    @Autowired
    private NacosConfigManager manager;

    @GetMapping("/publish")
    public void publish(String value) throws NacosException {
        ConfigService configService = manager.getConfigService();
        boolean ret = configService.publishConfig("test.properties", "DEV", value);
        System.out.println(ret);
    }



}