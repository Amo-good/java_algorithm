package com.amo.search;

import java.util.Arrays;

/**
 * 寻找出旋转数组中最小的元素
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
 * 例如:
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 注意:numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
public class MinArray {
   /* 利用二分查找
    如果numbers[mid]>numbers[right] 说明最小值区间在[mid+1,right]
    如果numbers[mid]<numbers[right] 说明最小值区间在[left,mid]因为mid可能就是最小值
    在有重复元素的条件下，当numbers[mid]=numbers[right]我们无法确定最小值在哪里，
    因此通过暴力，将right--，缩小我们的搜索范围
    */

    public int minArray(int[] numbers) {
        int left=0;
        int right= numbers.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (numbers[mid]>numbers[right]){
                left=mid+1;
            }else if (numbers[mid]<numbers[right]){
                right=mid;//因为最小值可能为此
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
