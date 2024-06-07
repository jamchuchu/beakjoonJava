import java.io.*;

public class Q15829B {


    static int n;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        str = reader.readLine();
        int m = Integer.parseInt("1234567891");
        int answer = (int) str.charAt(0) - 96;
        int b = 1;


        for(int i = 1 ; i< n; i++) {
            int a = (int) str.charAt(i) - 96;
            b = (b * 31);
            answer += ( a * b ) % m;
        }

        System.out.println(answer);






        writer.flush();
        writer.close();
    }
}
