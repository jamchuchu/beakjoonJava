import java.io.*;
import java.util.*;

public class Q1167 {
    static class Edge{
        int to, dist;
        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    static int answer, n;
    static List<List<Edge>> g = new ArrayList<>();
    static int[] dist;
    static int[][] distAll;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
//        dist = new int[n+1];
        distAll = new int[n+1][n+1];
        v = new boolean[n+1];
//        for(int i = 1 ; i<= n ; i++){
//            Arrays.fill(distAll[i], Integer.MAX_VALUE);
//        }
//        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0 ; i<= n ; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true){
                if(st.countTokens() == 1){
                    break;
                }
                int edge = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                g.get(node).add(new Edge(edge, d));
            }
        }

//        for(int i = 1 ; i <= n; i++){
////            Arrays.fill(dist, Integer.MAX_VALUE);
//            dijk(i);
//        }
//
//        for(int i = 1 ; i <= n; i++){
//            for(int j = 1 ; j <= n; j++){
//                System.out.print(distAll[i][j]);
//            }
//        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    //최대 깊이 까지 방문 안한 것만 방문해서
    static void dfs(int node, int d){
        for(Edge e: g.get(node)){
            if(!v[e.to]){
//                for(int j = 1 ; j<= n; j++){
//                    System.out.print(dist[j] + " ");
//                }
//                System.out.println();
                v[e.to] = true;
                // max 구해야 될지도?
                distAll[node][e.to] = d + e.dist;
                dfs(e.to, dist[e.to]);
                v[e.to] = false;
            }
        }
    }

//    static void dijk(int start){
//        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) ->
//            o1.dist - o2.dist
//        );
//        pq.add(new Edge(start, 0));
////        v[start] = true;
//        distAll[start][start] = 0;
//
//        while(!pq.isEmpty()){
//            Edge pre = pq.poll();
//            distAll[start][pre.to] = pre.dist;
//            for(Edge now : g.get(pre.to)){
//                if(distAll[pre.to][now.to] != Integer.MAX_VALUE){
//                    distAll[start][now.to] = distAll[start][pre.to] + distAll[pre.to][now.to];
//                    answer = Math.max(answer, distAll[start][now.to]);
//                    continue;
//                }
//                distAll[start][now.to] = distAll[start][pre.to] + now.dist;
//                answer = Math.max(answer, distAll[start][now.to]);
//
//
////                if(distAll[start][now.to] > distAll[pre.to] + now.dist){
////                    dist[now.to] = dist[pre.to] + now.dist;
////                    answer = Math.max(answer, dist[now.to]);
////                    pq.add(new Edge(now.to, dist[now.to]));
////                }
//            }
//        }
//    }

}
