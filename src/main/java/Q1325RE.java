import java.io.*;
import java.util.*;

public class Q1325RE {

    static int max;
    static List<Integer>[] coms;
    static int[] visited ;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        coms = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            coms[i] = new ArrayList<>();
        }

        visited = new int[N+1];
        ans = new int[N+1];

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");
            coms[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
        }

//        for (int i =0; i< N+1; i++){
//            System.out.println(coms[i]);
//        }


		for (int i = 1; i <= N; i++) {
			visited = new int[N+1];
			visited[i] = 1;
			dfs(i);
		}

        int max = 0;

        for (int i = 1; i <= N; i++)
        {
            max = Math.max(max, ans[i]);
        }


        for (int i = 1; i <= N; i++)
        {
            if (max == ans[i])
                bw.write(i + " ");
        }

        bw.flush();

    }
    private static void dfs(int node){
        for (int next : coms[node]) {
            if (visited[next] == 0) {
                ans[next]++;
                visited[next] = 1;
                dfs(next);
            }


        }
    }
}
