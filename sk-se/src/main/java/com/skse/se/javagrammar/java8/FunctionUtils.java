package com.skse.se.javagrammar.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: sukang
 * @Date: 2021/12/13 10:14
 */
public class FunctionUtils {


    public static void consumer(Consumer<String> action,String s) {
        action.accept(s);
    }

    public static <T>  T get(Supplier<T> supplier){
        return supplier.get();
    }
}
