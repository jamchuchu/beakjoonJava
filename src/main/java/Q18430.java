import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18430 {
    /*
    * 모서리가 될수 있는 칸
    *
    * 나이트 움직임과 같음 한칸 직선 후 대각선
    * 한칸 하고 총 8칸 후로 움직일 수 있음
    *
    * bfs로 가야될듯 ..? 가능하지 한것 들 모두 합
    * 이미 사용되었느지 안되었는지는
    *
    * */

    static int n, m, max;
    static int[][] map;
    static boolean[][] visit;

    static int[][] dx = {{0,1}, {0,1}, {-1,0}, {-1,0}};
    static int[][] dy = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static boolean isPossible(int i1, int i2, int j1, int j2){
        if(i1< 0 || i2<0 || i1>= n|| i2>=n) return false;
        if(j1< 0 || j2<0 || j1>= m|| j2>=m) return false;
        if(visit[i1][j1]) return false;
        if(visit[i2][j2]) return false;
        return true;
    }

    static void dfs(int tmp, int sum){
        if(tmp == n*m){
            max = Math.max(max, sum);
            return;
        }
        int ti = tmp/m;
        int tj = tmp%m;

        if(!visit[ti][tj]) {

            for(int d=0;d<4;d++) {
                //부메랑 모양 가능한지 체크
                int i1 = ti+dx[d][0];
                int i2 = ti+dx[d][1];
                int j1 = tj+dy[d][0];
                int j2 = tj+dy[d][1];

                if(isPossible(i1,i2,j1,j2)) {
                    visit[ti][tj] = true;
                    visit[i1][j1] = true;
                    visit[i2][j2] = true;
                    dfs(tmp+1, sum+(map[ti][tj]*2)+map[i1][j1]+map[i2][j2]);
                    visit[ti][tj] = false;
                    visit[i1][j1] = false;
                    visit[i2][j2] = false;
                }
            }
        }

        dfs(tmp+1, sum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(max);
    }

}
