import java.util.Scanner;

public class Q2193 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Long[] dp = new Long[num];

        if(num > 0){
            dp[0] = Long.valueOf(1);
        }
        if(num > 1){
            dp[1] = Long.valueOf(1);
        }

        for(int i =2; i<num ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[num-1]);
    }
}
