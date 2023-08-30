import java.util.Scanner;

public class Q4963 {
    static int[][] map;
    static int[][] v;
    static int height;
    static int width;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            String[] str = sc.nextLine().split(" ");
            height = Integer.parseInt(str[1]);
            width =  Integer.parseInt(str[0]);

            if(height == 0 & width == 0){
                break;
            }

            map = new int[height][width];
            v = new int[height][width];

            for (int i = 0; i < height; i++) {// map 받기
                str = sc.nextLine().split(" ");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }


//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    dfs(i, j, 0);
                }
            }

            System.out.println(count);
            count = 0;
            v= new int[height][width];

        }
    }

    static void dfs(int x, int y, int depth){// depth가 0 일때 count++
        if(v[x][y] == 1 || map[x][y] == 0){
            return;
        }
        v[x][y] = 1;

        if(depth == 0){
            count++;
        }

        for(int i = 0 ; i<8; i++){
            if(0 <= x+dx[i] & x+dx[i]< height & 0 <= y+dy[i] & y+dy[i] < width){
                if(map[x+dx[i]][y+dy[i]] != 0) {
                    dfs(x + dx[i], y + dy[i], depth+1);
                }
            }
        }


    };

}
