import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q1706A {
    static int n, m;
    static String[][] map;
    static PriorityQueue<String> words = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            str = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
            }
        }

        for (int i = 0; i < n; i++){
            String[] temp = Arrays.stream(map[i]).collect(Collectors.joining()).split("#");
            words.addAll(
                    Arrays.stream(temp)
                    .filter(s -> s.length() > 1)
                    .collect(Collectors.toList()));
        }
        for (int i = 0; i < m; i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(map[j][i]);
            }
            String[] temp1 = temp.stream().collect(Collectors.joining()).split("#");
            words.addAll(
                    Arrays.stream(temp1)
                            .filter(s -> s.length() > 1)
                            .collect(Collectors.toList()));
        }

        System.out.println(words.poll());



    }
}
