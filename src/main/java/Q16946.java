import java.io.*;
import java.util.*;

public class Q16946 {
    static int n,m;
    static int[][] map;
    static int[][] temp;
    static int[][] answer;
    static boolean[][] v;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        for(int i = 0 ; i< n; i++){
            map[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        temp = new int[n][m];
        answer = new int[n][m];
        v = new boolean[n][m];

        List<int[]> list = new ArrayList<>();


        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j< m ;j++){
                if(map[i][j] == 0){
                    bfs(map.clone(), i ,j, list);
                }
                resetV();
            }
        }

        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j< m ; j++){
                writer.write(String.valueOf(answer[i][j]));
            }
            writer.write("\n");
        }

        writer.flush();
        writer.close();
    }

    static void resetV(){
        for(int i = 0 ; i< n; i++){
            Arrays.fill(v[i], false);
        }
    }

    static void bfs(int[][] map, int x, int y, List<int[]> list){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        v[x][y] = true;
        int count = 1;
        list.add(new int[]{x, y});

        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i = 0 ; i< 4; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];

                if(nowX < 0 || nowX >= n || nowY < 0 ||nowY >= m){
                    continue;
                }
                if(map[nowX][nowY] == 1){
                    continue;
                }
                if(v[nowX][nowY]){
                    continue;
                }
                list.add(new int[]{nowX, nowY});
                v[nowX][nowY] = true;
                count++;
                que.add(new int[]{nowX, nowY});
            }
        }
    }
}
