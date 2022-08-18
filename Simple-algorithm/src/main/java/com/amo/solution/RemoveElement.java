package com.amo.solution;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            //找到需要移除的元素
            if (nums[i]==val) continue;
            //交换元素顺序
            nums[j++]=nums[i];
        }
        return j;
    }
}
