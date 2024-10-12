import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q2178A {
    static int a,b,answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);


        System.out.println(a + " " + b);
        map = new int[a][b];
        visit = new boolean[a][b];

        for(int i = 0 ; i < a; i++){
            str = reader.readLine().split("");
            for(int j = 0 ; j < b; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 0){
                    visit[i][j] = true;
                    map[i][j] = -1;
                }
            }
        }

        bfs(new int[]{0,0});

        System.out.println(map[a-1][b-1]);


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }


    static void bfs(int[] start){//{0,0}
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        visit[start[0]][start[1]] = true;

        while(!que.isEmpty()){
            int[] pre = que.poll();

            for(int i = 0 ; i < 4; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];

                if(nowX < 0 || nowY < 0 || nowX >= a|| nowY >= b){
                    continue;
                }
                if(visit[nowX][nowY] || map[nowX][nowY] == -1){
                    continue;
                }
                visit[nowX][nowY] = true;
                map[nowX][nowY] = map[pre[0]][pre[1]] + 1;
                que.add(new int[]{nowX , nowY});
            }

        }


    }
}
