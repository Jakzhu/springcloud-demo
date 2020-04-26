package org.springcloud.demo.test;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@Controller
@Slf4j
public class Test {

     //固定的无界的 队列，要考虑数据量大的问题 ，会在成堆栈溢出
  //  private    static  final ExecutorService execution = Executors.newFixedThreadPool(20);


   //private    static  final  ArrayBlockingQueue<Runnable>    queu = new ArrayBlockingQueue<Runnable>(10) ;

    private    static  final  LinkedBlockingQueue<Runnable>    queu = new LinkedBlockingQueue<Runnable>() ;


//   private    static  final ExecutorService execution = new ThreadPoolExecutor(6,
//            10,
//            3000000,
//            TimeUnit.MINUTES,queu);

   // private    static  final ExecutorService execution =Executors.newFixedThreadPool(20);

 private    static  final ExecutorService execution =Executors.newFixedThreadPool(20);




   //  private    static  final ScheduledExecutorService execution =Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        TestA a = new TestA();
        Thread    p =       new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000000; i++) {
                    queu.offer(new TestRunable(a, "t" + i));
                }
            }
        }) ;
        p.start();
        Thread    c =       new Thread(new Runnable() {
            @Override
            public void run() {
                while (queu.size()>0) {
                      try {
                          Runnable r = queu.take();
                          execution.execute(r);
                      }catch (Exception e){
                          log.info("",e);
                      }
                }
            }
        }) ;
        c.start();

        // Thread.currentThread().sleep(100000000);
      }
}
