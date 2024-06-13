import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q3055 {

    static int n, m;
    static int Dx, Dy, Sx, Sy;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static String[][] map;
    static int[][] answer;
    static ArrayDeque<int[]> waters = new ArrayDeque<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new String[n][m];
        answer = new int[n][m];


        for (int i = 0; i < n; i++) {
            str = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
                if (map[i][j].equals("S")) {
                    Sx = i;
                    Sy = j;
                } else if (map[i][j].equals("D")) {
                    Dx = i;
                    Dy = j;
                }else if(map[i][j].equals("*")){
                    waters.add(new int[]{i, j});
                }
            }
        }
        bfs(Sx, Sy, waters);



        writer.write(answer[Dx][Dy] != 0?  answer[Dx][Dy]+ " " : "KAKTUS");
        writer.flush();
        writer.close();
    }

    static void bfs(int x, int y, ArrayDeque<int[]> waterDeq) {
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{x, y});

        while (!deq.isEmpty()) {
            List<int[]> nextWaters = new ArrayList<>();
            while(!waterDeq.isEmpty()) {
                int[] waterPre = waterDeq.poll();
                for (int i = 0; i < 4; i++) {
                    int[] now = new int[]{waterPre[0] + dx[i], waterPre[1] + dy[i]};
                    if (now[0] < 0 || now[0] >= n || now[1] < 0 || now[1] >= m) {
                        continue;
                    }
                    if (map[now[0]][now[1]].equals("*") || map[now[0]][now[1]].equals("X") || map[now[0]][now[1]].equals("D")) {
                        continue;
                    }
                    map[now[0]][now[1]] = "*";
                    nextWaters.add(now);
                }
            }
            waterDeq.addAll(nextWaters);
//            waterDeq.forEach(i -> System.out.print(i[0] + " " + i[1] + ", "));
//            System.out.println();
            List<int[]> next = new ArrayList<>();
            while (!deq.isEmpty()) {
                int[] pre = deq.poll();
                for (int i = 0; i < 4; i++) {
                    int[] now = new int[]{pre[0] + dx[i], pre[1] + dy[i]};
                    if (now[0] < 0 || now[0] >= n || now[1] < 0 || now[1] >= m) {
                        continue;
                    }
                    if (map[now[0]][now[1]].equals("*") || map[now[0]][now[1]].equals("X") || answer[now[0]][now[1]] != 0) {
                        continue;
                    }
                    answer[now[0]][now[1]] = answer[pre[0]][pre[1]] + 1;
                    next.add(now);
                }
            }
            deq.addAll(next);



//            for(int i =0 ;i< n; i++){
//                for(int j =0 ;j< m; j++){
//                    if(map[i][j].equals("*")|| map[i][j].equals("X")){
//                        System.out.print(map[i][j] + " ");
//                        continue;
//                    }
//                    System.out.print(answer[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }

}


