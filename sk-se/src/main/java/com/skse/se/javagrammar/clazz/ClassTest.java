package com.skse.se.javagrammar.clazz;

/**
 * @author sukang on 2019/12/13 15:17
 */
class SingleTon {
    private static SingleTon single;
    public static int count1;
    public static int count2;

    static{
        single = new SingleTon();
        count2 = 0;
    }

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return single;
    }
}

public class ClassTest {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
