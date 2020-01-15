package com.redJoker.algorithm.sort;

public class insertSort {
    public static void sort(int[] data) {
        int tmp = 0;
        for (int i = 1; i < data.length; i++) {
            tmp = data[i];
            int n = i - 1;
            for (; n >= 0; n--) {
                if (data[n] >= tmp) {
                    data[n + 1] = data[n];
                    //将大于当前值的数后移一个位置
                } else {
                    break;
                }
            }
            data[n+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,6};
        insertSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
