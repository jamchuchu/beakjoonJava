import java.io.*;

public class Q11561 {

    /* 이하 idx 찾기  -> upperbound -1 */

    static int k;
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        k =  Integer.parseInt(reader.readLine());
        for(int i = 0; i < k; i++) {
            n = Long.parseLong(reader.readLine());
            writer.write((long)Math.floor(Math.sqrt(2*n + 0.25) - 0.5) + "\n");
        }
        writer.flush();
        writer.close();
    }
}
