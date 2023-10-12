import java.io.*;
import java.util.StringTokenizer;

public class Q14888B {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] nums; //5 6
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    // 시간복잡도 N!

    public static void main(String[] args) throws IOException {
        input();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        calc(1, nums[0], Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        writer.write(max + " "+ min);
        writer.flush();
    }

    static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            nums[i] = Integer.parseInt(st.nextToken());
            i++;
        }
    }
    static void calc(int depth, int total, int plus, int minus, int multi, int div){
        if (depth == N){
            min  = Integer.min(total, min);
            max  = Integer.max(total, max);
        }
        if(plus != 0){
            calc(depth+1, total+nums[depth], plus-1, minus, multi, div);
        }
        if(minus != 0){
            calc(depth+1, total-nums[depth], plus, minus-1, multi, div);
        }
        if(multi != 0){
            calc(depth+1, total*nums[depth], plus, minus, multi-1, div);
        }
        if(div != 0){
            calc(depth+1, total/nums[depth], plus-1, minus, multi, div-1);
        }

    }

}
