package com.amo.divide;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (x==0) return 0;//避免后续 x = 1 / x 操作报错
        long b=n;
        double res=1.0;
        //如果n为负数，我们就将x变为倒数再幂次方计算正n
        if (b<0){
            x=1/x;
            b=-b;
        }
        while (b>0){
            //奇数轮保存丢失的底数x
            if ((b&1)==1) res*=x; //b%2==1
            x*=x;//x=x^2 将循环次数对半
            b>>=1;//右移 相当于除以2
        }
        return res;
    }
}
