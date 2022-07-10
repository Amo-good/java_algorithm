package com.amo.dp;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fip {
    /**
     * 状态定义：设 dp为一维数组，其中dp[i]的值代表斐波那契数列第i个数字 。
     * 转移方程：dp[i + 1] = dp[i] + dp[i - 1]dp[i+1]=dp[i]+dp[i−1] ，
     * 即对应数列定义 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1) ；
     * 初始状态：dp[0]=0,dp[1]=1，即初始化前两个数字；
     * 返回值：dp[n]，即斐波那契数列的第 n个数字。
     */
    public int fib(int n) {
        //利用动态规划算法
        //a代表dp[0] b代表dp[1] sum辅助ab交替前进
        int a=0,b=1,sum;
        for (int i = 0; i <n; i++) {
            sum=(a+b)%1000000007;//取模运算
            a=b;  //代表dp[n]
            b=sum;
        }
        return a;
   }


  /* 递归算法超时
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }*/
}
