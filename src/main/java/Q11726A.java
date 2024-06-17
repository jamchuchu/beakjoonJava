import java.io.*;

public class Q11726A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        long[] answer = new long[n+1];
        answer[1] = 1;
        answer[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            answer[i] = (answer[i-1] + answer[i-2])% 10007;
        }

        writer.write(answer[n] % 10007 + " ");
        writer.flush();
        writer.close();
    }

}
