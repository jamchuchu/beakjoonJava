import java.io.*;
import java.util.Arrays;

public class Q9465 {

    static int  t , n;
    static int[][] nums, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(reader.readLine());
        while(t != 0) {
            t--;
            n = Integer.parseInt(reader.readLine());
            nums = new int[2][n];
            answer = new int[2][n];
            nums[0] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nums[1] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            answer[0][0] = nums[0][0];
            answer[1][0] = nums[1][0];

            if (n > 1) {
                answer[0][1] = nums[1][0] + nums[0][1];
                answer[1][1] = nums[0][0] + nums[1][1];
            }

            System.out.println();
            for (int i = 2; i < n; i++) {
                answer[0][i] = Math.max(answer[1][i-1], answer[1][i-2]) + nums[0][i];
                answer[1][i] = Math.max(answer[0][i-1], answer[0][i-2]) + nums[1][i];
            }





//        for(int i = 0 ; i < 2 ;i++){
//            for(int j = 0 ; j < n; j++){
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

            writer.write(Math.max(answer[0][n-1], answer[1][n - 1]) + "\n");
        }
        writer.flush();
        writer.close();
    }



}
