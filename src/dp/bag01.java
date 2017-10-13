package dp;

/**
 * Created by admin on 2017/9/22.
 */

import java.util.Scanner;

/**
 * 01背包问题，有n件物品，每件物品重w[i]，价值c[i]，但背包容量为V，其中每种物品只有一件，如何选取物品放入背包使得总价值最大。
 */
public class bag01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] w = new int[n+1];
        int[] c = new int[n+1];
        int[] dp = new int[V+1];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        //边界
        for(int v =0; v <=V; v++){
            dp[v] = 0;
        }

        for(int i = 1; i <=n; i++){
            for(int v= V; v >= w[i]; v--){
                dp[v] = max(dp[v],dp[v- w[i]] + c[i]);
            }
        }

        int max = 0;
        for(int v = 0; v <= V; v++){
            System.out.print(dp[v] +" ");
            if(dp[v] > max){
                max = dp[v];
            }
        }
        System.out.println(max);
    }
    public static int max(int a, int b){
        return a > b? a: b;
    }

}
