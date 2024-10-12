import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q15900 {

    static int n,edgeCount;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] edges;
    static int[] child;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i <= n; i++){
            g.add(new ArrayList<>());
        }
        edges = new int[n+1];
        child = new int[n+1];

        for(int i= 0 ; i< n-1; i++){
            String[] str = reader.readLine().split(" ");
            int a= Integer.parseInt(str[0]);
            int b= Integer.parseInt(str[1]);
            g.get(a).add(b);
            g.get(b).add(a);
        }

        //1번 풀이 : 1까지도 도달하는 depth 찍어서 leaf인것만 골라서 카운트
        bfs(1);

        for(int i = 1 ; i<= n; i++){
            if(child[i] == 0){
                edgeCount += edges[i];
            }
        }


        //2번 풀이 : leaf 인것만 먼저 고르고 거기서 bfs해서 1번까지 도달 하는 것 더하기 -- 시간 초과

//        findLeaf(1);
//        for(int i = 1 ; i<= n; i++){
//            if(child[i] == 0){
//                edgeCount += countEdge(i);
//            }
//        }
//        System.out.println(edgeCount);

        writer.write(edgeCount % 2 == 1? "Yes" : "No");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        edges[start] = 0;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now: g.get(pre)){
                if(now == start){ // visit을 쓰지 않기 위한 발버둥
                    continue;
                }
                if(edges[now] != 0){
                    continue;
                }
                edges[now] = edges[pre]+1;
                que.add(now);

                child[pre] = now;
            }
        }
    }


    static void findLeaf(int start){
        boolean[] v =  new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        v[start] = true;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now: g.get(pre)){
                if(v[now]){
                    continue;
                }
                v[now] = true;
                que.add(now);
                child[pre] = now;
            }
        }
    }

    static int countEdge(int start){
        int[] edges =  new int[n+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        edges[start] = 0;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now: g.get(pre)){
                if(edges[now] != 0){
                    continue;
                }
                edges[now] = edges[pre]+1;
                que.add(now);
                if(now == 1){
                    return edges[1];
                }
            }
        }
        return -1;
    }
}
