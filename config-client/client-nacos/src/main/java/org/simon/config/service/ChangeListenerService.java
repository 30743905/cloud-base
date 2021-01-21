package org.simon.config.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import cn.com.yusys.yusp.commons.config.annotation.ChangeListener;
import cn.com.yusys.yusp.commons.config.core.ChangeEvent;
import cn.com.yusys.yusp.commons.config.core.ChangeItem;
import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-21 18:01
 */
@Slf4j
@Component
public class ChangeListenerService {

    @ChangeListener(dataId = "config-application.properties")
    public void configChange(ChangeEvent changeEvent){

        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }

    @ChangeListener(dataId = "testjson.json")
    public void configChange2(ChangeEvent changeEvent){
        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive02 key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }

    @ChangeListener(dataId = "gateway-application.properties", interestedKeys = {"yusp.gateway.key1", "yusp.gateway.key2"})
    public void configChange3(ChangeEvent changeEvent){
        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive03 key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }

    @ChangeListener(dataId = "test.properties", interestedKeys = {"k1"})
    public void configChange4(ChangeEvent changeEvent){
        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive03 key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }


    /**
     * config:
     *   listener:
     *     data01: gateway-application
     *     keys: key1,key2
     * @param changeEvent
     */
    /*@ChangeListener(dataId = "${config.listener.data01}")
    public void configChangeEnv(ChangeEvent changeEvent){

        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive(Env) dataId:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }

    @ChangeListener(dataId = "${config.listener.data01}", interestedKeys = {"${config.listener.keys}"})
    public void configChangeEnv2(ChangeEvent changeEvent){

        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive(Env2) dataId:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }*/


}