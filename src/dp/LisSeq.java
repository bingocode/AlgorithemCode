package dp;

/**
 * Created by admin on 2017/9/21.
 */

import java.util.Scanner;

/**
 * 最长不下降子序列（可以不连续）,如1 2 3 -1 -2 7 9 的是1 2 3 7 9
 */
public class LisSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len+1];
        for (int i = 1; i <=len; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(lisseq(a));
    }

    public static int lisseq(int[] a){
        int len = a.length -1;
        int[] dp = new int[len + 1];
        int ans = -1;
        for(int i = 1; i<=len; i++){
            dp[i] = 1;
            for(int j = 1; j< i; j++){
                if(a[i] >= a[j] && dp[j] + 1 > dp[i] ){
                    dp[i] = dp[j] + 1;
                }
            }
            ans = max(ans ,dp[i]);
        }
        return ans;
    }

    public static int max(int a, int b){
        return a > b? a: b;
    }

}
