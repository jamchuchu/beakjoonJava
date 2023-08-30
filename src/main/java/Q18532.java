import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q18532 {
    static List<Integer>[] map;
    static int[] v;
    static int count;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str =  sc.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);
        int start = Integer.parseInt(str[3])-1;


        map = new ArrayList[N];
        v = new int[N];


        for(int i = 0; i< N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i =0; i< num; i++){
            str =  sc.readLine().split(" ");
            int a = Integer.parseInt(str[0])-1;
            int b = Integer.parseInt(str[1])-1;
            map[a].add(b);
        }


        dfs(start, 0);


        if(count == 0){
            System.out.println(-1);
        }else{
            for(int i = 0; i < N; i++){
                if(v[i] == K){
                    bw.write((i+1)+ "\n");
                }
            }
        }
        bw.flush();

    }
    static void dfs(int a, int depth){
        if(v[a] == 0 || depth < v[a]){
            v[a] = depth;
        }

        if(depth == K){
            count++;
            return;
        }


        for(int i=0; i< map[a].size(); i++){
            dfs(map[a].get(i), depth+1);
        }
    }
}
