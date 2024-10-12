import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q17822 {
    /*
    *
    * 필요 메소드
    * 회전
    * 인접하고 일치하는 것 있으면 삭제 TRUE 리턴// 없으면 FALSE 리턴
    * FALSE시 모든 합 구해서 /N
    * ROUND 해서 소숫점인지 아닌지 판단
    * 큰수 +1, 작은 수 -1
    *
    * */

    static int n, m, t, answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str =reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        t = Integer.parseInt(str[2]);

        visit = new boolean[n+1][m];
        map = new int[n+1][m];
        for(int i = 1 ; i <= n; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int time = 0 ; time < t; time++){
            str = reader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            rotate(x, d, k);

            boolean flag = false;
            for(int i = 1 ; i<= n; i++){
                for(int j = 0 ; j< m  ; j++){
                    if(map[i][j] == 0){
                        continue;
                    }
                    if(!flag){
                        flag = checkRelate(i ,j);
                        continue;
                    }
                    checkRelate(i, j);
                }
            }
            if(!flag){
                falsePerform(getAvg());
            }
        }

        answer = getSum();

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void print(int[][] map){
        for(int o = 1 ; o< map.length ; o++){
            for(int p = 0 ; p< map[o].length ; p++){
                System.out.print(map[o][p] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static void rotate(int x, int d, int k){
        //x의 배수인 원판을 d방향으로 k칸회전
        for(int i = x ; i <= n; i += x){ // 배수인 원판을
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            for(int j = 0; j< m; j++){// 다 넣고
                deq.add(map[i][j]);
            }
            for(int time = 0; time < k; time++) {// 회전
                if (d == 0) {
                    deq.addFirst(deq.pollLast());
                } else {
                    deq.addLast(deq.pollFirst());
                }
            }
            for(int j = 0; j< m; j++){ //원래 map에 반영
                map[i][j] = deq.poll();
            }
        }
    }

    // 퍼즐버블 터지듯이 한번에 터져야함 bfs 형태로
    static boolean checkRelate(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j});
        int target = map[i][j];

        boolean flag = false;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            for (int k = 0; k < 4; k++) {

                int nowX = x + dx[k];
                int nowY = (y + dy[k] + m) % m;
                if (nowX <= 0 || nowX > n) {// 범위 조심
                    continue;
                }
                if(map[nowX][nowY] == 0){
                    continue;
                }
                if (map[nowX][nowY] == target) {
                    flag = true;
                    map[nowX][nowY] = 0;
                    que.add(new int[]{nowX, nowY});
                }
            }
        }
        if(flag){
            map[i][j] = 0;
        }
        return flag;

    }

    static Double getAvg(){
        int count = 0;
        int sum = 0;
        for(int i = 0; i<= n; i++){
            for(int j = 0; j< m ;j++){
                if(map[i][j] != 0){
                    count++;
                    sum += map[i][j];
                }
            }
        }
        return count > 0 ? (double) sum / count : 0.0;
    }

    static void falsePerform(Double avg){
        for(int i = 0; i<= n; i++){
            for(int j = 0; j< m ;j++){
                if(map[i][j] == 0) {
                    continue;
                }
                if(map[i][j] > avg){
                    map[i][j]--;
                }else if(map[i][j] < avg){
                    map[i][j]++;
                }
            }
        }
    }

    static int getSum(){
        int sum = 0;
        for(int i = 0; i<= n; i++){
            for(int j = 0; j< m ;j++){
                if(map[i][j] != 0){
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }


}
