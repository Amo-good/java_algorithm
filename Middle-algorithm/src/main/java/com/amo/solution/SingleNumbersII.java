package com.amo.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class SingleNumbersII {
    public int singleNumber(int[] nums) {
        //统计每一位1出现的次数，再对3求余数，剩下的值为单一的数
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;//统计1出现的次数
                num >>>= 1;//右移
            }
        }
        int res=0,m=3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;//每次都左移一位 所以我们要倒序取出
            res |= counts[31 - i] % m;// 恢复第 i 位的值到 res
        }
        return res;

    }
/*    哈希方法
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,0);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==0)return entry.getKey();
        }
        return 0;
    }*/
}
