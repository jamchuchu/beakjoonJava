import java.io.*;
import java.util.PriorityQueue;

public class Q1261 {

    /*
    * bfs
    * 	17816	244
    * */


    static int n,m, answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        answer = Integer.MAX_VALUE;

        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            str = reader.readLine().split("");
            for(int j = 0; j < m; j++){
                if(str[j].equals("1")) {
                    map[i][j] = m * n;
                }
            }
        }

        dijk();

        writer.write(m == 1 && n == 1 ? "0" : answer + " ");
        writer.flush();

    writer.close();
    }

    static void dijk(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] pre = pq.poll();
            for(int i = 0; i< 4 ;i++) {
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if (nowX < 0 || nowY < 0 || nowX >= n || nowY >= m) {
                    continue;
                }
                if(v[nowX][nowY]){
                    continue;
                }
                v[nowX][nowY] = true;
                if(nowX == n-1 && nowY == m-1){
                    answer = Math.min(answer,pre[2]);
                    continue;
                }
                if (map[nowX][nowY] > 0) {
                    pq.add(new int[]{nowX, nowY, pre[2] +1});
                }else{
                    pq.add(new int[]{nowX, nowY, pre[2]});
                }
            }
        }
    }


}
