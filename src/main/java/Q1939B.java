import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1939B {

    static class Bridge{
        int to;
        int weight;

        public Bridge(int end, int weight) {
            this.to = end;
            this.weight = weight;
        }
    }

    static List<List<Q1939.Bridge>> g =new ArrayList<>();
    static int n,m;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        answer = new int[n+1];


        for(int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[0])).add(new Q1939.Bridge(Integer.parseInt(str[1]), new BigInteger(str[2])));
            g.get(Integer.parseInt(str[1])).add(new Q1939.Bridge(Integer.parseInt(str[0]), new BigInteger(str[2])));
        }

        Arrays.fill(answer, Integer.MAX_VALUE);

        str = reader.readLine().split(" ");
        bfs(Integer.parseInt(str[0]));
//
//        for(int i = 1 ; i <= n ; i++){
//            System.out.print(answer[i] + " ");
//        }
//        System.out.println();

        writer.write(answer[Integer.parseInt(str[1])] + " ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start) {
        ArrayDeque<Bridge> deq = new ArrayDeque<>();
        deq.add(new Bridge(start, 0));
        answer[start] = 0;

        while (!deq.isEmpty()) {
            Bridge pre = deq.poll();//출발
            for (Q1939.Bridge now : g.get(pre.to)) {
//                if(answer[now.to] < now.weight){
//                    continue;
//                }

            }
        }
    }
}
