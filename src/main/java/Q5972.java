import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q5972 {
    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m;
    static int[] cost;
    static List<List<Edge>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i= 0 ; i <= n; i++){
            g.add(new ArrayList<>());
        }
        for(int i = 0 ; i< m; i++){
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            g.get(nums[0]).add(new Edge(nums[1], nums[2]));
            g.get(nums[1]).add(new Edge(nums[0], nums[2]));
        }

        dijk();

        writer.write(cost[n]+" ");
        writer.flush();
        writer.close();
    }
    static void dijk(){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(1, 0));
        cost[1] = 0;

        while(!pq.isEmpty()){
            Edge pre = pq.poll();
            if(cost[pre.to] < pre.cost){
                continue;
            }
            for(Edge now: g.get(pre.to)){
                if(cost[now.to] > cost[pre.to] + now.cost){
                    cost[now.to] = cost[pre.to] + now.cost;
                    pq.add(new Edge(now.to, cost[now.to]));
                }
            }
        }
    }
}
