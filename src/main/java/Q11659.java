import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] str = sc.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);

        int[] arr = new int[N];
        int[] sum = new int[N];
        str =  sc.readLine().split(" ");

        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(str[i]);
            if(i == 0) {
                sum[i] = arr[i];
            }else{
                sum[i] = arr[i]+ sum[i-1];
            }
        }

        int answer = 0;
        for(int i = 0; i< num; i++){
            str =  sc.readLine().split(" ");
            int a = Integer.parseInt(str[0])-1;
            int b = Integer.parseInt(str[1])-1;

            if(a == 0){
                answer = sum[b];
            }else{
                answer = sum[b]-sum[a-1];
            }
            System.out.println(answer);

        }

    }
}
