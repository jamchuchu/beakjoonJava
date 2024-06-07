import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1018A {
    /*
     * 0-8까지 세트 9-end 까지 넘어가면서
     * 아래도
     * 4중 for문
     *
     * 직접 바꾸지 말고 확인만
     * w, b 시작은 서로 64- count
     *
     * 14304	132
     * */
    static int n, m;
    static int stand = 8;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            map[i] = reader.readLine().toCharArray();
        }

        int answer = 2500;
        for(int i = stand ; i<= n; i++){
            for(int j = stand; j <= m ; j++){

                int count = 0;
                for(int k = i - stand; k < i; k++){
                    for(int l = j- stand; l < j; l++){
                        if( k % 2 == 0 && l % 2 == 0 && map[k][l] != 'W'){
                            count++;
                        }else if( k % 2 == 0 && l % 2 == 1 && map[k][l] != 'B'){
                            count++;
                        }else if( k % 2 == 1 && l % 2 == 0 && map[k][l] != 'B'){
                            count++;
                        }else if( k % 2 == 1 && l % 2 == 1 && map[k][l] != 'W'){
                            count++;
                        }
                    }
                }
                answer = Math.min(Math.min(count, stand * stand - count) , answer);

            }
        }
        System.out.println(answer);
    }
}
