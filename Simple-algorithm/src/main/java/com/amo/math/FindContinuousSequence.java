package com.amo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */
public class FindContinuousSequence {
    /**
     * 利用滑动窗口解决（窗口的移动方向只能一起向右或者向左）
     * 当s>target 时： 向右移动左边界i=i+1 ，并更新元素和s ；
     * 当s<target 时： 向右移动右边界j=j+1 ，并更新元素和s ；
     * 当s=target 时： 记录连续整数序列，并向右移动左边界i=i+1 ；
     */
    public int[][] findContinuousSequence(int target) {
        //i窗口的左边界 j窗口的右边界 s的窗口大小值
        int i=1,j=2,s=3;
        List<int[]> res = new ArrayList<>();
        while (i<j){
            if (s==target){
                //当前窗口满足条件，保存当前各个窗口值
                int []ans=new int[j-i+1];   //窗口为2,3,4 则数组大小int[3]
                for (int k = i; k <=j; k++) {
                     ans[k-i]=k;//k为当前值
                }
                res.add(ans);
            }
            if (s>=target){
                //由于当s大于和等于target时，都要向右移动左边界
                //先减去左边界值，再移动
                s-=i;
                i++;
            }else {
                //加上下一个边界值，再移动
                j++;
                s+=j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
