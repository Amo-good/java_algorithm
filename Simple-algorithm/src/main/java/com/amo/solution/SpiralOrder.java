package com.amo.solution;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    //从左向右、从上向下、从右向左、从下向上” 四个方向循环
    public int[] spiralOrder(int[][] matrix) {
        //矩阵为空，返回空数组
        if (matrix.length==0) return new int[0];
        //定义各个边界
        int l=0,r=matrix[0].length-1,t=0,b= matrix.length-1,x=0;
        //定义结果集
        int []res=new int[(r+1)*(b+1)];
        //遍历各个边界
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;//判断走完循环是否到底
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;//右边界缩减
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;//底边界上升
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;//左边界缩减
        }
        return res;
    }
}
