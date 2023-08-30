import java.util.Scanner;

public class Q20500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] dp =  new int[num+1][3];
        dp[1][1] = 1;


        for(int i = 2; i< num+1; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2])%1000000007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])%1000000007;
            dp[i][2] =( dp[i - 1][0] + dp[i - 1][1])%1000000007;
        }

        System.out.println(dp[num][0]);
    }
}
