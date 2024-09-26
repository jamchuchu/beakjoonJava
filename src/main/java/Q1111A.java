import java.io.*;
import java.util.Arrays;

public class Q1111A {

    static int n, a, b;
    static int[] nums;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(n >= 3){
            int temp1 = nums[1] - nums[2];
            int temp2 = nums[0] - nums[1];

            if(temp2 == 0){
                answer = String.valueOf(nums[0]);
                a = 1;
                b = 0;
            }else if(temp1 == 0){
                answer = String.valueOf(nums[1]);
                a = 0;
                b = nums[1];
            }else {
                if (Math.abs(temp1) >= Math.abs(temp2)) {
                    a = temp1 / temp2;
                    b = nums[1] - (a * nums[0]);
                    answer = String.valueOf(a * nums[n - 1] + b);
                } else {
                    answer = "B";
                }
            }

            for(int i = 1; i < n; i++){
                if(nums[i] != nums[i-1] * a + b){
                    answer = "B";
                    break;
                }
            }
        }else if(n == 1){
            answer = "A";
        }else if(n == 2){
            if(nums[0] == nums[1]){
                answer = String.valueOf(nums[1]);
            }else{
                answer = "A";
            }
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
