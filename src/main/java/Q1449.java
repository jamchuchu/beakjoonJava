import java.io.*;
import java.util.Arrays;

public class Q1449 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        double now = 0;
        for(int i = 0 ; i< n; i++){
//            System.out.println(now);
            if(i == 0){
                now = (double) (arr[i] - 0.5);
                now += m;
                answer++;
                continue;
            }
            if(arr[i] < now){
                continue;
            }else{
                now = (double) (arr[i] - 0.5);
                now += m;
                answer++;
            }
        }



        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
