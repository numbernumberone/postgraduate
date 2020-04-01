package com.redJoker.datastructure.sort;

public class quickSort {

    public static void sort(int[] data, int left, int right) {
        if(left >= right) return;
        int index = getIndex(data,left,right);
        sort(data,left,index - 1);
        sort(data,index + 1,right);
    }

    public static int getIndex(int[] data, int left, int right) {
        int cur = data[left];
        int i = left;
        int j = right;
        while(i < j) {
            // 从右向左寻找 寻找第一个小于cur的值
            while(data[j] > cur && i < j) {
                j--;
            }
            // 并将找到的值赋值到data[i]
            data[i] = data[j];
            // 从左向右寻找。寻找第一个大于等于cur的值
            while(data[i] <= cur && i < j) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = cur;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,1,3,2,5,4};
        quickSort.sort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
