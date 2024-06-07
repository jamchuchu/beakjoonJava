import java.io.*;

public class Q9935B {
    static String a, b;
    static int bLeng;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        a = reader.readLine();
        b = reader.readLine();
        bLeng = b.length();

        StringBuilder sb = new StringBuilder(a);

        int index;
        while ((index = sb.indexOf(b)) != -1) {
            sb.delete(index, index + bLeng);
        }

        String result = sb.toString();
        writer.write(result.isEmpty() ? "FRULA" : result);
        writer.flush();
        writer.close();
    }
}
