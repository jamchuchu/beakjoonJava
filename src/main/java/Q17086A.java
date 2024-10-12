import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q17086A {
    static int n,m, answer;
    static int[][] map;
    static int[] dx = {1,1,1,0,0,-1,-1,-1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str =reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];

        for(int i = 0 ; i< n; i++){
            str =reader.readLine().split(" ");
            for(int j = 0 ; j< m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1){
                    que.add(new int[]{i, j});
                }
            }
        }

        bfs();

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    /*
    * 1. 상어에서 시작해서 모든 칸으로 확장
    * 2. 각 칸에서 상어로의 최소 거리
    * */


    static void bfs(){
//        Queue<int[]> que = new LinkedList<>();
//        que.addAll(sharks);

        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i = 0 ; i< 8; i++){
                int nx = pre[0] +dx[i];
                int ny = pre[1] +dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                if(map[nx][ny] == 0 || map[nx][ny] > map[pre[0]][pre[1]] + 1) {
                    map[nx][ny] = map[pre[0]][pre[1]] + 1;
                    que.add(new int[]{nx, ny});
                    answer = Math.max(answer, map[nx][ny] - 1);
                }
            }
        }
    }


}
