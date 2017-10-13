
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[m+1][n];
        dp[0][0] = 1;
        for(int i = 1; i <=m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = dp[i-1][(j-1+n)%n] + dp[i-1][(j+1)%n];
            }

        }
        System.out.print(dp[m][0]);


    }
}