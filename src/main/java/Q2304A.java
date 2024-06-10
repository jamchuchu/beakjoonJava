import java.io.*;
import java.util.*;

public class Q2304A {

    static int n, maxHeight, maxStart, maxEnd;
    static List<Graph> list = new ArrayList<>();
    static ArrayDeque<Graph> g = new ArrayDeque<>();

    static class Graph{
        int idx;
        int height;

        public Graph(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            int idx = Integer.parseInt(str[0]);
            int height = Integer.parseInt(str[1]);
            list.add(new Graph(idx, height));
        }

        Collections.sort(list, (o1, o2) -> o1.idx - o2.idx);
        g = new ArrayDeque<>(list);


        while(!g.isEmpty()) {
            Graph now = g.poll();
            int idx = now.idx;
            int height = now.height;
            list.add(new Graph(idx, height));
            if (maxHeight < height) {
                maxHeight = height;
                maxStart = idx;
                maxEnd = idx;
            } else if (maxHeight == height) {
                maxEnd = idx;
            }
        }

        g = new ArrayDeque<>(list);

        int answer = 0;
        Graph pre = new Graph(0, 0);
        while (!g.isEmpty()) {
            Graph now = g.poll();
            if (now.height > pre.height) {
                answer += pre.height * (now.idx - pre.idx);
                pre = now;
            }
        }

        g = new ArrayDeque<>(list);
        pre = new Graph(g.peekLast().idx, 0);
        while (!g.isEmpty()) {
            Graph now = g.pollLast();
            if (now.height > pre.height) {
                answer += pre.height * (pre.idx - now.idx);
                pre = now;
            }
        }

        answer += (maxEnd - maxStart + 1) * maxHeight;



        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }



}
