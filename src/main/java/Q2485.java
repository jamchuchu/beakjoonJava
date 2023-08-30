import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2485 {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(sc.readLine());

        int[] trees = new int[num];
        int[] width = new int[num];


        for(int i = 0; i< num; i++){
            trees[i] = Integer.parseInt(sc.readLine());
            if(i > 0) {
                width[i]  = trees[i] - trees[i- 1];
            }
        }

        Arrays.sort(width);

        int ans = 1;
        int temp = width[1];
        boolean flag = false;

        while(!flag){
            for(int i = 1; i< num; i++){
                if(width[i] % temp != 0){
                    break;
                }
                if(i ==  num-1){
                    ans = temp;
                    flag = true;
                }
            }
            temp--;
        }


        int count = 0;
        int i = 1;
        int minTree = trees[0];
        int idx = 1;

        while(idx < num){
            if(minTree + (ans * i) != trees[idx]){
                count++;
            }else{
                idx++;
            }
            i++;
        }

        System.out.println(count);

    }
}
