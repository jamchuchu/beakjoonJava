import java.util.*;

public class Q2331 {
    public static void main(String[] args) {

        int[] dp = new int[100];
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int p = sc.nextInt();
        List<Integer> list  = new ArrayList<>();

        dp[0] = start;
        list.add(dp[0]);

        for(int j =1; j< 100; j++) {
            String[] temp = String.valueOf(dp[j-1]).split("");
            int tempInt = 0;

            for (int i = 0; i < temp.length; i++) {
                tempInt += Math.pow(Integer.parseInt(temp[i]), p);
            }
            dp[j] = tempInt;
            if(list.contains(dp[j])){
                System.out.println(list.indexOf(dp[j]));
                break;
            }else{
                list.add(dp[j]);
            }
        }

    }
}
