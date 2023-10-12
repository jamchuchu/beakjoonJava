import java.io.*;
import java.util.*;

public class Q1325_2 {
    static List<Integer>[] graph;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int node = Integer.parseInt(str[0]);
        int edge = Integer.parseInt(str[1]);

        graph = new ArrayList[node+1];
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i< edge; i++){
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[b].add(a);
        }

        int[] answer = new int[node+1];
        for(int i = 1; i < node+1; i++){
            count = new int[node+1];
            Arrays.fill(count, -1);

            int max = 0;
            bfs(i);
            for(int j = 0; j< node+1; j++){
                max = Math.max(max,count[j]);
            }
            answer[i] = max;
        }
        int max = 0;
        for(int j = 0; j< node+1; j++){
            max = Math.max(max,answer[j]);
        }
        for(int j = 0; j< node+1; j++){
            if(answer[j] == max){
                writer.write(j+ " ");
            }
        }
        writer.flush();
    }

    static void bfs(int node){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(node);
        count[node]++;
        while(!Q.isEmpty()){
            int now = Q.poll();
            for(int i : graph[now]){
                if(count[i] == -1){
                    count[i] = count[now] + 1;
                    Q.add(i);
                }
            }
        }

    }
}
