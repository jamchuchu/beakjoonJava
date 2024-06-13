import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q2606A {

    static int n,m, answer;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        for(int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }
        v = new int[n+1];

        for(int i  = 0; i < m; i++){
            String[] str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            g.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
        }

        bfs(1);
        for(int i = 2 ; i<= n; i++){
            if(v[i] != 0){
                answer++;
            }
        }

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.add(start);

        while(!deq.isEmpty()){
            int pre = deq.poll();
            for(int now : g.get(pre)){
                if(v[now] != 0){
                    continue;
                }
                v[now] = v[pre] +1;
                deq.add(now);
            }
        }

    }

}
