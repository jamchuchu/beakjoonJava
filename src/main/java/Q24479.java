import java.io.*;
import java.util.*;

public class Q24479 {
    static List<List<Integer>> graph;
    static List<Integer> v;
    static List<Integer> que;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = sc.readLine().split(" ");
        int num = Integer.parseInt(str[0]);
        int lineNum = Integer.parseInt(str[1]);
        int start = Integer.parseInt(str[2])-1;
        graph = new ArrayList<>();
        v = new ArrayList<>();


        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
            v.add(0);
        }

        for (int i = 0; i < lineNum; i++) {
            str = sc.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        dfs(start);

        for(int i = 0; i< num; i++){
            System.out.println(v.get(i));
        }

    }

    static void dfs(int a) {

        if (v.get(a) != 0) {
            return;
        }

        count++;

        v.set(a, count);

        Collections.sort(graph.get(a));

        for (int i = 0; i < graph.get(a).size(); i++) {
            dfs(graph.get(a).get(i));
        }

    }
}
