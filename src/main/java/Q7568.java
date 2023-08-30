import java.io.*;
import java.util.*;

public class Q7568 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];

        for(int i = 0 ; i< num; i++){
            String[] temp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        int[] count = new int[num];
        for(int i = 0 ; i< num; i++){
            for(int j = 0 ; j< num; j++){
                if(j != i){
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                        count[i] += 1;
                    }
                }
            }
        }
        String[] str = new String[]{"1", "2"};

        for(int i = 0 ; i< num; i++){
            System.out.print((count[i] + 1)+ " ");
        }


    }
}
