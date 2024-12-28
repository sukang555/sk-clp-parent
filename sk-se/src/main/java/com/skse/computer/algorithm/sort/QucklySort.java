package com.skse.computer.algorithm.sort;

import com.skse.utils.PrintUtil;

/**
 * @author sukang
 */
public class QucklySort  extends AbstractSort {

    @Override
    public void sort(Integer[] array) {
        quickSort(array,0,array.length - 1);
    }

    private   void quickSort(Integer[] a,int low, int high) {
        //如果不加这个判断递归会无法退出导致堆栈溢出异常
        if(low<high){
            int middle=getMiddle(a,low,high);
            //递归对低子表递归排序
            quickSort(a,0,middle-1);
            //递归对高子表递归排序
            quickSort(a,middle + 1,high);
        }
    }

    private int getMiddle(Integer[] array,int low,int high){
        //基准元素，排序中会空出来一个位置
        int key = array[low];
        while(low<high){
            //从high开始找比基准小的，与low换位置
            while(low<high && array[high]>=key){
                high--;
            }
            array[low]=array[high];
            print(array);
            //从low开始找比基准大,放到之前high空出来的位置上
            while(low<high && array[low]<=key){
                low++;
            }
            array[high]=array[low];

            print(array);
        }
        //此时low=high 是基准元素的位置，也是空出来的那个位置
        array[low]=key;
        return low;
    }


    public static void quickSort3(Integer[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];





    }





    /**
     * 90, 91, 57, 88, 60, 42, 83, 73, 88, 55
     *
     * 55, 91, 57, 88, 60, 42, 83, 73, 88, 90
     *
     *
     *
     */
    public static void quickSort2(Integer[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];

        int i = left;
        int j = right;

        System.out.println("left:"+left);
        while (i <= j) {
            //从左边找到第一个比中间值大的
            while (arr[i] < pivotValue) {
                i++;
            }
            //从右边找到第一个比中间值小的
            while (arr[j] > pivotValue) {
                j--;
            }

            //将找到的左边的值和右边的值交换位置
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            PrintUtil.printArray(arr);
            if (left < i) {
                quickSort2(arr, left, j);
            }

            /*if (right > i) {
                quickSort2(arr, i, right);
            }*/
        }
    }












}
