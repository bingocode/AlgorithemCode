package dp;

import java.util.Scanner;

/**
 * 三角数塔路径问题
 * 一个高度为N的由正整数组成的三角形，从上走到下，每次只能走到下一层相邻的数上,求经过的数字和的最大值
 * 5
 * 8 4
 * 3 6 9
 * 7 2 9 5
 *
 * 到第i+1行第j+1列的路径和最大值：F(i,j) = max(F(i-1,j-1), F(i-1,j)) + Aij;
 */
public class NumTower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        int[][] array = new int[n][n];
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        System.out.println(fun(array));
    }

    public static int fun(int[][] a) {
        int max = 0;
        int n = a.length;
        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0];
        max = dp[0][0];
        for(int i = 1; i< n; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) { // 最左边的f(i,j)
                    dp[i][j] = dp[i-1][j] + a[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + a[i][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return  max;
    }
}
