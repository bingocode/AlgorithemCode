package dp;

import java.util.Scanner;

/**
 * 最长回文子串
 * 状态定义：F(i,j) 从a[i]到a[j]是否构成回文子串
 * 状态转移：F(i,j) = {
 *     true  i==j;
 *     a[i] == a[j]  i + 1 = j;
 *     a[i] == a[j] && F(i+1,j-1)  i +1 < j
 * }
 * https://blog.csdn.net/shineboyxxb/article/details/52079360
 */
public class LhsSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();
        char[] a = a1.toCharArray();
        int len = a.length;
        boolean[][] dp = new boolean[len][len];
        int ans = 1;
        /*
        初始化
         */
        for (int i = 0; i < len; i++ ){
            dp[i][i] = true;  //一个字符可以构成 i == j

            if(i < len -1){
                if(a[i] == a[i + 1]){ // 两个连续字符并且相等也可以 i + 1 = j
                    dp[i][i+1] = true;
                    ans = 2;
                }
            }
        }

        for(int l = 3; l <= len; l++){ //三个字符以上
            for(int i = 0; i + l -1 <len; i++){
                int j = i + l -1;
                if(a[i] == a[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    ans = l;
                }
            }
        }
        System.out.println(ans);
    }

}
