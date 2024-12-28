package com.skse.computer.algorithm;

/**
 * @author sukang
 */
public class Number {


    private static void num(int num){


        while (num != 1){
            for (int i = 2 ;i <= num ;i ++){
                if (num % i == 0){
                    num = (int)(num / i);

                    if (num == 1){
                        System.out.print(i);
                    }else {
                        System.out.print(String.format("%s *",String.valueOf(i)));
                    }
                    break;

                }
            }
        }

    }



}
