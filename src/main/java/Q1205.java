import java.io.*;
import java.util.Arrays;

public class Q1205 {
    static int answer, n, score, p;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        score = Integer.parseInt(str[1]);
        p = Integer.parseInt(str[2]);

        int[] scores = new int[n];

        if (n == 0) {
            answer = 1;
        } else {
            scores[0] = 1;
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int rank = 2;
            for (int i = 1; i < n; i++) {
                if (s[i] < s[i - 1]) {
                    scores[i] = i + 1;
                    rank = i + 1;
                } else {
                    scores[i] = rank;
                }

                if(scores[i] > p){
                    answer = -1;
                    break;
                }

                if (s[i] <= score) {
                    answer = scores[i];
                    break;
                }
            }



//
//        for(int i = 0 ; i < n; i++){
//            System.out.print(scores[i] + " ");
//        }

        }
        writer.write(answer + " ");
        writer.flush();
        writer.close();

    }
}
