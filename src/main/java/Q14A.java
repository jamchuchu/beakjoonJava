import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14A {

    static int M, N;
    static int[][] arr;
    static boolean[][] visit;
    static int count;
    static int[] dx ={-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy ={-1, 0, 1, -1, 1, -1, 0, 1};

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!visit[cx][cy] && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            try {
                count = 0;
                st = new StringTokenizer(br.readLine(), " ");

                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                if (M == 0  && N == 0) {
                    break;
                }

                arr = new int[M][N];
                visit = new boolean[M][N];


                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for (int x = 0; x < M; x++) {
                    for (int y = 0; y < N; y++) {
                        if (arr[x][y] == 1 && !visit[x][y]) {
                            dfs(x, y);
                            count++;
                        }
                    }
                }

                System.out.println(count);
            }catch (Exception e){}
        }
    }


}
