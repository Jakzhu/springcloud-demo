package org.springcloud.demo.test;

import org.springcloud.demo.proxy.jdk.TestProxy;
import org.springcloud.demo.test.impl.TestServiceImpl;

public class TestMain {

    public static void main(String[] args) {

        TestProxy proxy   = new TestProxy();
        TestServiceImpl testService  = new TestServiceImpl() ;
        TestService  se  = (TestService) proxy.createTargetObject(testService);

      System.out.println(se.test("test"));


    }
}
