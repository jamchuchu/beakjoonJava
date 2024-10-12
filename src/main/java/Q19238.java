import java.io.*;
import java.util.*;

public class Q19238 {

    /*
    * 현재 특정 위치에서 특정 위치 까지 거리 구함
    *
    * 특정 위치에서 맵 전범위로 거리 구함
    * */

    static class Pass{
        int startX, startY, endX, endY;

        public Pass(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static int n, m, oil, x, y, answer;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] visit;
    static List<Pass> passes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        oil = Integer.parseInt(str[2]);

        visit = new boolean[n][n];
        map = new int[n][n];
        for(int i = 0 ; i< n; i++){
            str = reader.readLine().split(" ");
            for(int j= 0; j < n ; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

//        print(visit);

        str = reader.readLine().split(" ");
        x= Integer.parseInt(str[0])-1;
        y= Integer.parseInt(str[1])-1;

        for(int i = 0 ; i < m; i++){
            int[] temp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            passes.add(new Pass(temp[0]-1, temp[1]-1, temp[2]-1, temp[3]-1));
        }

        passes.sort((a,b) -> {
            if(a.startX == b.startX) return a.startY - b.startY;
            return a.startX - b.startX;
        });

        for(int i = 0 ; i< m ;i++) {
            int[][] a = bfs(new int[]{x, y}, cloneMap(), cloneVisit());// 택시 부터 거리
//            System.out.println("택시로 부터 거리");
//            print(a);
            int idx = findPass(a); // 손님 찾기
            if(idx == -1){
                oil = -1;
                break;
            }
            Pass p = passes.get(idx);
//            System.out.println(p.startX + " " + p.startY + " " + p.endX + " " + p.endY);
            if (oil < a[p.startX][p.startY]) {//거기까지 이동 가능?
                oil = -1;
                break;
            }
            passes.remove(idx);
            x = p.startX;
            y = p.startY;// 택시 이동
            oil -= a[p.startX][p.startY];// 연료 소모

            int dist = bfsTarget(new int[]{p.startX, p.startY}, new int[]{p.endX, p.endY}, cloneMap(), cloneVisit()); // 출발지 부터 도착지 까지 거리
//            System.out.println(dist);


            if (oil < dist || dist == -1) {
                oil = -1;
                break;
            }
            oil += dist; // 줄어들었다가 두배 증가 = 거리만큼 증가
            x = p.endX;
            y = p.endY;// 택시 이동
        }


        writer.write(oil+" ");
        writer.flush();
        writer.close();
    }


    // 출발지 잇음 도착지 없음
    static int[][] bfs(int[] start, int[][] map, boolean[][] visit){
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        visit[start[0]][start[1]]= true;

        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i= 0 ; i < 4 ; i++){
                int nx = pre[0] + dx[i];
                int ny = pre[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if(visit[nx][ny]){
                    continue;
                }
                visit[nx][ny] = true;
                map[nx][ny] = map[pre[0]][pre[1]] + 1;
                que.add(new int[]{nx, ny});
            }
        }
        return map;
    }

    //특정 지점 까지 거리
    //출발지 도착지 둘다 있음
    static int bfsTarget(int[] start, int[] end, int[][] map, boolean[][] visit){
        if(start[0] == end[0] && start[1] == end[1]){ // 출발지 도착지 같을 경우
            return 0;
        }
        int dist = -1;
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        visit[start[0]][start[1]]= true;

        while(!que.isEmpty()){
            int[] pre = que.poll();
            for(int i= 0 ; i < 4 ; i++){
                int nx = pre[0] + dx[i];
                int ny = pre[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if(visit[nx][ny]){
                    continue;
                }
                visit[nx][ny] = true;
                map[nx][ny] = map[pre[0]][pre[1]] + 1;
                if(nx == end[0] && ny == end[1]){
                    dist =  map[nx][ny];
                    break;
                }
                que.add(new int[]{nx, ny});
            }
            if(dist != -1){
                break;
            }
        }
        return dist;
    }

    //가장 가까운 사람 찾기
    static int findPass(int[][] map){
        int min = n*n;
        int idx = -1;
        for(int i = 0 ;i < passes.size(); i++){
            if(map[passes.get(i).startX][passes.get(i).startY] == 0){// 거리가 0인 사람 발견
                if(passes.get(i).startX == x && passes.get(i).startY == y){//지점이 같으면
                    idx = i;
                }
                break;//아니면 도달 불가 지점
            }
            if(min > map[passes.get(i).startX][passes.get(i).startY]){
                min = map[passes.get(i).startX][passes.get(i).startY];
                idx = i;
            }
        }
        return idx;
    }

    static int[][] cloneMap(){
        int[][] nm = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int  j = 0 ; j< n; j++){
                nm[i][j] = map[i][j];
            }
        }
        return nm;
    }
    static boolean[][] cloneVisit(){
        boolean[][] v = new boolean[n][n];
        for(int i = 0 ; i < n; i++){
            for(int  j = 0 ; j< n; j++){
                if(map[i][j] == 1){
                    v[i][j] = true;
                }
            }
        }
        return v;
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

    static void print(boolean[][] map){
        for(int o = 0 ; o< map.length ; o++){
            for(int p = 0 ; p< map[o].length ; p++){
                System.out.print(map[o][p] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
