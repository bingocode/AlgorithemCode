package dp;

import java.util.Scanner;

/**
 * Created by admin on 2017/9/21.
 */

/**
 * 求最大连续子数列和
 */
public class MaxSeq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(maxseq(a));
    }

    public static int maxseq(int[] a) {
        int len = a.length;
        int[] dp = new int[len];
        dp[0] = a[0];
        for (int i = 1; i < len; i++) {
            dp[i] = max(dp[i -1]+a[i],a[i]);
        }
        int k =0;
        for(int i = 0;i< len;i++){
            if(dp[k] < dp [i])
                k = i;
        }
        return dp[k];
    }

    public static int max(int a, int b){
        return a > b? a: b;
    }
}
