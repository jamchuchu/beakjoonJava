import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q15686 {
    static int n, m, cSize, hSize;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }
        cSize = chickens.size();
        hSize = houses.size();

        dfs( cSize,m, 0, 0, new int[m]); // 남길 리스트 작성
        System.out.println(answer);
    }

    static void dfs(int n, int k, int depth, int num, int[] list){
        if(depth == k){
            int minDist = 0;
            for(int i = 0; i< hSize; i++){
                int dist = 2500;
                for(int j = 0; j < k; j++){
                    int[] h = houses.get(i);
                    int[] c = chickens.get(list[j]);
                    dist = Math.min(Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]), dist);
                }
                minDist += dist;
            }
            answer = Math.min(answer, minDist);
            return;
        }
        for(int i = num; i < n; i++){
            list[depth] = i;
            dfs(n,k, depth+1, i +1, list);
        }
    }

}
