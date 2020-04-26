package org.springcloud.demo.test;


import ch.qos.logback.access.pattern.LocalIPAddressConverter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Controller
@Slf4j
public class SortTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList  list  =  new ArrayList();
         for (int i=0;i<45;i++){
            double ss =  Math.random()*100 ;
             list.add(new BigDecimal(ss).intValue());
         }
        list = (ArrayList) list.stream().distinct().collect(Collectors.toList());
        Collections.sort(list);
         Gson  json   = new Gson();
         log.info(json.toJson( list).toString());
         byte a=127,b =127  ;
        // a= (byte) (a+b);
         ;
         log.info(String.valueOf(a+=b));

        log.info(String.valueOf(8 << 8));
      }
}
