package org.springcloud.demo.test;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestA  {

    private  String   name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void     reSetName(String  name) throws InterruptedException {
             this.name = name;
              log.info (Thread.currentThread().getName()+"============="+name);
           // Thread.currentThread().sleep(100000); //没有释放锁
         //  this.wait();


    }
}
