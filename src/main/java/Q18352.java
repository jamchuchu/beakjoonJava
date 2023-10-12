import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Q18352 {
    static int[] visit;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int node = Integer.parseInt(str[0]);
        int edge = Integer.parseInt(str[1]);
        int distance = Integer.parseInt(str[2]);
        int start = Integer.parseInt(str[3]);


        list = new ArrayList[node+1];
        for(int i = 0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< edge; i++){
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list[a].add(b);
        }

        visit =  new int[node+1];
        Arrays.fill(visit, -1);

        bfs(start);


        int count = 0;
        for(int i = 0; i< node+1; i++){
            if(visit[i] == distance){
                writer.write(i+"\n");
                count++;
            }
        }

        if(count == 0){
            System.out.println(-1);
        }else{
            writer.flush();
        }


    }
    static void bfs(int node) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(node);
        visit[node]++;
        while(!Q.isEmpty()){
            int now = Q.poll();
            for(int i : list[now]){
                if(visit[i] == -1) {
                    visit[i] = visit[now]+1;
                    Q.add(i);
                }
            }
        }
    }
}
