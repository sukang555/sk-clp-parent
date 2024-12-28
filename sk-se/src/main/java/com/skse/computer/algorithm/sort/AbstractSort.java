package com.skse.computer.algorithm.sort;


import com.skse.utils.PrintUtil;

import java.util.Arrays;

/**
 * @author sukang on 2018/8/20.
 */
public abstract class AbstractSort {

    public abstract void sort(Integer[] array);


    public void print(Integer[] array){
        PrintUtil.printArray(Arrays.asList(array));
    }
}
