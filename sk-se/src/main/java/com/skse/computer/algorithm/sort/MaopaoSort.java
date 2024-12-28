package com.skse.computer.algorithm.sort;

/**
 * @author sukang
 */
public class MaopaoSort extends  AbstractSort{


    /**
     * 冒泡排序的时间复杂度
     *
     * 复杂度为  n(n-1)/2 = n^2 - n = n^2
     */
    @Override
    public void sort(Integer[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j +1]){
                    int tem = array[j + 1];
                    array[j +1] = array[j];
                    array[j] = tem;
                }
            }
            print(array);
        }
        System.out.println("------------");

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j +1]){
                    int tem = array[j + 1];
                    array[j +1] = array[j];
                    array[j] = tem;
                }
            }
            print(array);
        }
    }
}
