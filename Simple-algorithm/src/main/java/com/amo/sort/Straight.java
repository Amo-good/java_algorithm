package com.amo.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 * 输入: [0,0,1,2,5]
 * 输出: True

 */
public class Straight {

    public boolean isStraight(int[] nums) {
        //如果牌子无重复，构成顺子可以看成max-min<5(大小王不构成min)
        //利用 Set 实现遍历判重，出现重复值则返回false
        Set<Integer> set=new HashSet<>();
        int max=0,min=14;
        for (int num : nums) {
            if (num==0) continue;//跳过最小最大王
            //更新最大和最小值
            max=Math.max(max, num);
            min=Math.min(min, num);
            if (set.contains(num)) return false;//出现重复值，返回false
            set.add(num);
        }
        //最大值-最小值<5 构成顺子
       return max-min<5;

    }
}
