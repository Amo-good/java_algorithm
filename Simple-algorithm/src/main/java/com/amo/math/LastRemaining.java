package com.amo.math;

import java.util.ArrayList;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 */
public class LastRemaining {
    //约瑟夫环问题-----数学解法
    public int lastRemaining(int n, int m) {
        //最后分割完数据所在的数组的下标为0
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            //补上m个位置，然后模上当时的数组大小
            ans = (ans + m) % i;
        }
        return ans;
    }




    //耗时长
/*    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        //保存元素
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //定义要删除的元素的位置
        int idx = 0;
        while (n > 1) {
            //下一个删除的元素位置，由于元素被删，所有的元素都会往前移动一位，因为循环所以取模
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }*/
}
