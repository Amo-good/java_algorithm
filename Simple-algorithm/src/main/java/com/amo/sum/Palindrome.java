package com.amo.sum;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * 方法一
     * 反转数字
     */
    public static boolean isPalindrome(int x){
        if (x<0) return false;
        int y=0;//反转之后的数
        int z=x;
        while (z!=0){
            y*=10;
            y+=z%10;
            z=z/10;
        }
        return y == x;
    }
    /**
     * 方法二
     * 数字转换为字符串再判断
     */
    public static boolean isPalindromeString(int x){
        if (x<0) return false;
        StringBuilder stringBuilder=new StringBuilder(String.valueOf(x));
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
