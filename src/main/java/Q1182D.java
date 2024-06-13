import java.io.*;
import java.util.Arrays;

public class Q1182D {
    /*
16536	232
    *
    * */
    static int answer, n,s;
    static int[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 1; i<= n ; i++) {
            dfs(0, i, 0, new int[i]);
        }

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void dfs(int k, int depth, int num, int[] list){
        if(depth == k){
            int sum = 0;
            for(int i=0; i<depth; i++){
                sum += arr[list[i]];
            }
            if(sum == s){
                answer++;
            }
            return;
        }

        for(int i = num; i < n; i++){
            list[k] = i;
            dfs(k +1, depth, i+1, list);
        }
    }


}
