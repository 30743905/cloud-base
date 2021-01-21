package org.simon.config.resource;



import com.alibaba.fastjson.JSON;

import org.simon.config.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.com.yusys.yusp.commons.config.core.ChangeEvent;
import cn.com.yusys.yusp.commons.config.core.ChangeItem;
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
//@RefreshScope
@RestController
public class TestResource {

    @Autowired
    private ConfigTemplate configTemplate;

    @Value("${yusp.config.key1:dedfault}")
    private String key1;

    @Value("${yusp.config.key2:dedfault}")
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
    public void listener01(String dataId, boolean exceptionFlag){
        log.info("receive listener01, dataId:{}", dataId);
        configTemplate.addListener(dataId, new ChangeListener() {
            public void onChange(ChangeEvent changeEvent) {
                Map<String, ChangeItem> changes = changeEvent.getChanges();
                Set<Map.Entry<String, ChangeItem>> entries = changes.entrySet();
                for(Map.Entry<String, ChangeItem> entry : entries){
                    log.info("receive change01 key:{}, oldValue:{}, newValue:{}", entry.getKey(), entry.getValue().getOldValue(), entry.getValue().getNewValue());
                }
                if(exceptionFlag){
                    int i = 1/0;
                }
            }
        });
    }

    @GetMapping("/listener02")
    public void listener02(String dataId, Set<String> keys){
        log.info("receive listener02, dataId:{}, keys:{}", dataId, keys);
        configTemplate.addListener(dataId, keys, new ChangeListener() {
            public void onChange(ChangeEvent changeEvent) {
                log.info("receive change02:{}", JSON.toJSONString(changeEvent.getChanges(), true));
                int i = 1/0;
            }
        });
    }

    @GetMapping("/getProperty")
    public void getProperty(String dataId, boolean exceptionFlag){
        log.info("receive listener01, dataId:{}", dataId);
        String ret =
                configTemplate.getProperty("gateway-application.properties", "zuul.UrlWhitelistPass.data", "");
        System.out.println(ret);
    }

}