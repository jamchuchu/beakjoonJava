import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q7562 {

    static int T, n, a,b,c,d,answer;
    static int[][] map;
    static int[] dx = {-2, -1,2,1,2,1,-2,-1};
    static int[] dy = {-1,-2,1,2,-1,-2,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < T; i++){
            n = Integer.parseInt(reader.readLine());
            String[] str = reader.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            str = reader.readLine().split(" ");
            c = Integer.parseInt(str[0]);
            d = Integer.parseInt(str[1]);
            map = new int[n][n];

            if(a == c && b == d){
                answer = 0;
            }else{
                answer = bfs(a,b);
            }

            writer.write(answer+"\n");
        }


        writer.flush();
        writer.close();
    }

    static int bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i = 0 ; i < 8 ; i++){
                int nx = pre[0] + dx[i];
                int ny = pre[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }
                if(map[nx][ny] == 0){
                    map[nx][ny] = map[pre[0]][pre[1]]+1;
                    if(nx == c && ny == d){
                        return map[nx][ny];
                    }
                    que.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }


}
