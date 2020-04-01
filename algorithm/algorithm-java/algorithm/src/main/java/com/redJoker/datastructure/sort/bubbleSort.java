package com.redJoker.datastructure.sort;

public class bubbleSort {
    public static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int temp = 0;
            for(int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] < data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,8,1,3,2,5,4};
        bubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
