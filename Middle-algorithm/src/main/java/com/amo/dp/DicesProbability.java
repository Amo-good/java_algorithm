package com.amo.dp;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 */
public class DicesProbability {
    public double[] dicesProbability(int n) {
        //dp表示出现的次数  dp[i][j] i表示投骰子的次数 j表示出现的点数
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;//只有一个骰子的时候，概率一样

        for(int i = 2; i <= n; i++)
            for(int j = i; j <= 6 * i; j++)
                //表示 当前点数的次数由投掷完 n-1枚骰子后，对应点数 j-1, j-2, j-3, ... , j-6出现的次数之和转化过来。
                for(int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i-1][j - k];

        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }
}
