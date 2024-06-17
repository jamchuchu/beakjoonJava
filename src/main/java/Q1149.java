import java.io.*;
import java.util.Arrays;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[][] answer = new int[n+1][3];
        int[][] RGB = new int[n+1][3];

        for(int i = 1; i <= n; i++){
            RGB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 1; i<= n; i++){
            answer[i][0] = RGB[i][0] + Math.min(answer[i-1][1],answer[i-1][2]);
            answer[i][1] = RGB[i][1] + Math.min(answer[i-1][2],answer[i-1][0]);
            answer[i][2] = RGB[i][2] + Math.min(answer[i-1][1],answer[i-1][0]);
        }

//        for(int i = 1; i<= n; i++){
//            for(int j = 0; j < 3; j++){
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

        writer.write(Math.min(Math.min(answer[n][0] , answer[n][1]) , answer[n][2]) + " ");
        writer.flush();
        writer.close();
    }
}
