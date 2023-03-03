import java.util.*;
import java.io.*;


class Q15652{
    static int[] arr;
    static int[] select;

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        int m =  sc.nextInt();

        arr = new int[num];
        for(int i =0; i< num; i++){
            arr[i] = i+1;
        }
        select= new int[m];

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dfs(num, m, 0);
        bw.flush();
    }

    static void dfs(int num, int m, int depth) throws IOException {
        if(m == depth){
            for(int i = 0; i< select.length; i++){
                bw.write(select[i]+ " ");
            }
            bw.write("\n");
            return;
        }
        for(int i =0; i< num; i++){
            if(depth == 0){
                select[depth] = arr[i];
                dfs(num, m, depth+1);
            }else if(select[depth-1] <= arr[i]){
                select[depth] = arr[i];
                dfs(num, m, depth+1);
            }
        }

    }
}