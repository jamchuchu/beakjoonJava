import java.io.*;
import java.util.StringTokenizer;

public class Q1340 {
    static int[] list;
    static int[] v;
    static int count;
    static int num;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());


        list = new int[N];
        v = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        bw.write(String.valueOf(count));
        bw.flush();
    }

    static void dfs(int total, int depth, int start){
        if(depth == 2){
            if(total == num){
                count++;
                return;
            }
        }
        for(int i = start; i< N; i++){
            if(v[i] == 0){
                v[i] = 1;
                dfs(total + list[i], depth + 1, i+1);
                v[i] = 0;
            }
        }



    }
}



