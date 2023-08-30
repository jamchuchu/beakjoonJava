import java.util.Scanner;

public class Q2468 {
    static int[][] map;
    static int[][] v;
    static int num;
    static int[] dx = {-1,0, 1, 0};
    static int[] dy = {0, -1,0, 1};
    static int count;
    static int min;
    static int max;
    static int answer;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        sc.nextLine();
        min = 200;// 최소값 디폴트값

        map = new int[num][num];
        v = new int[num][num];
        for (int i = 0; i < num; i++) {// map 받기
            String[] str = sc.nextLine().split(" ");
            for (int j = 0; j < num; j++) {
                int temp = Integer.parseInt(str[j]);
                min = Math.min(min, temp);
                max = Math.max(max, temp);
                map[i][j] = temp;
            }
        }

        int height = min;
        while (height <= max) {// 물에 담그기
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (map[i][j] < height) {
                        map[i][j] = 0;
                    }
                }
            }

//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    dfs(i, j, 0);
                }
            }

//            System.out.println("height, count: "+  height+" "+ count);
//            System.out.println();


            answer = Math.max(answer, count);
            count = 0;
            v= new int[num][num];
            height++;

        }
//        if (num == 1){
//            answer = 1;
//        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int depth){// depth가 0 일때 count++
        if(v[x][y] == 1 || map[x][y] == 0){
            return;
        }
        v[x][y] = 1;

        if(depth == 0){
            count++;
        }

        for(int i = 0 ; i<4; i++){
            if(0 <= x+dx[i] & x+dx[i]< num & 0 <= y+dy[i] & y+dy[i] < num){
                if(map[x+dx[i]][y+dy[i]] != 0) {
                    dfs(x + dx[i], y + dy[i], depth+1);
                }
            }
        }


    };

}
