import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q7569 {

    static int n,m,h,answer, count;
    static int[][][] map;
//    static boolean[][][] visit;
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static List<int[]> tomatoes = new ArrayList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[1]);
        m = Integer.parseInt(str[0]);
        h = Integer.parseInt(str[2]);

        map = new int[h][n][m];
        for(int l = 0 ; l < h ; l++){
            for(int i = 0 ; i< n; i++){
                str = reader.readLine().split(" ");
                for(int j = 0 ; j < m; j++){
                    map[l][i][j] = Integer.parseInt(str[j]);
                    if(map[l][i][j] == 1){
                        tomatoes.add(new int[]{l, i, j});
                    }else if(map[l][i][j] == 0){
                        count++;
                    }
                }
            }
        }

        if(count == 0){// 처음부터 숙성 과일이 없을경우
            answer = 0;
        }else{
            if(bfs()){
                answer--;
            }else{
                answer = -1;
            }
        }

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static boolean bfs(){
        Queue<int[]> que = new LinkedList<>();
        for(int[] start : tomatoes){
            que.add(start);
        }

        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i = 0 ; i < 6; i++){
                int nh = pre[0] + dh[i];
                int nx = pre[1] + dx[i];
                int ny = pre[2] + dy[i];
                if(nh < 0 || nh >= h || nx< 0 || nx >= n|| ny < 0 || ny >= m){
                    continue;
                }
                if(map[nh][nx][ny] == -1){
                    continue;
                }
                if(map[nh][nx][ny] == 0){
                    map[nh][nx][ny] = map[pre[0]][pre[1]][pre[2]] + 1;
                    answer = Math.max(answer, map[nh][nx][ny]);
                    que.add(new int[]{nh, nx, ny});
                    count--;
                }
            }
        }
        if(count== 0){
            return true;
        }else{
            return false;
        }
    }

}
