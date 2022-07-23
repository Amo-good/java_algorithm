package com.amo.solution;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Add {
    //无进位和与异或运算规律相同，进位和与运算规律相同（并需左移一位）。
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a=a^b; // a = 非进位和         异或可以把所有非进位的值求出来
            b = c; // b = 进位
        }
        return a;
    }
}
