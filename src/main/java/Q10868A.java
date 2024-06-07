import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10868A {

    static int n ,m;
    static int[] nums;
    static int[] tr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        nums = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
                nums[i] = Integer.parseInt(reader.readLine());
        }

        int treeSize = (int) Math.pow(2 , Integer.toBinaryString(n).length());
        tr = new int[treeSize];
    }

    static void init(int start, int end, int node){
        if(start == end){
            tr[node] = nums[start];
        }else{
            int mid = (start + end) /2;

            init(start, mid , node +2);
            init(mid +1, end, node +2 +1);
        }
    }
}
