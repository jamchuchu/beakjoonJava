import java.io.*;
import java.util.Scanner;

public class Q9663C {
    /*
    * N개중 중복을 허용하지 않는 N 구하기
    * 시간복잡도 N!
    *
    */

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N, answer;
    static int[] select, visit;// 1,2,3,4,5,6로 좌표

    public static void main(String[] args) throws IOException {
        input();
        select = new int[N+1];
        visit = new int[N+1];
        mainFunc(1);
        System.out.println(answer);
    }

    static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());
    }

    static void mainFunc(int depth) {
        if (depth == N + 1) {
            answer++;
        } else {
            for (int i = 1; i < N + 1; i++) {
                // 현좌표 == depth, i
                // 이전 좌표 == 1-depth-1,select[i]-select[depth-1]
                boolean crash = false;
                for(int j = 1 ; j < depth; j++){
                    crash = attack(depth, i, j, select[j]);
                    if(crash){
                        break;
                    }
                }
                if(!crash) {
                    if (visit[i] == 0) {//할때 마다 체크
                        select[depth] = i;
                        visit[i] = 1;
                        mainFunc(depth + 1);
                        select[depth] = 0;
                        visit[i] = 0;
                    }
                }
            }
        }
    }

    //자신 보다 작은 x값에 대해서 체크
    //충돌 시 바로 false return
    static boolean check(){
        for (int i = 1 ; i<N+1; i++){
            for(int j= 1; j < i; j++){
                if(select[i] != 0 && select[i] != 0) {
                    if (attack(i, select[i], j, select[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //충돌 여부 체크, 대각선만 체크 하면됨
    static boolean attack(int x1, int y1, int x2, int y2){
        if(y1 != 0 && y2 != 0){
            if(x1 + y1 == x2 +  y2 || x1 - y1 == x2 - y2) {
                return true;
            }
        }return false;
    }

}
