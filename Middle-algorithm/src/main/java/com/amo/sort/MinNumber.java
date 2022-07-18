package com.amo.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        //修改排序规则
        //如果x+y>y+x 则x>y
        //如果x+y<y+x 则x<y
       String []str=new String[nums.length];
       for (int i = 0; i < nums.length; i++) {
            str[i]=String.valueOf(nums[i]);
       }
       //自定义排序规则
        Arrays.sort(str, (x1, x2) -> (x1+x2).compareTo(x2+x1));
       StringBuilder sb=new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
