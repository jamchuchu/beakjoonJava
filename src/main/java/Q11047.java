import java.io.*;

public class Q11047 {

    static int n,k;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        values = new int[n];

        for(int i = 0 ; i< n; i++){
            values[i] = Integer.parseInt(reader.readLine());
        }

        int q = 0;
        int r = k;
        for(int i = 0; i< n; i++){
            q += r / values[n-1-i];
            r = r % values[n-1-i];
        }

        writer.write(q+" ");
        writer.flush();
        writer.close();
    }
}
