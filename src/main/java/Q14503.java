import java.io.*;

public class Q14503 {

    /*
    * 현재칸 청소
    * 주변 칸 없으면
    * 후진 후 자신 청소
    * 못가면 멈춤
    * 있으면 반시계
    * 앞이 청소 되지 않으면 한칸 전진
    *
    * 벽을 다른걸로 표시 해야될듯? 2 라던가?
    *
    * 0,1,2,3 북 동 남 서
    * */


    static int n, m, x, y, dir;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        str= reader.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        dir = Integer.parseInt(str[2]);

        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        while(true){
            print(map);
            if(map[x][y] == 0){// 현재 칸 청소
                answer++;
                map[x][y] = 2;
            }
            if(!searchAround() && moveBack()){// 청소 없고 뒤로 갈 수 있음
                continue;
            }else if(!searchAround() && !moveBack()){
                break;
            }else if(searchAround()){
                turnLeft();
                moveForward();
            }

        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();


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


    static boolean moveBack(){
        int nowX = x - dx[dir];
        int nowY = y - dy[dir];
        if(nowX <  0 || nowY < 0 || nowX >= n || nowY >= m){
            return false;
        }
        if(map[nowX][nowY] == 1){
            return false;
        }
        x = nowX;
        y = nowY;
        return true;
    }

    static boolean searchAround(){
        for(int i = 0 ; i< 4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX < 0 || nowY < 0 ||nowX >= n|| nowY >= m){
                continue;
            }
            if(map[nowX][nowY] > 0){
                continue;
            }
            if(map[nowX][nowY] == 0){
                return true;
            }
        }
        return false;
    }

    static void turnLeft(){
        dir = (dir + 3) % 4;
    }

    static void moveForward(){
        int nowX = x + dx[dir];
        int nowY = y + dy[dir];
        if(nowX < 0 || nowY < 0 ||nowX >= n|| nowY >= m){
            return;
        }
        if(map[nowX][nowY] == 1){
            return;
        }
        if(map[nowX][nowY] == 0){
            map[x][y] = 2;
            answer++;
            x = nowX;
            y = nowY;
        }
    }
}
