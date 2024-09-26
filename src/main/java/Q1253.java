import java.io.*;
import java.util.Arrays;

public class Q1253 {
    static int n, answer;
    static int[] nums;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = new boolean[n];

        for(int i = 0; i< n; i++){
            for(int j = i+1 ; j < n ; j++){

            }
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }



}
