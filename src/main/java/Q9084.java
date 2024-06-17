import java.io.*;
import java.util.Arrays;

public class Q9084 {
    static int t, n, m;
    static int[] values, valuesCount, answers;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

//        t = Integer.parseInt(reader.readLine());
        n = Integer.parseInt(reader.readLine());
        values = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        valuesCount = new int[n+1];
        m = Integer.parseInt(reader.readLine());
        answers = new int[m+1];




        for(int i = 1 ; i< m; i++){
            System.out.print(answers[i] + " ");
        }


//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void dfs(){

    }


}
