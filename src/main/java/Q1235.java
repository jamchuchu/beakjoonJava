import java.io.*;
import java.util.*;

public class Q1235 {
    static int n,answer;
    static String[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        students = new String[n];
        for(int i = 0 ; i < n; i++){
            students[i] = reader.readLine();
        }
        int length = students[0].length();

        for(int i = 1; i <= length; i++) {
            Set<String> set = new HashSet<>();
            for(String s: students) {
                set.add(s.substring(length -i, length));
            }
            if (set.size() == n) {
                answer = i;
                break;
            }
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }


}
