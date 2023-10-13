import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182C {

    static int N, target, answer;
    static int[] nums ;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        answerFunc(0 , 0);
        if(target == 0){
            answer--;
        }
        System.out.println(answer);
    }
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        nums =  new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void answerFunc(int depth, int sum){
        if(depth == N){
            if(sum ==target) {
                answer++;
            }
        }else{
            answerFunc(depth +1, sum + nums[depth]);
            answerFunc(depth +1, sum);

        }
    }

}
