package com.limai.database.test.algorithm;
/*
*  二分法查找
* */
public class BinarySearchExample {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,23,26,34};
        System.out.println(binarySearch(arr,34));
    }
    public static int binarySearch(int[] arr,int k){
        int min=0;
        int max=arr.length-1;
        while (min<=max){
            int mid=(min+max)/2;
            if(k<arr[mid]){
                max=mid-1;
            }else if(k>arr[mid]){
                min=mid+1;
            }else {
                return 1;
            }
        }
        return -1;
    }
}
