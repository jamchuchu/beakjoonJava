import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28015 {
    static int[][] map;
    static int[][] map2;
    static int count;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] str = sc.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        map = new int[x][y];
        map2 = new int[x][y];

        for(int i = 0; i < x; i++){
            str = sc.readLine().split(" ");
            for(int j = 0 ; j< y; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < x; i++){
            boolean flag1 = false;
            boolean flag2 = false;
            int max = 0;
            int min = 0;
            int a = 0;
            int b = 0;

            for(int j = 0 ; j< y; j++){
                if(map[i][j] == 1) {
                    a++;
                }else if(map[i][j] == 2) {
                    b++;
                }
                if(Math.max(max,min) == a){
                    max = 1;
                    min = 2;
                }else{
                    max = 2;
                    min = 1;
                }
            }

            for(int j = 0 ; j< y; j++){
                if(map[i][j] == min){
                    map[i][j] = max;
                }
            }

            boolean flag = false;
            for(int j = 0 ; j< y; j++){
                if(map[i][j] == max && !flag){
                    flag = true;
                    count++;
                }
                if(map[i][j] == 0){
                    flag = false;
                }
            }

            flag = false;
            for(int j = 0 ; j< y; j++){
                if(map2[i][j] == min && !flag){
                    flag = true;
                    count++;
                }
                if(map2[i][j] == 0){
                    flag = false;
                }
            }
        }


        System.out.println(count);

    }



}
