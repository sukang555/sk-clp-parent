package com.skse.se.jvm;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * Created by sukang on 2018/7/26.
 */
public class WeakReFerenceTest {



    @Test
    public void main1(){

        Object o = new Object();


        final WeakReference<Object> objectWeakReference = new WeakReference<>(o);
        int i = 0;
        while (true){
            if (objectWeakReference.get() != null){
                ++i;

                System.out.println(objectWeakReference.toString());
            }else {
                System.out.println(i);
                System.out.print("对象已经被回收");
                break;
            }
        }
    }

}
