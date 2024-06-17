import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q17086 {


    /*
    131676	716
     * 각 칸에서 bfs 이동
     * 1만나면 stop 거리 갱신
     * */
    static int answer, n,m, dist;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map =new int[n][m];
        for(int i = 0 ; i< n; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j<m ;j++){
                if(map[i][j] == 1){
                    continue;
                }

                // 새로 map 정의
                dist = Integer.MAX_VALUE;
                v =new boolean[n][m];
                int[][] nowMap = new int[n][m];
                for(int o = 0 ; o< n ; o++){
                    for(int p = 0 ; p< m ; p++){
                        if(map[o][p] == 1) {
                            nowMap[o][p] = n + m;
                            continue;
                        }
//                        nowMap[o][p] = n + m + 1;
                    }
                }
                bfs(i, j, nowMap);
                answer = Math.max(dist, answer);
//                System.out.println(i  + " " + j);
//                for(int o = 0 ; o< n ; o++){
//                    for(int p = 0 ; p< m ; p++){
//                        System.out.print(nowMap[o][p] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println(dist);
//                System.out.println();

            }
        }

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }


    static void bfs(int x, int y, int[][] map){
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{x, y});
        v[x][y] = true;
        boolean flag = false;

        while(!deq.isEmpty()){
            if(flag){
                break;
            }
            int[] pre = deq.poll();
            for(int i = 0; i< 8; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= m){
                    continue;
                }
                if(map[nowX][nowY] == n + m){
                    dist = Math.min(map[pre[0]][pre[1]], dist) + 1;
                    flag = true;
                    break;// 현재 8방향만 그만 하는데 추후 해당칸 stop 필요 시 추가
                }
                if(!v[nowX][nowY]){
                    v[nowX][nowY] = true;
                    map[nowX][nowY] = map[pre[0]][pre[1]] + 1;
                    deq.add(new int[]{nowX, nowY});
                }
            }
        }
    }


}
