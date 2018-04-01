package dp;

import java.util.Scanner;

/**
 * 编辑距离
 * 是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * 状态定义：F(i,j):第一个字符串前i个字符到第二个字符串前j个字母需要编辑到次数
 * 状态转移方程：
 * F(i,j) = F(i-1,j-1) a[i] == b[j];
 * F(i,j) = 1 + Math.min(F(i-1,j),F(i,j-1),F(i-1,j-1)); a[i] != b[j];
 *
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        fun(a, b);
    }

    public static int fun(String a, String  b) {
        int d = 0;
        if(a == null || b == null) return  d;
        if(a.length() == 0) return b.length();
        if(b.length() == 0) return  a.length();
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 0; i< m+1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i < n+1; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(a.charAt(i-1) == a.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        d = dp[m][n];
        return  d;
    }
}
