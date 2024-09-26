import java.io.*;

public class Q1085 {
    static int a,b,c,d, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);
        d = Integer.parseInt(str[3]);

        int e = c-a;
        int f = d-b;

        answer =Math.min(Math.min(a,b), Math.min(e,f));

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
