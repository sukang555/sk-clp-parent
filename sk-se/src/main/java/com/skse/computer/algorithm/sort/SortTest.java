package com.skse.computer.algorithm.sort;

import com.skse.utils.PrintUtil;
import org.junit.Test;

/**
 * @author sukang
 */
public class SortTest {
	
	private static Integer[] arrays = {90, 91, 57, 88, 60, 42, 83, 73, 88, 55};




	@Test
    public void main4(){
        sortDemo(arrays,0,arrays.length - 1);

        PrintUtil.printArray(arrays);
    }

    public static void sortDemo(Integer[] array, int left,int right){


    }





	@Test
	public void main3(){

		/*QucklySort qucklySort = new QucklySort();
		qucklySort.sort(arrays);*/

		quickSort(arrays,0,arrays.length - 1);
	}





	private static void quickSort(Integer[] a,int low, int high) {

		if (low < high){
			int middle = getMiddle(a, low, high);
			//递归对低子表递归排序
			quickSort(a,0,middle-1);
			//递归对高子表递归排序
			quickSort(a,middle + 1,high);
		}

	}

	private static int getMiddle(Integer[] array,int low,int high){

		int currentValue = array[low];
		while (low < high){
			while (low < high && array[high] >= currentValue){
				high--;
			}
			array[low] = array[high];

			while (low < high && array[low] <= currentValue){
				low++;
			}

			array[high] = array[low];
		}
		array[low] = currentValue;
		PrintUtil.printArray(array);
		return low;
		
	}

	
	


}





















