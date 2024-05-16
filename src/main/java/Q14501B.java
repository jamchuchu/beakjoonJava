import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q14501B {
    static int n;
    static int[] day, pay;
    static List<List<Integer>> g = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        day = new int[n+1];
        pay = new int[n+1];


        for(int i = 1; i < n+1; i++) {
            String[] str = reader.readLine().split(" ");
            day[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }

        for(int i = 0; i < n+2; i++) {
            g.add(new ArrayList<>());
        }

        for(int i = 1; i < n+1; i++) {
            if(i + day[i] <= n+1){
                g.get(i + day[i]).add(i);
            }
        }

        int[] dp = new int[n+2];
        int max = 0;
        for(int i = 1; i <= n+1; i++) {
            for(int j : g.get(i)){
                dp[i] = Integer.max(dp[j] + pay[j], dp[i]); // 이전 합과 현재 값 더함
                max = Integer.max(max, dp[i]);
            }
            if(dp[i] < max){
                dp[i] = max;
            }
        }
            System.out.println(dp[n+1]);
    }

}
