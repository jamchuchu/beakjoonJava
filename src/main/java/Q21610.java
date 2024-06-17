import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q21610 {
    /*
    * 구름 1칸을 기준으로 생각
    * 이동 방향 정하기 순서
    *
    * 비내림
    *
    * 4방항 확인 후 결정 (대각선 list)
    *
    * 구름 생성 판단 -- list 로 구름 위치 받음
    * 2씩줄이기
    *
    * */

    static int answer, n, m;
    static int[][] map;
    static int[][] clone;
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int[] cx = {-1,1,1,-1};
    static int[] cy = {1,1,-1,-1};
    static ArrayDeque<int[]> clouds = new ArrayDeque<>();
    static ArrayDeque<int[]> preClouds = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][n];
        clone = new int[n][n];
        for(int i =  0; i < n; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        clouds.add(new int[]{n-1,0});
        clouds.add(new int[]{n-1,1});
        clouds.add(new int[]{n-2,0});
        clouds.add(new int[]{n-2,1});

        for(int i = 0 ; i< m; i++){
            int[] move =  Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int dir = move[0];
            int count = move[1];

            cloneMap();
            cloudMove(dir, count);
            rain();
            checkCrossWaterUp();
            checkNewCloudsSite();
        }

        getAllMapNum();
        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void cloudMove(int dir, int count){
        int size = clouds.size();
        for(int i = 0 ; i < size; i++) {
            int[] pre = clouds.poll();
            int nowX = (pre[0] + (count * dx[dir]) + n*50) % n;
            int nowY = (pre[1] + (count * dy[dir]) + n*50) % n;
            clouds.add(new int[]{nowX, nowY});
        }
    }

    static void rain(){
        ArrayDeque<int[]> temp = new ArrayDeque<>(clouds);
        while(!temp.isEmpty()){
            int[] now = temp.poll();
            map[now[0]][now[1]] += 1;
        }
    }

    static void checkCrossWaterUp(){
        preClouds = new ArrayDeque<>();
        while(!clouds.isEmpty()){
            int[] pre = clouds.poll();
            int count = 0;
            for(int i = 0; i < 4; i++){
                int nowX = pre[0] + cx[i];
                int nowY = pre[1] + cy[i];
                if(nowX < 0|| nowY < 0 || nowX >= n || nowY >= n){
                    continue;
                }
                if(map[nowX][nowY] > 0){
                    count++;
                }
            }
            map[pre[0]][pre[1]] += count;
            preClouds.add(pre);
        }
    }

    static void checkNewCloudsSite(){
        answer = 0;
        for(int i=0; i<n ;i++){
            for(int j=0; j<n ; j++){
                if(map[i][j] >= 2 && clone[i][j] == map[i][j]){
                    clouds.add(new int[]{i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }

    static void cloneMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                clone[i][j] = map[i][j];
            }
        }
    }
    static void getAllMapNum(){
        for(int o = 0 ; o< n ; o++){
            for(int p = 0 ; p< n ; p++){
                answer += map[o][p];
            }
        }
    }





}
