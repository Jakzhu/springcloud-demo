package org.springcloud.demo.test.impl;

import org.springcloud.demo.test.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public String test(String str) {

        return "test+++"+str;
    }
}
