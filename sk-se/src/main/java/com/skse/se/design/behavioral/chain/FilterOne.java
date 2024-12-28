package com.skse.se.design.behavioral.chain;

/**
 * @author sukang on 2019/7/5.
 */
public class FilterOne implements FilterChain<String>{


    @Override
    public String doFilter(String s) {
        return s.concat("one");
    }
}
