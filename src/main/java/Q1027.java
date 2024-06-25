import java.io.*;
import java.util.Arrays;

public class Q1027 {
    static int answer, n;
    static int[] arr;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for(int i = 0; i < n; i++){
            int a = i;
            int b = arr[i];
            for(int j = i+1; j < arr.length; j++){
                int count = 0;
                int c = j;
                int d = arr[j];

                //두 점을 연결하는 선 f(x) = g*x + h = y
                double g = (double) (b-d)/(a-c);
                double h = b - a*g;

                for(int k = i + 1 ; k< j; k++){
                    //다른 점이 통과 하면
                    if(g * k + h <= arr[k]){
                        count++;
                    }
                }
                map[i][j] = count;
                map[j][i] = count;
            }
        }


        for(int i = 0 ; i< n; i++){
            answer = (int) Math.max(Arrays.stream(map[i]).filter(a -> a == 0).count(), answer);
        }

        //자기 자신 빼고
        writer.write((answer-1)+" ");
        writer.flush();
        writer.close();
    }


}
