import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q1238 {

    /*
    * 원래 출발 1,2,3,4 -> x
    * 하나씩 구해보려고 했는데 생각해보니
    * 역방향으로 구해서 답구하는게 빠를 것 같다
    * x에서 출발 1,2,3,4

     *21812	264
    * */

    static int n,m,x,answer;
    static List<List<Edge>> go = new ArrayList<>();
    static List<List<Edge>> back = new ArrayList<>();

    static class Edge{
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        x = Integer.parseInt(str[2]);

        for(int i = 0 ; i<= n; i++){
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            go.get(nums[1]).add(new Edge(nums[0], nums[2]));
            back.get(nums[0]).add(new Edge(nums[1], nums[2]));
        }

        int[] goDist = dijk(x, new int[n+1], go);
        int[] backDist = dijk(x, new int[n+1], back);

        for(int i = 1 ; i <= n; i++){
            answer = Math.max(answer, goDist[i] + backDist[i]);
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static int[] dijk(int start, int[] dist, List<List<Edge>> list){
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge pre = pq.poll();
            if(dist[pre.to] < pre.dist){
                continue;
            }
            for(Edge now : list.get(pre.to)){
//                for (int i = 1; i <= n ;i++){
//                    System.out.print(dist[i] + " ");
//                }
//                System.out.println();
                if(dist[now.to] > dist[pre.to] + now.dist){
                    dist[now.to] = dist[pre.to] + now.dist;
                    pq.add(new Edge(now.to, dist[now.to]));
                }
            }
        }
        return dist;
    }
}
