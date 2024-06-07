import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1706 {
    /*
    * dfs 문제
    * */

    static int n, m;
    static String[][] map;
    static List<String>  words = new ArrayList<>();
    static String word = "";
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new String[n][m];

        for(int i = 0; i < n; i++){
            str = reader.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = str[j];
            }
        }

        for(int i = 0; i < n; i++){
            str = reader.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = str[j];
            }
        }

        dfs(0,0,0,0);
        System.out.println(words);
    }

    static void dfs(int i, int j, int depth, int dir){
        System.out.println(i + " " + j);
        if(i < 0 || i >= n || j < 0 || j >= m){
            return;
        }
        if(depth != 0) {
            if (i + dx[dir] < 0 || i + dx[dir] >= n || j + dy[dir] < 0 || j + dy[dir] >= m) {//벽에 닿음
                words.add(word);
                word = "";
                return;
            }

            if (map[i + dx[dir]][j + dy[dir]].equals("#")) {
                words.add(word);
                word = "";
                return;
            }
        }
        if(depth == 0){
            for(int k = 0 ; k < 4 ; k++){
                word += map[i][j];
                dfs(i + dx[k] , j + dy[k] , depth + 1 , k);
            }
        }

        if(depth != 0){
            word += map[i][j];
            dfs(i + dx[dir] , j + dy[dir] , depth + 1 , dir);
        }
    }
}
