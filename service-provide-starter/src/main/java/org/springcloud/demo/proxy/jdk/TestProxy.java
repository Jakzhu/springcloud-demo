package org.springcloud.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy  implements InvocationHandler {
    private  Object   target;
    public Object createTargetObject(Object targetObject){
        this.target    = targetObject;
        return Proxy.newProxyInstance(this.target.getClass()
                        .getClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
