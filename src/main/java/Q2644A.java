import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2644A {
    static int n, m, a, b, answer;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);

        for(int i = 0 ; i<=n; i++){
            g.add(new ArrayList<>());
        }
        temp = new int[n+1];

        m = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i< m; i++){
            str = reader.readLine().split(" ");
            int c = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            g.get(c).add(d);
            g.get(d).add(c);
        }

        System.out.println(g);
        bfs(a);
        if(temp[b] == 0){
            answer = -1;
        }else{
            answer = temp[b];
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        temp[start] = 0;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now : g.get(pre)){
                if(temp[now] > 0){
                    continue;
                }

                for(int i= 1 ; i<= n; i++){
                    System.out.print(temp[i] + " ");
                }
                System.out.println();
                temp[now] = temp[pre]+1;
                que.add(now);
            }
        }
    }

}
