import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2644 {
    static int n, m, a, b;
    static int answer = -1;
    static List<List<Integer>> g = new ArrayList<List<Integer>>();
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        v = new boolean[n+1];
        Arrays.fill(v, false);
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i< n+1; i++){
            g.add(new ArrayList<>());
        }
        for(int i = 0;i< m ; i++){
            st = new StringTokenizer(reader.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(c).add(d);
            g.get(d).add(c);
        }
//        System.out.println(g);

        dfs(a, 0);
        System.out.println(answer);
    }
    // num == start
    static void dfs(int num, int depth){
        if(v[num]){
            return;
        }
        v[num] = true;

        if(num == b){
            answer = depth;
            return;
        }

        for(Integer n : g.get(num)){
            dfs(n, depth+1);
        }
    }
}
