import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q14500A {
    static int n, m, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer = Math.max(raw(i, j, 4), answer);
                answer = Math.max(col(i, j, 4), answer);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = raw(i, j, 3);
                num += Math.max(rawMax(i+1, j), rawMax(i-1, j));
                answer = Math.max(num, answer);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = col(i, j, 3);
                num += Math.max(colMax(i, j+1), colMax(i,j-1));
                answer = Math.max(num, answer);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = col(i, j, 2);
                num += col(i+1, j, 2);
                answer = Math.max(num, answer);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = col(i, j, 2);
                num += col(i+1, j+1, 2);
                answer = Math.max(num, answer);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = col(i, j+1, 2);
                num += col(i+1, j, 2);
                answer = Math.max(num, answer);
            }
        }

        System.out.println(answer);
    }

    //1자 블럭 가로
    static int raw(int x,int y, int count){
        if(x < 0 || y < 0 || x >= n|| y >= m){
            return 0;
        }
        int num = 0;
        for(int i = 0; i < count; i++){
            if(y + i >= m){
                break;
            }
            num += map[x][y+ i];
        }
        return num;
    }
    static int col(int x,int y, int count){
        if(x < 0 || y < 0 || x >= n|| y >= m){
            return 0;
        }
        int num = 0;
        for(int i = 0; i < count; i++){
            if(x + i >= n){
                break;
            }
            num += map[x + i][y];
        }
        return num;
    }
    static int rawMax(int x, int y){
        if(x < 0 || y < 0 || x >= n|| y >= m){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(y + i >= m){
                break;
            }
            list.add(map[x][y+i]);
        }
        return Collections.max(list);
    }
    static int colMax(int x, int y){
        if(x < 0 || y < 0 || x >= n|| y >= m){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(x + i >= n){
                break;
            }
            list.add(map[x+i][y]);
        }
        return Collections.max(list);
    }


}
