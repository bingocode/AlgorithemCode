package dp;

/**
 * Created by admin on 2017/9/22.
 */

import java.util.Scanner;

/**
 * 01背包问题，有n件物品，每件物品重w[i]，价值v[i]，但背包容量为W，其中每种物品只有一件，如何选取物品放入背包使得总价值最大。
 * 状态定义；F(i,j) : 对于前i件物品（包括i），背包剩余容量为j时，所取得的最大价值
 * 状态转移：F(i,j) = Math.max{ F(i-1,j) , v[i] + F(i-1,j-w[i]) } (是否选择第i个物品)
 *
 * 降维实现：一维数组实现思想：
 * 背包容量要采用倒序： F(j) = Max( F(j) , v[i] + F(j-w[i]) )
 *
 */
public class bag01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[] dp = new int[W+1];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        //边界
        for(int i =0; i <=W; i++){
            dp[i] = 0;
        }

        for(int i = 1; i <=n; i++){
            for(int j= W; j >= w[i]; j--){
                dp[j] = max(dp[j],dp[j- w[i]] + v[i]);
            }
        }

        int max = 0;
        for(int j = 0; j <= W; j++){
            System.out.print(dp[j] +" ");
            if(dp[j] > max){
                max = dp[j];
            }
        }
        System.out.println(max);
    }
    public static int max(int a, int b){
        return a > b? a: b;
    }

}
