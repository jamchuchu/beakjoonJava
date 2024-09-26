import java.io.*;
import java.util.*;

public class Q1135 {
    static class Edge{
        int idx;
        int start;
        int end;

        public Edge(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

    }

//    static class Floor{
//        int depth;
//        List<Edge> edges;
//
//        public Floor(){
//            this.edges = new ArrayList<>();
//        }
//
//        public Floor(int depth, List<Edge> edges) {
//            this.depth = depth;
//            this.edges = edges;
//        }
//
//    }

    static int n,answer;
    static int[] node;
    static int[] nodeDepth;
    static int[] depth;
    static int[] list;
    static int[] startTime;
    static int[] spendTime;
    static List<List<Edge>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        list = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        node = new int[n];
        startTime = new int[n];
        spendTime = new int[n];
        nodeDepth = new int[n];
        depth = new int[n];

        for(int i = 0 ; i< n; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 1 ; i< n; i++){
            g.get(list[i]).add(new Edge(i, 0, 0));
            depth[i] = depth[list[i]] +1;
        }

//        for(int i = 0 ; i< n; i++){
//            Queue<Integer> que = new ArrayDeque<>();
//            que.add(i);
//            int count = 0;
//            int depthCount = 0;
//            while(!que.isEmpty()){
//                int pre = que.poll();
//                for(Edge now : g.get(pre)){
//                    que.add(now.idx);
//                    depthCount = Math.max(depthCount, depth[now.idx]);
//                    count++;
//                }
//            }
//            node[i] = count;
//            nodeDepth[i] = depthCount - depth[i];
//        }
//        for(int i = 0 ; i< n; i++){
//            for(Edge j : g.get(i)){
//                System.out.print(j.idx + " ");
//            }
//            System.out.println();
//        }
//        reader.readLine();
//        reader.readLine();
//        reader.readLine();

        for(int i = 0; i< g.size(); i++){
            System.out.println(i);
            startTime = new int[n];
            Queue<Integer> que = new ArrayDeque<>();
            que.add(i);
            int max = 0;

            while(!que.isEmpty()){
                int pre = que.poll();
//                System.out.println(pre);
                int parStartTime = startTime[pre]+1;
                for (Edge e: g.get(pre)){
                    System.out.print(e.idx + " ");
                    startTime[e.idx] = parStartTime++;
                    e.start = startTime[e.idx];

                    e.end = e.start + g.get(e.idx).size();
                    max = Math.max(e.end, max);

                    que.add(e.idx);
                }
            }
            System.out.println("max : " + max);
            spendTime[i] = max;
        }


        //자식 개수 순으로 정렬
//        for(int par = 0; par< g.size(); par++) {
//            g.get(par).sort((o1, o2) -> {
//                if(node[o2.idx] == node[o1.idx]){return nodeDepth[o2.idx] - nodeDepth[o1.idx];}
//                return node[o2.idx] - node[o1.idx];
//            });
//        }

        for(int par = 0; par< g.size(); par++) {
            g.get(par).sort((o1, o2) -> spendTime[o2.idx] - spendTime[o1.idx]);
        }


        startTime = new int[n];
        for(int par = 0; par< g.size(); par++){
        int parStartTime = startTime[par]+1;
        for (Edge e: g.get(par)){

            startTime[e.idx] = parStartTime++;
            e.start = startTime[e.idx];

            e.end = e.start + g.get(e.idx).size();
            answer = Math.max(e.end, answer);
        }
    }


//        for(int par = 0; par< g.size(); par++){
//            for (Edge e: g.get(par)){
//                depth[e.idx] = depth[par] + 1;
//                e.depth = depth[e.idx];
//            }
//        }


        System.out.println(g);
        for(int i = 0 ; i< n; i++){
            System.out.print(spendTime[i] + " ");
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
