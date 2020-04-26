package org.springcloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DemoController {
    @Autowired
   private  RestTemplate  restTemplate ;

     @RequestMapping("/router")
      public String  test(){
         String json =  restTemplate.getForObject("",  String.class);
         return json;
     }
}
