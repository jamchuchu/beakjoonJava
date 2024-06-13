import java.io.*;
import java.util.*;

public class Q21937 {
//	87788	584

    static int n,m,x,answer;
    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] v;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        v = new boolean[n+1];
        Arrays.fill(v, false);

        for(int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
        }
        x = Integer.parseInt(reader.readLine());

        bfs(x);

        writer.write(count + " ");
        writer.flush();
        writer.close();
    }

    static int count = 0;
    static void bfs(int start){
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.add(start);

        while(!deq.isEmpty()){
            int pre = deq.poll();
            for(int now : g.get(pre)){
                if(!v[now]){
                    deq.add(now);
                    count++;
                    v[now] = true;
                }
            }
        }
    }

}
