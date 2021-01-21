package org.simon.config.service;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-26 10:42
 */
@Data
@Component
//@RefreshScope
public class PropertyService {

    @Value("${yusp.config.key1:default}")
    private String key1;

    @Value("${yusp.config.key2:default}")
    private String key2;

}