/**
 * Copyright © 2004-2018 LianlianPay.All Rights Reserved.
 */
/**
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package org.springcloud.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 项目启动类
 * 
  */
@EnableEurekaServer
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static volatile boolean running = true;

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    synchronized (Application.class) {
                        running = false;
                        Application.class.notify();
                    }
                }
            });
            System.setProperty("spring.devtools.restart.enabled", "false");
            System.setProperty("spring.boot.mainclass", Application.class.getName());
            SpringApplication.run(Application.class, args);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }

        synchronized (Application.class) {
            while (running) {
                try {
                    Application.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

    public void run(String... strings) throws Exception {

    }

    @Bean
    @LoadBalanced //客户端负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
