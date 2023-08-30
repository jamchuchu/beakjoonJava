import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(sc.readLine());
        int[][] work = new int[num][2];
        int[] dp = new int[num+1];


        for(int i =0; i< num; i++){
            String[] str = sc.readLine().split(" ");
            work[i][0] = Integer.parseInt(str[0]);
            work[i][1] = Integer.parseInt(str[1]);
        }
        for(int i =0; i< num; i++){
            if(i+work[i][0]< num+1) {
                dp[i + work[i][0]] = Math.max(dp[i + work[i][0] - 1], dp[i] + work[i][1]);
            }
        }


        for(int i =1; i< num+1; i++){
            System.out.println(dp[i] + " ");
        }

        System.out.println(dp[num]);
    }

}
