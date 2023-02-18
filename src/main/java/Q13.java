import java.util.Scanner;
import java.util.StringTokenizer;

public class Q13 {

    static int[][] arr;
    static boolean[][] v;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int row;
    static int col;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tryNum = Integer.parseInt(sc.nextLine());


        for (int k = 0; k < tryNum; k++) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            arr = new int[row][col];
            v = new boolean[row][col];

            int worm = Integer.parseInt(st.nextToken());

            for (int i = 0; i < worm; i++) {
                st = new StringTokenizer(sc.nextLine());
                int wrow = Integer.parseInt(st.nextToken());
                int wcol = Integer.parseInt(st.nextToken());
                arr[wrow][wcol] = 1;
            }


            for(int i = 0; i < row; i++) {
                for(int j =0; j< col; j++){
                    if(arr[i][j] == 1 && !v[i][j]) {
                        count++;
                        System.out.println(i +" "+  j);
                        search(i, j);

                    }
                }
            }

            System.out.println(count);
        }
    }

    static void search(int r, int c){
        v[r][c] = true;
        int cx = 0;
        int cy = 0;
        for( int i = 0; i < 4; i++ ){
            cx = r + dx[i];
            cy = r + dx[i];

            if(cx >= 0 && cy>= 0 && cx <row && cy <col) {
                if (!v[cx][cy] && arr[cx][cy] == 1) {
                    search(cx, cy);
                }
            }
        }
    }
}
