import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2615 {
    /*
    * 하나에 대해서 가로 세로 대각선 판단
    * 각각 반대 방향으로 가서 합산 하는 방식
    * 5이면 stop
    * */

    static int up, down;
    static int[] dx = {1,0,1,-1,-1,0,-1,1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

//    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{
//        if(o1[0] == o2[0])return o1[1] - o2[1];
//        return o1[0] - o2[0];
//    });

    static int[][] map = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i< 19; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean flag = false;

        for(int i = 0 ; i < 19; i++){
            for(int j = 0 ; j<19 ; j++){
                if(map[i][j] != 0) {
                    if (check(i, j, map[i][j])) {
                        System.out.println(i + " " + j);
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }

        System.out.println();
    }

    static boolean check(int x, int y, int target){
        boolean flag3 = false;
        for(int i = 0 ; i< 4; i++){
            up = 0;
            down = 0;
            boolean flag1 = false;
            boolean flag2 = false;
            while(true) {
//                pq = new PriorityQueue<>();
                if (move(x + (dx[i] * (up + 1)), y + (dy[i] * (up + 1)), target) == 1) {
                    up++;
                }else if (move(x + (dx[i] * (up + 1)), y + (dy[i] * (up + 1)), target) == 0) {
                    flag1 = true;
                }
                if (move(x + (dx[i + 4] * (down + 1)), y + (dy[i + 4] * (down + 1)), target) == 1) {
                    down++;
                }else if (move(x + (dx[i + 4] * (down + 1)), y + (dy[i + 4] * (down + 1)), target) == 2) {
                    flag2 = true;
                }
                if(flag1 && flag2){
                    flag3 = true;
                    break;
                }
            }
            if(flag3) {
                System.out.println(x + " " + y + " " + (up + down));
                break;
            }
        }


        return finalCheck(up, down);
    }

    static int move(int x, int y, int target){
        if(x < 0 || x>= 19 || y < 0 || y >= 19){
            return 2;
        }
        if(map[x][y] != target){
            return 0;
        }
//        pq.add(new int[]{x, y});
        return 1;
    }

    static boolean finalCheck(int up, int down){
        if(up + down == 5){
            return true;
        }
        return false;
    }

}
