import java.io.*;
import java.util.Arrays;

public class Q18870A {

    static int n;
    static int[] map, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        map = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        answer = new int[n];

        for(int i = 0; i < n; i++) {
            int num = map[i];
            writer.write((int) Arrays.stream(map).filter(j -> j < num).count() + " ");
        }

        writer.flush();
        writer.close();
    }




}
