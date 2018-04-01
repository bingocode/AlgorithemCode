package dp;

/**
 * Created by admin on 2017/9/21.
 */

import java.util.Scanner;

/**
 * (最长递增子序列)
 * 最长不下降子序列（可以不连续）,如1 2 3 -1 -2 7 9 的是1 2 3 7 9
 * 状态定义：F(i) :以a[i]结尾的子序列中最大递增子序列的长度
 * 状态转移方程：
 * F(i) = Max(F(j)) + 1  a[i] >= a[j] && 0 <= j < i
 *
 * 思想：
 * 需要先求出序列Ai-1{a1,a2,……,ai-1}中以各元素(a1,a2,……,ai-1)作为最大元素的最长递增序列，
 * 然后把所有这些递增序列与ai比较，
 * 如果某个长度为m序列的末尾元素aj(j<i)比ai要小，
 * 则将元素ai加入这个递增子序列，得到一个新的长度为m+1的新序列，
 * 否则其长度不变，将处理后的所有i个序列的长度进行比较，其中最长的序列就是所求的最长递增子序列。
 * https://www.jianshu.com/p/ae71823744b3
 */
public class LongestUpSeq {
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
