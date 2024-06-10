import java.io.*;
import java.util.Arrays;

public class Q3649 {

    static String str = "";
    static int n, x, l1, l2;
    static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while ((str = reader.readLine()) != null) {
            x = Integer.parseInt(str) * 10000000;
            n = Integer.parseInt(reader.readLine());
            targets = new int[n];

            for (int i = 0; i < n; i++) {
                targets[i] = Integer.parseInt(reader.readLine());
            }
            Arrays.sort(targets);

            boolean flag = false;
            int start = 0;
            int end = n - 1;
            while (start < end) {
                if( targets[start] + targets[end] == x){
                    l1 = targets[start];
                    l2 = targets[end];
                    flag = true;
                    break;
                }
                if (targets[start] + targets[end] > x) {
                    end--;
                } else if (targets[start] + targets[end] < x) {
                    start++;
                }
            }

            writer.write(flag ? "yes " + l1 + " " + l2 + "\n" : "danger\n");
            writer.flush();
        }
    }

}
