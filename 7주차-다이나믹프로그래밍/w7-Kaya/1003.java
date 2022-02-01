import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] dp = new int[41][2];
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[1][1] = 1;

        while(t>0) {
            int n = Integer.parseInt(br.readLine());

            for(int i=2; i<=n; i++){
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }

            System.out.printf("%d %d\n", dp[n][0], dp[n][1]);
            t--;
        }
    }
}

