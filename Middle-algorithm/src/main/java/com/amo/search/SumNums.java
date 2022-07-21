package com.amo.search;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {
    //此方法不可取，因为递归使用到了if()来终止条件
    /*    public int sumNums(int n) {
        if (n==1) return 1;
        return n+sumNums(n-1);
    }*/


    public int sumNums(int n) {
        //本题需要实现 “当n=1时终止递归” 的需求，可通过短路效应实现
        //n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x=n>1&&(n+=sumNums(n-1))>0;
        return n;
    }
}
