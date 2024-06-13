import java.io.*;
import java.util.*;

public class Q18352A {

    static List<List<Integer>> g = new ArrayList<>();
    static int[] dist;
    static int n,m,k,x;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        x = Integer.parseInt(str[3]);
        dist = new int[n+1];
        Arrays.fill(dist, m+1);

        for(int i = 0 ; i<= n ; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0 ; i< m ; i++){
            str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
        }
        bfs(x);

        int count= 0 ;
        for(int i = 1 ; i<= n ; i++){
            if(dist[i] == k){
                writer.write(i + "\n");
                count++;
            }
        }

        writer.write(count == 0 ? "-1" : "");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.add(start);
        dist[start] = 0;

        while (!deq.isEmpty()){
            int pre = deq.pollFirst();
            for(int now : g.get(pre)){
                if(dist[now] > dist[pre] + 1){
                    dist[now] = dist[pre] + 1;
                    deq.add(now);
                }
            }
        }
    }

}
