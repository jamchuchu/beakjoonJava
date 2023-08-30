import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(sc.readLine());
        int[] arr =  new int[num];

        for(int i =0; i < num; i++){
            arr[i] = Integer.parseInt(sc.readLine());
        }

        Arrays.sort(arr);

        int max = arr[0] * num;
        for(int i =1; i < num; i++){
            max = Math.max(max, arr[i] * (num-i));
        }


        System.out.println(max);
    }
}
