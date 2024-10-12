import java.io.*;
import java.util.Arrays;

/*
* 1*1 = 2+1+2 = 5 = 2*2 + 1*1
* 2*2 = 3+2+3+2+3 = 13 = 3*3 + 2*2
* 3*2 = 4+3+4+3+4 = 4*3 + 3*2
*  ==  n,m -> (n+1)(m+1) + n*m = n + m + 2nm + 1 -> 얘가 가장 중간값에 가까워야 함
*
* start i, j// n m = 3,2
* 1 :
* 2 : 1
* */

public class Q17779 {
    static int answer, n, m, k, max, min;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        k = Integer.parseInt(reader.readLine());
        map = new int[k][k];
        visit = new boolean[k][k];
        for(int i = 0; i < k ;i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = Integer.MAX_VALUE;

        n = 2;
        m = 2;
        find4(1, 3);

        for(int i = 1; i < k ; i++){
            for(int j = 1; j < k; j++){
                n = i;
                m = j;
                visit = new boolean[k][k];
                for(int x = 0; x < k - i ; x++){
                    for(int y = 0; y < k -  j ; y++){


                        int[] ans = new int[5];
                        ans[0] = find1(x,y);
                        ans[1] = find2(x,y);
                        ans[2] = find3(x,y);
                        ans[3] = find4(x,y);
                        ans[4] = find5();

                        min = 100 * k * k;
                        max = 0;

                        for(int a = 0 ; a < 5 ; a++){
                            min = Math.min(min, ans[a]);
                            max = Math.max(max, ans[a]);
                        }
//                        System.out.println(max + " " + min);

                        int temp = answer;
                        answer = Math.min(answer, max - min);
                        if(answer != temp){
                            System.out.println();
                            for(int a = 0 ; a < 5 ; a++){
                                System.out.print(ans[a] + " ");
                            }
                            System.out.println();
                            System.out.println(x + " " + y + " " + n + " " + m);
                            System.out.println(max +" "+ min);
                        }

                    }
                }

            }
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }


    static int find1(int x, int y){
        int answer = 0;
        for(int i = 0 ; i <= x + n-1 ;i++){
            y--;
            for(int j = 0 ; j <= y+1; j++){ // down
                if(!checkIJ(i, j)){
                    continue;
                }

                answer += map[i][j];
                visit[i][j] = true;
            }
        }
        return answer;
    }

    static int find2(int x, int y){
        int answer = 0;
        for(int i = 0 ; i <= x + m ;i++){
            if(i > x){
                y++;
            }
            for(int j = y+1 ; j < k; j++){ // down
                if(!checkIJ(i, j)){
                    continue;
                }

                answer += map[i][j];
                visit[i][j] = true;
            }
        }
        return answer;
    }


    static int find3(int x, int y){
        int answer = 0;
        int temp = y-n-1;
        for(int i = x+n ; i < k ;i++){
            if(i <= x + n+m){
                temp++;
            }
            for(int j = 0 ; j < temp; j++){ // down
                if(!checkIJ(i, j)){
                    continue;
                }
                answer += map[i][j];
                visit[i][j] = true;
            }
        }
        return answer;
    }


    static int find4(int x, int y){
        int answer = 0;
        for(int i = x+m+1 ; i < k ;i++){
            y--;
            for(int j = y+m+1 ; j < k; j++){ // down
                if(!checkIJ(i, j)){
                    continue;
                }
                answer += map[i][j];
                visit[i][j] = true;
            }
        }
        return answer;
    }

    static int find5(){
        int answer = 0;
        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ; j< k ;j++){
                if(!visit[i][j]){
                    answer = map[i][j];
                }
            }
        }
        return answer;
    }

    static boolean checkIJ(int i, int j){
        if(i < 0|| j < 0 || i >= k || j >= k){
            return false;
        }
        return true;
    }
}

