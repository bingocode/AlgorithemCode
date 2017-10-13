package dp;

/**
 * Created by admin on 2017/9/21.
 */

import java.util.Scanner;

/**
 * 最长公共子序列
 *
 */
public class LcsSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();
        String b1 = sc.nextLine();
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <lenA; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < lenB; j++){
            dp[0][j] = 0;
        }
        for (int i = 0 ;i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                if(a[i] == b[j]){
                    dp[i+1][j+1] = dp[i ][j] +1;
                }
                else {
                    dp[i+1][j+1] = max(dp[i +1][j],dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[lenA][lenB]);
    }
    public static int max(int a, int b){
        return a > b? a: b;
    }

}
