import java.io.*;
import java.util.ArrayDeque;

public class Q11559 {
    static int n = 12;
    static int m = 6;
    static int answer;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[n][m];
        v = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] str = reader.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = changeForInt(str[j]);
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        while (true){

            boolean flag = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 0|| v[i][j]){
                        continue;
                    }
                    if (!flag) {
                        flag = bfs(i, j);
                    }
                    bfs(i, j);
                }
            }
            if(!flag){
                break;
            }
            answer++;
            dropDown();
//
//            System.out.println(answer);
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++) {
//                    System.out.print(v[i][j]);
//                }
//                System.out.println();
//            }
            v = new boolean[n][m];

        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static int changeForInt(String color){
        if(color.equals(".")){
            return 0;
        }else if(color.equals("R")){
            return 1;
        }else if(color.equals("G")){
            return 2;
        }else if(color.equals("B")){
            return 3;
        }else if(color.equals("P")){
            return 4;
        }else if(color.equals("Y")){
            return 5;
        }
        return 6;
    }

    static boolean bfs(int x,int y) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        v[x][y] = true;
        int count = 1;
        ArrayDeque<int[]> equal = new ArrayDeque<>();
        equal.add(new int[]{x, y});


        while(!que.isEmpty()){
            int[] pre = que.poll();
            for (int i = 0 ; i< 4; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];

                if(nowX < 0 || nowX >= n || nowY < 0 || nowY >= m){
                    continue;
                }
                if(v[nowX][nowY]){
                    continue;
                }
                if(map[pre[0]][pre[1]] ==  map[nowX][nowY]){
//                    System.out.println(nowX  +" " + nowY);

                    v[nowX][nowY] = true;
                    count++;
                    equal.add(new int[]{nowX, nowY});
                    que.add(new int[]{nowX, nowY});
                }
            }
        }

        //터뜨리기
        if(count >= 4){
            while(!equal.isEmpty()){
                int[] now = equal.poll();
                map[now[0]][now[1]] = 0;
            }
            return true;
        }
        return false;
    }

    static void dropDown(){
        for(int j = 0 ;j< m ;j++){
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            for(int i = 0; i < n ; i++){
                if(map[i][j] == 0)continue;
                deq.add(map[i][j]);
                map[i][j] = 0;
            }
            int x = n-1;
            while(!deq.isEmpty()){
                map[x][j] = deq.pollLast();
                x--;
            }
        }
    }
}
