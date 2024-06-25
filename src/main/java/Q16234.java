import java.io.*;
import java.util.*;

public class Q16234 {

    static int n,l,r,num, answer;
    static boolean flag = false;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static List<int[]> union = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        l = Integer.parseInt(str[1]);
        r = Integer.parseInt(str[2]);
        map = new int[n][n];
        v = new boolean[n][n];
        for(int i = 0 ; i< n; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while(true){
            flag = false;
            for(int i = 0 ; i< n; i++){
                Arrays.fill(v[i], false);
            }
            for(int i= 0 ; i< n; i++){
                for(int j = 0; j< n; j++){
                    if(v[i][j]){
                        continue;
                    }
                    check(i, j);
                }
            }
            if(!flag){
                break;
            }
            answer++;
//            print(map);
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void check(int x, int y){
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        union = new ArrayList<>();
        union.add(new int[]{x, y});
        deq.add(new int[]{x, y});
        num = map[x][y];
        v[x][y] = true;

        while(!deq.isEmpty()){
            int[] pre = deq.poll();
            int preNum = map[pre[0]][pre[1]];
            for(int i = 0 ; i< 4; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if(nowX < 0 ||nowY < 0 || nowX >= n || nowY >= n){
                    continue;
                }
                if(v[nowX][nowY]){
                    continue;
                }
                if( l <= Math.abs(map[nowX][nowY] - preNum) &&  Math.abs(map[nowX][nowY]-preNum) <= r){
                    deq.add(new int[]{nowX, nowY});
                    v[nowX][nowY] = true;

                    union.add(new int[]{nowX, nowY});
                    num += map[nowX][nowY];
//                    System.out.println(map[nowX][nowY]);

                    flag = true;
                }
            }
        }
        int peopleNum = num / union.size();
//        System.out.println(num);
        for (int[] location : union) {
            map[location[0]][location[1]] = peopleNum;
        }
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
