import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q20056 {

    /*
    * 파이어볼 정의, 질량 속력 방향
    *
    * 3중 리스트 가로 세로 파이어볼 리스트
    *
    * 이동
    * 합체 -- 새운 파이어볼들 생성 -4개
    *
    *
    * */

    static class FireBall{
        int weight, speed, dir;

        public FireBall(int weight, int speed, int dir) {
            this.weight = weight;
            this.speed = speed;
            this.dir = dir;
        }
    }


    static int n, m, k;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static ArrayDeque<FireBall>[][] map;
    static ArrayDeque<int[]> fireBallLocations = new ArrayDeque<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nums[0];
        m = nums[1];
        k = nums[2];
        map = new ArrayDeque[n][n];
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ;j < n; j++){
                map[i][j] = new ArrayDeque<>();
            }
        }
        for(int i = 0 ; i < m; i++){
            nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = nums[0]-1;
            int y = nums[1]-1;
            map[x][y].add(new FireBall(nums[2], nums[3], nums[4]));
        }
        print();

        System.out.println("moveAll");
        moveAllFire();
        print();

        System.out.println("moveAll");
        combineAllFire();
        print();

        writer.write(answer);
        writer.flush();
        writer.close();
    }

    static void moveAllFire(){
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j <n  ;j++){
                if(!map[i][j].isEmpty()){
                    move(i, j);
                }
            }
        }
    }


    static void move(int x, int y){
        ArrayDeque<FireBall> fireBalls = map[x][y];
        int size = fireBalls.size();
        for(int i = 0 ; i < size; i++) {
            FireBall f = fireBalls.poll();
            int nowX = (x + (f.speed * dx[f.dir]) + n * 1000) % n;
            int nowY = (y + (f.speed * dy[f.dir]) + n * 1000) % n;
            map[nowX][nowY].add(new FireBall(f.weight, f.speed, f.dir));

        }
    }

    static void combineAllFire(){
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j <n  ;j++){
                if(map[i][j].size() > 1){
                    combine(map[i][j]);
                }
            }
        }
    }


    static ArrayDeque<FireBall> combine(ArrayDeque<FireBall> fireBalls){
        int w = 0;
        int s = 0;
        int dir = -1;
        int flag = 2; // 2 4 6 8
        int size = fireBalls.size();
        while(!fireBalls.isEmpty()){
            FireBall f = fireBalls.poll();
            w += f.weight;
            s += f.speed;
            if(dir == -1){
                dir = f.dir % 2;
            }else{
                if(dir != f.dir % 2){
                    flag = 1; // 1 3 5 7
                }
            }
        }
        ArrayDeque<FireBall> newFireBalls = new ArrayDeque<>();
        if(w/5 != 0){
            for(int i = 1 ; i<= 4; i++){
                newFireBalls.add(new FireBall(w/5, s/size, flag + (i*2)));
            }
        }
        return newFireBalls;
    }



    static void print(){
        for(int o = 0 ; o< map.length ; o++){
            for(int p = 0 ; p< map[o].length ; p++){
                System.out.print(map[o][p].size());
            }
            System.out.println();
        }
        System.out.println();
    }

    static void print(ArrayDeque<FireBall> f){
        f.forEach(i -> System.out.print(i.weight + " "));
    }

}
