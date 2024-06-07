import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15650A {
    /* n개중 m개 고르는 combination 이다
    * 16072	168	*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        dfs(n, m, 0, 0, new int[m]);
    }

    static void dfs(int n, int m, int depth, int num, int[] list){
        if(depth == m){
            Arrays.stream(list).forEach(i -> {
                System.out.print(i + " ");
            });
            System.out.println();
            return;
        }
        for(int i = num; i < n ;  i++){
            list[depth] = i+1;
            dfs(n ,m , depth+1, i+1, list);
        }
    }

}
