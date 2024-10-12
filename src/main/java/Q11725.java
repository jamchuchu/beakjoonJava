import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q11725 {

    static int n, answer;
    static int[] arr;
    static List<List<Integer>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());

        for(int i = 0 ; i <= n; i++){
            g.add(new ArrayList<>());
        }
        arr = new int[n+1];

        for(int i = 0 ; i < n-1; i++){
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            g.get(a).add(b);
            g.get(b).add(a);
        }

        bfs(1);

        for(int i = 2 ; i <= n; i++){
            System.out.println(arr[i]);
        }

//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        arr[start] = 0;

        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now: g.get(pre)){
                if(arr[now] != 0){
                    continue;
                }
                arr[now] = pre;
                que.add(now);
            }
        }
    }
}
