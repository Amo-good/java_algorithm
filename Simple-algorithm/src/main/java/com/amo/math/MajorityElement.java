package com.amo.math;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //因为出现的次数超过一半，我们可以定义一个来统计
        int num=0,temp=0;
        for (int i : nums) {
            if (num==0) temp=i;
            if (temp==i) num++; //相同数统计+！
            else num--; //不同数统计减1
        }
        return temp;
    }
}
