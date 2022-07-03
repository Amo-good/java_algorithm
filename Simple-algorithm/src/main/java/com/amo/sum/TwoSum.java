package com.amo.sum;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {
    public static void main(String[] args) {
        //假设数组为
        int[] arr ={1,2,7,11,9,4,6};
        int[] index = findIndex(arr, 11);
        for (int i : index) {
            System.out.println(i);
        }
    }

    /**
     * 求两数之和
     * @param arr 代求数组
     * @param target 目标元素
     * @return 成功返回两数的下标，失败则返回空白
     */
    public static int[] findIndex(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(target-arr[i])){
                return new int[]{map.get(target-arr[i]),i};
            }
            map.put(arr[i],i);
        }
        return new int[0];
    }
}
