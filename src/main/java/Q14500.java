import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14500 {
    static int n, m, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                answer = Math.max(check1(i, j), answer);
                answer = Math.max(check2(i, j), answer);
                answer = Math.max(check3(i, j), answer);
            }
        }
        System.out.println(answer);

    }

    //1번 -- 가로 세로
    static int check1(int x, int y){
        int num1 = 0;
        int num2 = 0;
        int[] dx = {0,1,2,3};
        int[] dy = {0,0,0,0};

        for(int i = 0; i< 4; i++){
            if(x + dx[i] >= n || y +dy[i] >= m){
                break;
            }
            num1 += map[x + dx[i]][y + dy[i]];
        }
        for(int i = 0; i< 4; i++){
            if(x + dy[i] >= n || y +dx[i] >= m){
                break;
            }
            num2 += map[x + dy[i]][y + dx[i]];
        }
        return Math.max(num1, num2);
    }

    // 가능한 10가지의 모양(가로 6칸)
    static int check2(int x, int y){
        List<Integer> nums = new ArrayList<>();
        int num1 = 0;
        for(int i= 0; i < 3; i++){// 위 3칸 합
            if(y+i >= m || x+1 >= n){
                break;
            }
            num1 += map[x][y+i];
            nums.add(map[x+1][y+i]);
        }
        if(!nums.isEmpty()) {
            num1 += Collections.max(nums);
        }

        nums = new ArrayList<>();
        int num2 = 0;
        for(int i= 0; i < 3; i++){// 아래 3칸 합
            if(x + 1 >= n || y + i >= m){
                break;
            }
            num2 += map[x+1][y+i];
            nums.add(map[x][y+i]);
        }
        if(!nums.isEmpty()) {
            num2 += Collections.max(nums);
        }

        int num3 = 0;
        int[] dx = {0,0,1,1};
        int[] dy = {0,1,1,2};
        for(int i = 0; i < 4 ; i++){
            if(x + dx[i] >= n || y + dy[i] >= m){
                break;
            }
            num3 += map[x+ dx[i]][y+dy[i]];
        }

        int num4 = 0;
        dx = new int[]{1,1,0,0};
        dy = new int[]{0,1,2,2};
        for(int i = 0; i < 4 ; i++){
            if(x + dx[i] >= n || y + dy[i] >= m){
                break;
            }
            num4 += map[x+ dx[i]][y+dy[i]];
        }
        return Math.max(Math.max(num1, num2), Math.max(num3, num4));
    }

    static int check3(int x, int y){
        int num = 0;
        int[] dx = {0,0,1,1};
        int[] dy = {0,1,0,1};

        for(int i = 0; i < 4 ; i++){
            if(x + dx[i] >= n || y + dy[i] >= m){
                break;
            }
            num += map[x+ dx[i]][y+dy[i]];
        }
        return num;
    }
}
