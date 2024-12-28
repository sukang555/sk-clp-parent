package com.skse.se.design.creational.singleton;

/**
 * @author sukang on 2019/10/18 16:06
 */
public enum SingletonEnum {

    INSTANCE;

    private SingleTon singleTon;

    SingletonEnum() {
        singleTon = new SingleTon();
    }

    public SingleTon getSingleTon() {
        return singleTon;
    }

}
