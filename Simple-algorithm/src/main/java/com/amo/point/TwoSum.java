package com.amo.point;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class TwoSum {
    //左右指针
    public int[] twoSum(int[] nums, int target) {
       int left=0,right= nums.length-1,sum;
       while (left<right){
           sum=nums[left]+nums[right];
           if (sum==target)return new int[]{nums[left],nums[right]};
           else if (sum>target) right--;
           else left++;
       }
       return new int[0];
    }


    //用hashmap
   /* public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{nums[map.get(target-nums[i])],nums[i]};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }*/
}
