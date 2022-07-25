package com.amo.math;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class ConstructArr {
    /**
     * 初始化：数组B其中B[0]=1 ；辅助变量tmp=1 ；
     * 计算 B[i]的下三角各元素的乘积，直接乘入 B[i]；
     * 计算 B[i]的上三角各元素的乘积，记为tmp ，并乘入 B[i]；
     * 返回 B。
     */
    public int[] constructArr(int[] a) {
        int len=a.length;
        if(len == 0) return new int[0];
        int []b=new int[len];
        b[0]=1; //初始化b[0]
        for (int i = 1; i <len; i++) {
            b[i]=b[i-1]*a[i-1];//计算下三角  如：b[2]=a[1]*b[1]
        }
        int tmp=1;//辅助变量
        for (int i = len-2; i >=0 ; i--) {
            tmp *= a[i + 1];//tmp每次计算完都保存着上一次的结果
            b[i] *= tmp; //计算上三角
        }
        return b;
    }
}
