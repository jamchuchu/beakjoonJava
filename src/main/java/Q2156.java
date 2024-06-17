import java.io.*;

public class Q2156 {
    static int n;
    static int[] wines, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        wines = new int[n+1];
        answer = new int[n+1];
        for(int i = 1; i <= n; i++){
            wines[i] = Integer.parseInt(reader.readLine());
        }

        if(n == 1) {
            answer[1] = wines[1];
        }else if(n == 2){
            answer[2] = wines[2] + wines[1];
        }else{
            answer[1] = wines[1];
            answer[2] = wines[2] + wines[1];
            for (int i = 3; i <= n; i++) {
                int a = answer[i - 3] + wines[i - 1] + wines[i];
                int b = answer[i - 2] + wines[i];
                int c = answer[i - 1];
                answer[i] = Math.max(Math.max(a, b), c);
            }
        }

        writer.write(answer[n]+" ");
        writer.flush();
        writer.close();
    }
}
