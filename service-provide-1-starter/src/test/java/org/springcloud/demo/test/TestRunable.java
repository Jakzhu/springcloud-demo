package org.springcloud.demo.test;

public class TestRunable   implements  Runnable {

    private  final TestA a ;
    private  String name ;
    public  TestRunable (final  TestA   a,String name){
        this.a =a;
        this.name= name;
    }
    @Override
    public void run() {
        try {
            a.reSetName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
