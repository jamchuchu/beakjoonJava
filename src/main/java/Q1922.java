import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1922 {

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n,m,answer;
    static boolean[] v;
    static List<List<Edge>> g = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        for(int i = 0 ;i<= n; i++){
            g.add(new ArrayList<>());
        }
        v = new boolean[n+1];

        for(int i = 0 ; i< m; i++){
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            g.get(a).add(new Edge(b,c));
            g.get(b).add(new Edge(a,c));
        }

        dijk(1);

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void dijk(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(!v[now.to]) {
                v[now.to] = true;
                answer += now.cost;
                pq.addAll(g.get(now.to));
            }
        }
    }
}
