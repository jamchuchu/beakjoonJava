import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889A {
    static int n, answer;
    static int[][] map;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        v = new boolean[n];
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(n/2 , 0);
        System.out.println(answer);
    }
    //중복되지 않게 n/2씩 뽑기
    static void dfs(int k, int start){
        if(k == 0){
            // answer 재정립
            answer = Math.min(getTeamsGap(), answer);
            return;
        }

        for(int i = start; i< n; i++){
            v[i] = true;
            dfs(k - 1, i + 1);
            v[i] = false;
        }
    }


    //map[i][j] 의 합구해서 차 return 하기
    static int getTeamsGap(){
        int a = 0;
        int b = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(v[i] && v[j]){
                    a += map[i][j];
                    continue;
                }
                if(!v[i] && !v[j]){
                    b += map[i][j];
                }
            }
        }
        return Math.abs(a-b);
    }
}
