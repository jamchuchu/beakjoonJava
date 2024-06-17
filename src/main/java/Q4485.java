import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4485 {
    /*dijk
    * 2차원 다익 처음봄
    * 상하 좌우 다 된다고 할때 v 찍어야될듯? -- 안찍어도됨
    * 안그러면 무한 반복
    *
    *21168	276
    * */




    static int n, count;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            count++;
            n = Integer.parseInt(reader.readLine());
            if(n == 0){
                break;
            }
            map = new int[n][n];
            answer = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(answer[i], Integer.MAX_VALUE);
            }

            dijk();

            writer.write("Problem " + count + ": " + answer[n - 1][n - 1] + "\n");
            writer.flush();
        }
        writer.close();
    }

    static void dijk(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        answer[0][0] = map[0][0];
        pq.add(new int[]{0,0,map[0][0]});

        while(!pq.isEmpty()){
            int[] pre = pq.poll();
            if(answer[pre[0]][pre[1]] < map[pre[0]][pre[1]]){
                continue;
            }
            for(int i = 0; i< 4 ;i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if(nowX < 0  || nowY < 0 || nowX >= n || nowY >= n){
                    continue;
                }
                int money = pre[2] + map[nowX][nowY];
                if(answer[nowX][nowY] > money){
                    answer[nowX][nowY] = money;
                    pq.add(new int[]{nowX, nowY, money});
                }

            }
        }
    }


}
