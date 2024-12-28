package com.skse.se.design.behavioral.chain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sukang on 2019/7/5.
 */
public class ChainTest {

    public static List<FilterChain<String>> filterChains =
            new ArrayList<FilterChain<String>>(){{
                add(new FilterOne());
                add(new FilterTwo());
    }};

    @Test
    public void main1(){

        String param = "hello ";

        String nextParam = param;
        for (FilterChain<String> filterChain : filterChains) {
            nextParam = filterChain.doFilter(nextParam);
        }
        System.out.println(nextParam);
    }
}
