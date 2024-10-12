import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2606B {

    static int n, m,answer;
    static List<List<Integer>> g = new ArrayList<List<Integer>>();
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());

        for(int i = 0 ; i <=n ; i++){
            g.add(new ArrayList<>());
        }
        v = new boolean[n+1];

        for(int i = 0 ; i < m; i++){
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            g.get(a).add(b);
            g.get(b).add(a);
        }

//        System.out.println(g);


        writer.write(bfs(1)+" ");
        writer.flush();
        writer.close();
    }

    static int bfs(int start){
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        v[start] = true;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now : g.get(pre)){
                if(v[now]){
                    continue;
                }
//                System.out.println(now);
                v[now] = true;
                que.add(now);
                count++;
            }
        }
        return count;
    }

}
