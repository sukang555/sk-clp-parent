package com.skse.se.j17;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Jdk17Test {





    @Test
    public void switchTest(){
        String value = """
                select 1 from 
                dual;
                """;

        switch(value){
            case "a","b" -> System.out.println("a and b ");
            case "c","d" -> System.out.println("c and d ");
            case "e","f" -> System.out.println("e and f ");
            case "g","h" -> System.out.println("g and h ");
            default -> System.out.println("unknown");
        }
    }

    @Test
    public void varTest() throws MalformedURLException {
       var url =  new URL("http://www.baidu.com");

       System.out.println(url.getHost());
    }

}




