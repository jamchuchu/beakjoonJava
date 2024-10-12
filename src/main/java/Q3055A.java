import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3055A {
    static int n,m,answer,a,b,c,d;
    static int[][] map;
    static boolean[][] visit;
    static List<int[]> waters = new ArrayList<int[]>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            str = reader.readLine().split("");
            for(int j = 0 ; j < m; j++){
                if(str[j].equals("D")){//도착지
                    visit[i][j] = true;
                    c = i;
                    d = j;
                }else if(str[j].equals("*")){
                    waters.add(new int[]{i, j});
                    map[i][j] = -2;//뮬
                }else if(str[j].equals("X")){
                    map[i][j] = -1;//돌
                }else if(str[j].equals("S")){//고슴 도치 위치
                    a = i;
                    b = j;
                }
            }
        }

        answer = dfs();

        writer.write(answer == -1? "KAKTUS" : answer + " ");
        writer.flush();
        writer.close();
    }

    static int dfs(){
        int time = -1;
        Queue<int[]> que = new LinkedList<>();
        que.addAll(waters);
        que.add(new int[]{a,b});
        visit[a][b] = true;


        while(!que.isEmpty()){
            int[] pre = que.poll();
            if(map[pre[0]][pre[1]] == -2){
                for(int i = 0 ; i< 4; i++){
                    int nx = pre[0] + dx[i];
                    int ny = pre[1] + dy[i];
                    if(nx < 0 || ny < 0 || nx >= n|| ny >= m){
                        continue;
                    }
                    if(visit[nx][ny]|| map[nx][ny] == -1|| map[nx][ny] == -2){//이미 고슴도치 방문했으면 더 방문할 필요 없음
                        continue;
                    }
                    map[nx][ny] = -2;
                    que.add(new int[]{nx , ny});
                }
                continue;
            }

            for(int i = 0 ; i< 4; i++){
                int nx = pre[0] + dx[i];
                int ny = pre[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n|| ny >= m){
                    continue;
                }
                if(nx == c && ny == d){
                    time = map[pre[0]][pre[1]] + 1;
                    return time;
                }
                if(visit[nx][ny]|| map[nx][ny] == -1|| map[nx][ny] == -2){
                    continue;
                }
                visit[nx][ny] = true;
                map[nx][ny] = map[pre[0]][pre[1]] + 1;
                que.add(new int[]{nx , ny});
            }
//            print(map);
        }
        return time;
    }

    static void print(int[][] map){
        for(int o = 0 ; o< map.length ; o++){
            for(int p = 0 ; p< map[o].length ; p++){
                System.out.print(map[o][p] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
