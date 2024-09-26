import java.io.*;

public class Q9466A {
    static int t, n, answer;
    static int[] nums;
    static boolean[] v;
    static boolean[] answers;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        t= Integer.parseInt(reader.readLine());
        for(int l = 0 ; l < t ;l++){

            answer = 0;
            n = Integer.parseInt(reader.readLine());
            nums = new int[n+1];
            v = new boolean[n+1];
            answers = new boolean[n+1];
            String[] temp = reader.readLine().split(" ");
            for(int i = 0 ; i < n; i++){
                nums[i+1] = Integer.parseInt(temp[i]);
            }


            for(int i = 1; i<= n ; i++){
                if(answers[i])continue;
                dfs(i, nums[i], 1);
            }

            System.out.println(n - answer);
        }


        writer.flush();
        writer.close();
    }

    static void dfs(int start, int num, int count){
        if(v[num]){

            return;
        }
        v[num] = true;

        if(num == start){
            answer += count;
            for(int i = 1 ; i <= n; i++){
                if(v[i]){
                    answers[i] = true;
                }
            }
            return;
        }

        dfs(start, nums[num], count+1);
        v[num] = false;
    }
}
