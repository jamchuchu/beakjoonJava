import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Q15651{
    static int[] arr;
    static int[] select;

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num =  sc.nextInt();
        int m =  sc.nextInt();

        arr = new int[num];
        select = new int[m];

        for(int i = 0; i < num; i++){
            arr[i] = i+1;
        }

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
        for(int i=0; i< num; i++){
            select[depth] = arr[i];
            dfs(num, m, depth+1);
        }
    }
}