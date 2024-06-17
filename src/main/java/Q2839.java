import java.io.*;
import java.util.Arrays;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        if(n <= 2) {
            writer.write(-1);
        }else if(n == 3){
            writer.write(1);
        }else if(n == 4){
            writer.write(-1);
        }else{
            int[] answer = new int[n + 1];
            Arrays.fill(answer, 5000);
            answer[3] = 1;
            answer[5] = 1;
            for (int i = 6; i <= n; i++) {
                if (answer[i - 3] == 5000 && answer[i - 5] == 5000) {
                    continue;
                }
                answer[i] = Math.min(answer[i - 3], answer[i - 5]) + 1;
            }

            writer.write(answer[n] == 5000 ? -1 + " " : answer[n] + " ");
        }
        writer.flush();
        writer.close();
    }
}
