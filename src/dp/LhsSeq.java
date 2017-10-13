package dp;

import java.util.Scanner;

/**
 * Created by admin on 2017/9/22.
 */

/**
 * 最长回文子串
 */
public class LhsSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();
        char[] a = a1.toCharArray();
        int len = a.length;
        int[][] dp = new int[len][len];
        int ans = 1;
        for (int i = 0; i < len; i++ ){
            dp[i][i] = 1;
            if(i < len -1){
                if(a[i] == a[i + 1]){
                    dp[i][i+1] = 1;
                    ans = 2;
                }
            }
        }
        for(int l = 3; l <= len; l++){
            for(int i = 0; i + l -1 <len; i++){
                int j = i + l -1;
                if(a[i] == a[j] && dp[i + 1][j - 1] ==1){
                    dp[i][j] = 1;
                    ans = l;
                }
            }
        }
        System.out.println(ans);
    }

}
