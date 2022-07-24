package com.amo.solution;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量）。
 *
 *输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 *
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0){
            res+=n&1;//比较最后一位与1的值
            //每次右移一位
            n=n>>>1;//无符号右移
        }
        return res;
    }
}