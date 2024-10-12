import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q3085 {
    static int n, answer;
    static int[][] map;
    static int[][] countMap;
    static boolean[][] v;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    /*
    * 4방향 확인해서 돌리고
    * 각 칸에서 갈 수 있는 최대치? 개수 카운트 파악만 하면 될듯?
    *
    *
    * 다른 방식은?
    * 자신을 근처에 있는 다른 색으로 바꿨을때 최대치가 될 수 있는지 확인? --> 더 빠를 것 같음
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        for(int i = 0 ; i < n; i++){
            String[] str = reader.readLine().split("");
            for(int j = 0 ; j < n; j++){
                map[i][j] = changeColorToInt(str[j]);
            }
        }

        //원래 껄 하긴 해야 될텐데
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j< n; j++){
                func(i, j, cloneMap());
            }
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void func(int x, int y, int[][] map) {
        //4칸과 비교 해서 다르면 바꿈
        for (int i = 0; i < 4; i++) {
            map = cloneMap();
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (map[nx][ny] == map[x][y]) { //같으면 패스
                continue;
            }
            int temp = map[nx][ny];
            map[nx][ny] = map[x][y];
            map[x][y] = temp;

            //다른걸 할 필요가 없을것 같은데..?
            bfs(nx, ny, map,0);
            bfs(nx, ny, map, 1);
            bfs(x, y, map, 0);
            bfs(x, y, map, 1);
        }
    }

    //특정 지점 에서 확장
    static void bfs(int x, int y, int[][] map, int dir){// 0: 가로, 1: 세로
        v = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        v[x][y] = true;
        int count = 1;


        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i = 0; i < 4; i++){
                int nx = pre[0];
                int ny = pre[1];
                if(dir == 0){
                    nx += dx[i];
                }else{
                    ny += dy[i];
                }

                if(nx < 0 || ny < 0 ||nx >= n || ny >= n){
                    continue;
                }if(v[nx][ny]){
                    continue;
                }
                if(map[nx][ny] == map[pre[0]][pre[1]]){ //같을때만 count
                    v[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

//        System.out.println(x + " " + y + " count: " + count);
//        print(map);

        answer = Math.max(answer, count);
    }
    static int changeColorToInt(String str){
        if(str.equals("C")){
            return 0;
        }else if(str.equals("P")){
            return 1;
        }else if(str.equals("Z")){
            return 2;
        }else if(str.equals("Y")){
            return 3;
        }
        return -1;
    }


    static int[][] cloneMap(){
        int[][] nm  = new int[n][n];
        for(int i =0 ; i< n; i++){
            for(int j =0 ; j< n; j++){
                nm[i][j] = map[i][j];
            }
        }
        return nm;
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
