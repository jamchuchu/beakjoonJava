import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1890 {
    static int[][] map;
    static int[][] dp;
    static int[][] dp2;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        dp2 = new int[N][N];


        for (int i=0; i< N; i++){//맵 받기
            String[] str = br.readLine().split(" ");
            for(int j = 0; j<N ; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
//

//        dfs(0,0,0);

        for(int x= 0; x<N; x++){
            for(int y= 0; y<N; y++) {

                for (int i = 1; i < x+1; i++) {
                    if(map[x-i][y] == i){
                        dp[x][y]++;
                    }
                }
                for (int i = 1; i < y+1 ; i++) {
                    if(map[x][y-i] == i){
                        dp[x][y]++;
                    }
                }

            }
        }

        for(int x= 1; x<N; x++){
            for(int y= 1; y<N; y++) {

                for (int i = 1; i < x; i++) {
                    dp2[x][y] += dp[x-i][y]-1;

                }
                for (int i = 1; i < y ; i++) {
                    dp2[x][y] += dp[x][y-i]-1;
                }
            }
        }

         for(int i=0; i< N; i++){//맵 프린트
            for(int j = 0; j<N ; j++){
                System.out.print(dp2[i][j]);
            }
            System.out.println();
        }

        System.out.println(dp2[N-1][N-1]);

    }

//    static void dfs(int x, int y, int dir){
//        if(x == N-1 && y == N-1){
//            count++;
//            return;
//        }
//
//
//
//        if(dir == 0) {// 아래로
//            if(0 <= x+map[x][y] && x+map[x][y] < N) {
//                dfs(x + map[x][y], y, 0);
//            }
//            if(0 <= y+map[x][y] && y+map[x][y] < N) {
//                dfs(x, y + map[x][y], 1);
//            }
//        }else if(dir == 1) {// 옆으로
//            if(0 <= x+map[x][y] && x+map[x][y] < N) {
//                dfs(x + map[x][y], y, 0);
//            }
//            if(0 <= y+map[x][y] && y+map[x][y] < N) {
//                dfs(x, y + map[x][y], 1);
//            }
//        }
//
//    }
}
