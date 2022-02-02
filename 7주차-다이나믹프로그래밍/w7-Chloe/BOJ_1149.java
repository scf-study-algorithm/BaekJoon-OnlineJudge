package BOJ;
//https://www.acmicpc.net/problem/1149
import java.util.*;

public class BOJ_1149 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] dp = new int[N+1][3];

        for(int i=1; i<=N; i++){
            int R = in.nextInt();
            int G = in.nextInt();
            int B = in.nextInt();

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
        }
    System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

    }
}
