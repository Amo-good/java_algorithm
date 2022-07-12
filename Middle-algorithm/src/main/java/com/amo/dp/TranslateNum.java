package com.amo.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNum {
    public int translateNum(int num) {
        // 类似爬楼梯 设当前数字总共的翻译方法为f(i)
        // 当前数字i如果能与前面i-1组成10-25的数字则方法有f(i-1)+f(i-2) 不能则为f(i-1)
        String s = String.valueOf(num);
        if (s.length()<2)return s.length();//如果只有一位数则返回当前数
        //dp[i]表示第1位数
        int []dp=new int[s.length()+1];
        dp[0]=1;//dp[0]由dp[2]推算而来，如果数字为12  则dp[2]=dp[1]+dp[0] 而dp[1]=1，则dp[0]=1
        dp[1]=1;//第一位数肯定只有一位数
        for (int i = 2; i <=s.length() ; i++) {
            String s1 = s.substring(i - 2, i);//[0,2) 也就是提取出当前位和前一位的数字
            if (s1.compareTo("10")>=0&&s1.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
