import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q10868 {
    /*
    * 한꺼번에 넣으면? 공백을 기준으로 그냥 넣자
    * 글자수 기준으로 합을 list에 저장 해놓자
    * string a
    * 최소 힙만 넣으면?
    * */

    static int n ,m;
    static int[] dp;
    static String strs = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            String s = reader.readLine();
            dp[i] = dp[i-1] + s.length() + 1;
            strs += s + " ";
        }

        for(int i = 0 ; i< m ; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            pq.addAll(Arrays.stream(strs.substring(dp[a-1] , dp[b]).split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            System.out.println(pq.peek());
        }
    }

}
