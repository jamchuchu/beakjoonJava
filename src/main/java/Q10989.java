import java.io.*;
import java.util.*;


class Q10989{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bf.readLine());
        int[] arr = new int[10001];

        for(int i = 0; i< num; i++){
            int x = Integer.parseInt(bf.readLine());
            arr[x] = arr[x] + 1;
        }



        for(int i =0; i< arr.length; i++){
            if(arr[i] != 0){
                for(int j = 0; j < arr[i]; j++) {
                    bw.write(String.valueOf(i));
                    bw.write("\n");
                }
            }
        }
        bw.flush();
    }
}