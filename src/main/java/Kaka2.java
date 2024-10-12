import java.util.LinkedList;
import java.util.Queue;

public class Kaka2 {

    static int n, m, x, y;
    static String[][] map;
    static int[][] intMap;
    static String[] arr = {"X.....>" , "..v..X.",".>..X..","A......"};
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        n = arr.length;
        m = arr[0].length();

        map = new String[n][m];
        intMap = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            String[] str = arr[i].split("");
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = str[j];
            }
        }

        searchMap();
        System.out.println(bfs());

        print(intMap); //1은 이동 경로 -1은 이동 불가 경로

    }

    static boolean bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        intMap[x][y] = 1;

        while(!que.isEmpty()) {
            int[] pre = que.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if(nowX < 0 || nowY < 0|| nowX >= n|| nowY >= m){
                    continue;
                }
                if(intMap[nowX][nowY] == -1 || intMap[nowX][nowY] == 1){
                    continue;
                }
                if(nowX == n-1 && nowY == m-1){
                    return true;
                }
                intMap[nowX][nowY] = 1;
                que.add(new int[]{nowX, nowY});
            }
        }
        return false;
    }

    static void searchMap(){
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j].equals("X")){
                    intMap[i][j] = -1;
                }else if (map[i][j].equals("A")){
                    x = i;
                    y = j;
                }else if(map[i][j].equals(".")){
                    continue;
                }else{ // > < ^ v
                    int dir = findDirection(map[i][j]);
                    checkOverlook(dir, i, j);
                }
            }
        }
    }

    static void checkOverlook(int dir, int x, int y){
        int length = Math.max(n,m);
        for(int i = 0 ; i < length; i++){
            if(x + (dx[dir] * i) >= n|| y + (dy[dir] * i) >= m){
                break;
            }
            if(map[x + (dx[dir] * i)][y + (dy[dir] * i)].equals("X") ){
                break;
            }
            intMap[x + (dx[dir] * i)][y + (dy[dir] * i)] = -1;
        }
    }

    static int findDirection(String str){
        int dir = -1;
        if(str.equals("^")){
            dir = 0;
        }
        if(str.equals(">")){
            dir = 1;
        }
        if(str.equals("v")){
            dir = 2;
        }
        if(str.equals("<")){
            dir = 3;
        }
        return dir;
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
