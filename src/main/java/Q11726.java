import java.io.*;

public class Q11726 {
    static int answer;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= n ; i++){
            dp[i] = (dp[i-2] + dp[i-1])*2;
            System.out.println(dp[i]);
        }

        System.out.println(dp[n]);

//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
