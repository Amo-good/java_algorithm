package com.amo.dp;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        /**
         * 状态转移方程
         * dp[i][j]={ grid[i][j] ,i=0,j=0
         *            grid[i][j]+dp[i][j-1] i=0,j≠0
         *            grid[i][j]+dp[i-1][j] i≠0,j=0
         *            grid[i][j]+max(dp[i-1][j],dp[i][j-1]) i≠0,j≠0
         */
        int n= grid.length;
        int m=grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                //分别记录每个dp的值
                if (i==0&&j==0) continue;//i=0,j=0
                if (i==0) grid[i][j]=grid[i][j-1]+grid[i][j];//i=0,j≠0
                else if (j==0) grid[i][j]=grid[i-1][j]+grid[i][j];//i≠0,j=0
                else grid[i][j]=Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        //返回终点的值
        return grid[n-1][m-1];
    }
}
