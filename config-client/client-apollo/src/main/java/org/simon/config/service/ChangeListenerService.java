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
//@Component
public class ChangeListenerService {

    @ChangeListener(dataId = "config-application.properties")
    public void configChange(ChangeEvent changeEvent){

        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }

    @ChangeListener(dataId = "gateway-application.json")
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

    @ChangeListener(dataId = "gateway-application.properties", interestedKeys = {"yusp.gateway.key2", "yusp.gateway.key3"})
    public void configChange4(ChangeEvent changeEvent){
        Map<String, ChangeItem> events = changeEvent.getChanges();
        Set<Map.Entry<String, ChangeItem>> entries = events.entrySet();
        for(Map.Entry<String, ChangeItem> entry : entries){
            log.info("receive04 key:{}, value:{}", entry.getKey(), entry.getValue().getNewValue());
        }
    }



}