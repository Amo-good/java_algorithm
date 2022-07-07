package com.amo.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumber {
    class Solution {
        //时间复杂度O(n) 空间复杂度O(n)
 /*       public int findRepeatNumber(int[] nums) {
            HashSet<Integer> hashSet=new HashSet<>();
            for (int num : nums) {
                if (hashSet.contains(num)) {
                    return num;
                }
                hashSet.add(num);
            }
            return -1;
        }*/
        public int findRepeatNumber(int[] nums) {
            //原地交换法：可遍历数组并通过交换操作，使元素的 索引 与 值 一一对应（即nums[i]=i）
           int i=0;
           while (i<nums.length){
               if (nums[i]==i) {
                   i++;
                   continue;
               }
               if (nums[nums[i]]==nums[i]) return nums[i];//满足这一条件，循环结束
               int temp=nums[i];
               nums[i]=nums[temp];
               nums[temp]=temp;
           }
           return -1;
        }
    }
}
