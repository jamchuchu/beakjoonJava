import java.io.*;
import java.util.Arrays;

public class Q2738 {
    static int n,m, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[][] map1 = new int[n][m];
        int[][] map2 = new int[n][m];

        for(int i = 0 ; i< n; i++){
            map1[i]  = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0 ; i< n; i++){
            map2[i]  = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i< n;i++){
            for(int j = 0; j< m; j++){
                System.out.print(map1[i][j] + map2[i][j] + " ");
            }
            System.out.println();
        }


//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
