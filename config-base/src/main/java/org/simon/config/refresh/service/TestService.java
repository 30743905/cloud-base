package org.simon.config.refresh.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Copyright © 2020 tiger Inc. All rights reserved.
 * @create 2020-08-20 0:28
 */
@RefreshScope
@Component
public class TestService {

    @Value("${system.order.serverName:default}")
    private String serverName;

    public String getServerName() {
        return serverName;
    }
}