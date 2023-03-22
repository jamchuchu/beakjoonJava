import java.util.*;
import java.util.stream.Stream;

public class Q2178 {

    static int[][] arr;
    static boolean[][] v;
    static int a;
    static int b;
    static int count = 1;
    static List<Integer> list;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

         a = sc.nextInt();
         b = sc.nextInt();
        sc.nextLine();

        arr =  new int[a][b];

        for(int i = 0; i< a; i++){
            String[] temp = sc.nextLine().split("");
            arr[i] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        }

        v =  new boolean[a][b];
        list =  new ArrayList<>();


        dfs(0,0);

        System.out.println(Collections.min(list));

    }

    static void dfs(int x, int y){
        if(x == a-1 && y == b-1){
            list.add(count);
            count--;
            return;
        }

        v[x][y] = true;
        for(int i =0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(-1< xx && xx < a && -1 < yy && yy < b){
                if(!v[xx][yy] && arr[xx][yy] == 1) {
                    count++;
                    dfs(xx, yy);
                }
            }
        }
        v[x][y] = false;
        count--;
    }
}
