package com.amo.dp;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 */
public class CuttingRope {
    /**
     * 最优：3。把绳子尽可能切为多个长度为 3的片段，留下的最后一段绳子的长度可能为0,1,2 三种情况。
     * 次优：2 。若最后一段绳子长度为 2；则保留，不再拆为 1+1 。
     * 最差：1 。若最后一段绳子长度为 1；则应把一份3+1 替换为2+2，因为2×2>3×1。
     *
     */
    public int cuttingRope(int n) {
        if (n<=3) return n-1;//按理n小于等于3应该不切割，但题目要求必须切割 则将2切成1×1 3切成2×1
        //尽可能将绳子以长度3等分为多段时，乘积最大
        int b=n/3,a=n%3;
        if (a==0){
            return (int)Math.pow(3, b);//说明被划分成长度为3的多段
        }else if (a==2){
            //保留2 不做拆分
            return (int)Math.pow(3, b)*2;
        }
        else {
            //a==1时，此时拿出一个3 将其划分为2*2
            return (int)Math.pow(3, b-1)*2*2;
        }
    }
}