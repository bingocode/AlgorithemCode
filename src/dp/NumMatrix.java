package dp;
/**
 * 矩阵取数问题
 * 一个M*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，
 * 从左上走到右下，只能向下向右走，求能够获得的最大价值
 * 1 3 3
 * 2 1 3
 * 2 2 1
 *解题思想：https://blog.csdn.net/lz161530245/article/details/76794904
 * 状态定义：F(i,j) ：走到第i行第j列时的获得收益最大值
 * 状态转移方程：F(i,j): {
 *     Integer.MIN  i == 0 || j == 0
 *     a[1][1]  i == 1 && j == 1
 *     a[i][j] + Math.max(F(i-1,j), F(i,j-1))  其他
 * }
 */
public class NumMatrix {
    public static int fun(int[][] a) {
        int rst = 0;
        if(a == null || a.length == 0) {
            return rst;
        }
        int m = a.length;
        int n = a[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for(int j = 0; j <=n; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j],dp[i][j-1])) + a[i-1][j-1];
            }
        }
        rst = dp[m][n];
        return rst;
    }
}
