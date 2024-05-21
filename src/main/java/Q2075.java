import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2075 {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) ->
                o2 - o1);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        list.sort((o1, o2) ->
                o2 -o1);


        System.out.println(list.get(n-1));
    }


}
