import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    static int n, m;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine()) ;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        for(int i = 0; i < n; i++){
            map[i] = reader.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 8; i <= n; i++) {
            for (int j = 8; j <= m; j++) {
                count = check(i-8, i, j-8, j);
                answer = Integer.min(answer, count);
            }
        }

        System.out.println(answer);
    }

    public static int check(int startRaw, int endRaw, int startCol, int endCol){
        int count = 0;
        for(int i = startRaw; i < endRaw; i++) {
            for (int j = startCol; j < endCol; j++) {
                if(i % 2 == 0) {
                    if (j % 2 == 0 && map[i][j].equals("B")) {
                        count++;
                        continue;
                    }
                    if (j % 2 == 1 && map[i][j].equals("W")) {
                        count++;
                    }
                }else{
                    if (j % 2 == 0 && map[i][j].equals("W")) {
                        count++;
                        continue;
                    }
                    if (j % 2 == 1 && map[i][j].equals("B")) {
                        count++;
                    }
                }
            }
        }
        if (count > 32){
            count = 64 - count;
        }
        return count;
    }

}
