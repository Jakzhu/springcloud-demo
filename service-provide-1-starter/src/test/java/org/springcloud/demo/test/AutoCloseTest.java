package org.springcloud.demo.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AutoCloseTest {


    public static void main(String[] args) {
        InputStream res = null ;
        try {
            res = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微信图片_20200415090950.png");
            byte []  wr =    new byte[4096] ;
            res.read(wr) ;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            System.out.println("test");
        }
    }
}
