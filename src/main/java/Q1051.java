import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1051 {
    /*
    * start에서 끝까지 가면서 자신과 같은 숫자 탐방
    * 찾으면 길이만큼 아래가 같은지 확인
    * 같으면 answer
    *
    *19268	180
    *
    * */

    static int n,m;
    static int answer = 1;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = j+1; k < m; k++) {
                    try {
                        if (map[i][j] == map[i][k]
                                && map[i][j] == map[i + (k - j)][j]
                                && map[i][j] == map[i + (k - j)][j + (k - j)]) {
                            answer = (int) Math.max(answer, Math.pow(k - j +1 , 2));
                        }
                    }catch(Exception e){}
                }
            }
        }

        System.out.println(answer);
    }
}
