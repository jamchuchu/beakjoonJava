import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14 {

    static int row;
    static int col;
    static int[][] arr;
    static boolean[][] v;
    static int[] dx ={-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy ={-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        col = Integer.parseInt(st.nextToken());// 0-4
        row = Integer.parseInt(st.nextToken()); //0-3

        arr =  new int[row][col];
        v =  new boolean[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!v[i][j] && arr[i][j] == 1){
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int r, int c){

        v[r][c] = true;

        for(int i = 0; i < 8; i++){
            int cx = r + dx[i];
            int cy = c + dy[i];

            if(0 <= cx && cx < row && 0 <= cy && cy < col){
                if(!v[cx][cy]){
                    if(arr[cx][cy] == 1){
                        dfs(cx, cy);
                    }
                }
            }
        }

    }
}
