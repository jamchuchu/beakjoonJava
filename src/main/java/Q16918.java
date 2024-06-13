import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q16918 {

    static final int blank = 3;
    static int r,c,t;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        t = Integer.parseInt(str[2]);
        map = new int[r][c];
        for(int i = 0; i < r; i++){
            str = reader.readLine().split("");
            for(int j = 0; j < c; j++){
                if(str[j].equals("O")){
                    map[i][j] = 0;
                }else{
                    map[i][j] = blank;
                }
            }
        }

        if(t == 1)  {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = changeNum(map[i][j]);
                    }
                }
            }
        }if(t == 2){
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = changeNum(map[i][j]);
                }
            }
        }if(t == 3 || t == 4){
            List<int[]> bombList = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 2) {
                        bombList.add(new int[]{i, j});
                    }
                }
            }
            fire(bombList);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = changeNum(map[i][j]);
                }
            }
        }if(t > 4){
            int time = 4;
            while (true) {
                if (time == t) {
                    break;
                }
                reader.readLine();
                if (time % 4 ==  1 || time % 4 == 2) { //다 바뀜
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            map[i][j] = changeNum(map[i][j]);
                        }
                    }
                } else if (time % 4 == 0 || time % 4 == 3) {
                    List<int[]> bombList = new ArrayList<>();
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (map[i][j] == 2) {
                                bombList.add(new int[]{i, j});
                            }
                        }
                    }
                    fire(bombList);
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            map[i][j] = changeNum(map[i][j]);
                        }
                    }
                }
                print();
                time++;
                if (time == t) {
                    break;
                }
            }
        }
        answerMap();
        writer.flush();
        writer.close();
    }

    static void fire(List<int[]> bomb){
        for(int[] location : bomb){
            bomb(location[0] , location[1]);
        }
    }

    static void bomb(int x, int y){// 자기자신 포함 십자 폭발 // 3은 빈칸
        for(int i = 0 ; i< 4 ; i++){
            if(x + dx[i] < 0 || x + dx[i] >= r || y + dy[i] < 0 || y + dy[i] >= c){
                continue;
            }
            map[x + dx[i]][y + dy[i]] = 2;
        }
    }

   static int changeNum(int num){
        if(num == 0){
            return 1;
        }else if(num == 1) {
            return 2;
        } else if(num == 2){
            return 3;
        }else if(num == 3){
            return 0;
        }
        return 0;
    }

    static void print() {
        for(int i = 0 ; i< r ; i++){
            for(int j = 0 ; j < c; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    static void answerMap() throws IOException {
        for(int i = 0 ; i< r ; i++){
            for(int j = 0 ; j < c; j++){
                if(map[i][j] == 3){
                    writer.write(".");
                }else{
                    writer.write("O");
                }
            }
            writer.write("\n");
        }
    }



}
