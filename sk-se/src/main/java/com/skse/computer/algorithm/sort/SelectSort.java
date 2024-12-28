package com.skse.computer.algorithm.sort;

/**
 * @author Administrator
 */

public class SelectSort  extends  AbstractSort{

        /**
         * n+ (n-1) + (n-2) + 1
         *
         * = na1 + n(n-1)/2 = (n^2 +n)/2
         */
        @Override
        public void sort(Integer[] array) {

            Integer max = array[0];

            for (int i = 0; i < array.length; i++) {

                for (int j = i + 1; j < array.length; j++) {
                    if (max < array[j]){
                        Integer temp = max;
                        max = array[j];
                        array[j] = temp;
                    }
                }
                array[i] = max;
                max = array[i == array.length - 1 ? i : i+1];

                print(array);
            }


        }
}
