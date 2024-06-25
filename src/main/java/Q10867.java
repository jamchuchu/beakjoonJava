import java.io.*;
import java.util.Arrays;

public class Q10867 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).distinct().sorted()
                .forEach(i -> System.out.print(i + " "));
    }

}
