package com.skse.se.design.behavioral.chain;

/**
 * @author sukang on 2019/7/5.
 */
public interface FilterChain<T> {


    T doFilter(T t);
}
