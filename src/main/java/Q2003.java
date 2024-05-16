import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2003 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = num1[0];
        m = num1[1];
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int[] numsPlus = new int[n];

        numsPlus[0] = nums[0];
        if(nums[0] == m){
            count++;
        }

        for(int i = 1 ; i< n ; i++){
            numsPlus[i] = numsPlus[i-1] + nums[i];
            if(numsPlus[i] == m){
                count++;
            }
        }

        int time = 0;
        while(time != n) {
            for (int i = 0; i < time; i++) {
            }
            for (int i = time; i < n; i++) {
                numsPlus[i] = numsPlus[i] - nums[time];
                if (numsPlus[i] == m) {
                    count++;
                }
            }
            time++;
        }

        System.out.println(count);
    }
}
