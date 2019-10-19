package com.limai.database.test.algorithm;

import java.util.Arrays;

public class BubbleSortExample {
    public static void main(String[] args) {
    int[] arr={6,9,5,15,32,67,17};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    public static int[] bubbleSort(int[] arr){
        if(arr.length==0){
            return arr;
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1]<arr[j]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
