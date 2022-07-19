package com.amo.sort;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        quick(arr, 0, arr.length-1);
        return Arrays.copyOf(arr, k);
    }

    void quick(int []arr,int l,int r){
        if (l<r){
            int left=l,right=r;
            int target=arr[l];
            while (left<right){
                while (left<right&&arr[right]>=target) right--;
                arr[left]=arr[right];
                while (left<right&&arr[left]<=target) left++;
                arr[right]=arr[left];
            }
            arr[left]=target;
            quick(arr,l,left-1);
            quick(arr,left+1,r);
        }
    }

}
