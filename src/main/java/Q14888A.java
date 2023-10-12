import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Q14888A {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] nums; //5 6
    static int[] oper;// 1 0 1 0
    static int[] opers;// 1 3
    static int[] visit;// 0 0
    static int[] select;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    // 시간복잡도 N!

    public static void main(String[] args) throws IOException {
        input();
        makeOpers();

        select = new int[N-1];
        visit = new int[N-1];
        combi(0);
        System.out.println(max);
        System.out.println(min);

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
        oper = new int[4];//0 0 1 0
        st = new StringTokenizer(reader.readLine());
        i = 0;
        while(st.hasMoreTokens()){
            oper[i] = Integer.parseInt(st.nextToken());
            i++;
        }
    }

    static void makeOpers(){ // 1 2 3 4로 구분
        opers = new int[N-1];
        int j = 0;
        for(int i = 0; i< 4; i++){
            while(oper[i] != 0){
                oper[i]--;
                opers[j] = i+1;
                j++;
            }
        }
    }

    static void combi(int depth){
        if(depth == N-1){
            int sum = nums[0];
            for(int i= 0 ; i< N-1; i++){
                if(select[i] == 1){
                    sum += nums[i+1];
                }else if(select[i] == 2){
                    sum -= nums[i+1];
                }else if(select[i] == 3){
                    sum *= nums[i+1];
                }else if(select[i] == 4){
                    sum /= nums[i+1];
                }
            }
            min = Integer.min(min, sum);
            max = Integer.max(max, sum);
        }else{
            for(int i = 0; i< N-1; i++){
                if(visit[i] == 0) {
                    select[depth] = opers[i];
                    visit[i] = 1;
                    combi(depth + 1);
                    select[depth] = 0;
                    visit[i] = 0;
                }

            }
        }
    }
}
