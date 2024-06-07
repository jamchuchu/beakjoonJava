import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2866 {
    static int n, m;
    static String[][] map;
    static List<Integer> equal = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new String[n][m];


        for(int i = 0 ; i< n; i++){
            map[i] = reader.readLine().split("");
        }

        //아래에서 같은 열을 찾고
        //그것들만 탐방
        for(int k = 0; k < n; k++){
            for(int i = 0 ; i< m; i++){
                for(int j = i ; j< m; j++) {
                    if(map[n-1][i].equals(map[n-1][j])){
                        equal.add(i);
                        equal.add(j);
                    }
                }


            }
        }

        int answer = 0;
        for(int i = 0 ; i < n ;i++){
            if(Arrays.stream(map[i]).distinct().count() == m){
                answer = i;
            }else{
                break;
            }
        }

        System.out.println(answer);

//        for(int i = 0 ; i< n; i++){
//            for(int  j =  0 ; j< m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
