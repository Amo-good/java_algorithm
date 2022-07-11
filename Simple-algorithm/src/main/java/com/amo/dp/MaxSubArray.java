package com.amo.dp;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int pre=0;//记录前值
        int sum=0;//计算当前值
        for (int i = 0; i < nums.length; i++) {
            sum=nums[i];
            //只有前面的值大于0我们才添加，否则舍弃
            if (pre>0) sum+=pre;
            //更新最大值
            if(sum>max) max=sum;
            //记录前值
            pre=sum;
        }
        return max;
    }
}
