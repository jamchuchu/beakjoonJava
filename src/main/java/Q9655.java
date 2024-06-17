import java.io.*;

public class Q9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        writer.write(n % 2 == 1 ? "SK" : "CY");
        writer.flush();
        writer.close();
    }
}
