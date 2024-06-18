import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2636 {
    static int N, M, time, count, total;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static BufferedReader reader;

    public static void main(String[] args) throws Exception {
        input();

        while(total > 0) {
            time++;
            visit = new boolean[N][M];
            findOpen(0, 0);
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && checkMelt(i, j)) {
                        map[i][j] = 3;
                        count++;
                    }
                }
            }
            if(total - count == 0){
                break;
            }
            total -= count;
            changeMeltMap();
        }
        printAnswer();


    }


    static void input() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            str = reader.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1){
                    total++;
                }
            }
        }
    }


    static void printAnswer(){
        System.out.println(time);
        System.out.println(count);
    }


    static void findOpen(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M){
            return;
        }
        if(visit[x][y]){
            return;
        }
        if(map[x][y] == 1){
            return;
        }
        map[x][y] = 2;
        visit[x][y] = true;
        for(int i = 0; i< 4; i++){
            findOpen(x+dx[i],y+dy[i]);
        }
    }

    static boolean checkMelt(int x, int y){
        for(int i = 0; i< 4; i++){
            int mx = x+dx[i];
            int my = y+dy[i];
            if(mx < 0 || my < 0 || mx >= N || my >= M){
                continue;
            }
            if(map[mx][my] == 2){
                return true;
            }
        }
        return false;
    }

    static void changeMeltMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 || map[i][j] == 3) {
                    map[i][j] = 0;
                }
            }
        }
    }

}