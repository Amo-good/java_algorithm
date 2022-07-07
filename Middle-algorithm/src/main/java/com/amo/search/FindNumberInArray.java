package com.amo.search;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 */
public class FindNumberInArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int []arr=matrix[i];
           if (search(arr,target)){
               return true;
           }
        }
        return false;
    }

    public boolean search(int [] arr,int target){
        int begin=0;
        int end= arr.length-1;
        while (begin<=end){
            int mid=(begin+end)/2;
            if (arr[mid]==target)return true;
            else if (arr[mid]>target) end=mid-1;
            else begin=mid+1;
        }
        return false;
    }
    //利用旋转矩阵，选择后，在矩阵左边的都小于根节点元素（同理右边大于）
    /*public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //定最下方的为标志点
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }*/


}
