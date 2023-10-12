import java.io.*;
import java.util.*;

public class Q15655 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] nums, select, visit;

    public static void main(String[] args) throws IOException {
        input();
        select = new int[M];
        visit = new int[N];
        combi(0);
        writer.flush();
    }

    static void input() throws IOException {
        st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        List<Integer> temp = new ArrayList<>();
        while(st.hasMoreTokens()) {
            temp.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(temp);
        nums = new int[N];
        for(int i = 0 ; i<N; i++){
            nums[i] = temp.get(i);
        }
    }

    static void combi(int depth) throws IOException {
        if (depth == M) {
            for(int i =0; i<M;i ++){
                writer.write(select[i] + " ");
            }
            writer.write("\n");
        }else if(depth == 0){
            for(int i = 0 ; i < N; i++){
                if(visit[i] == 0) {
                    select[depth] = nums[i];
                    visit[i] = 1;
                    combi(depth + 1);
                    select[depth] = 0;
                    visit[i] = 0;
                }
            }
        }else{
            for(int i = 0 ; i < N; i++){
                if(visit[i] == 0) {
                    if(select[depth - 1] < nums[i]) {
                        select[depth] = nums[i];
                        visit[i] = 1;
                        combi(depth + 1);
                        select[depth] = 0;
                        visit[i] = 0;
                    }
                }
            }
        }

    }
}
