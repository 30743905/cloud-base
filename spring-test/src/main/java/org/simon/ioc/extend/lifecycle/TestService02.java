package org.simon.ioc.extend.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Copyright © 2020 tiger Inc. All rights reserved.
 * @create 2020-07-12 17:08
 */
@Component
public class TestService02 implements SmartLifecycle {

    public TestService02(){
        System.out.println("===TestService02被创建");
    }

    public void start() {
        System.out.println("===start");
    }

    public void stop() {
        System.out.println("===stop");
    }

    public boolean isRunning() {
        System.out.println("===isRunning");
        return false;
    }

    public boolean isAutoStartup() {
        System.out.println("===isAutoStartup");
        return true;
    }

    public void stop(Runnable callback) {
        System.out.println("===stop");
    }

    public int getPhase() {
        System.out.println("===getPhase");
        return 0;
    }
}