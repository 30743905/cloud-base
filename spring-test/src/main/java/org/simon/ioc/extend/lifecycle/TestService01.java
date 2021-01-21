package org.simon.ioc.extend.lifecycle;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Copyright © 2020 tiger Inc. All rights reserved.
 * @create 2020-07-12 17:08
 */
@Component
public class TestService01 {

    public TestService01(){
        System.out.println("===TestService01被创建");
    }
}