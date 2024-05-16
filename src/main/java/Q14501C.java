import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q14501C {
    static int n;
    static int[] day, pay;
    static List<List<Integer>> g = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        day = new int[n+1];
        pay = new int[n+1];


        for(int i = 1; i < n+1; i++) {
            String[] str = reader.readLine().split(" ");
            day[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }


        int total = 1 << n; // 2^totalProblems
        int answer = 0;
        for (int i = 1; i < total; i++) {
            int[] work = new int[n+2];

            List<Integer> workList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    workList.add(j+1);
                }
            }

            boolean flag = true;
            int money = 0;
            for(int j = 0; j < workList.size(); j++) {
                int num = workList.get(j);
                if(!flag){
                    break;
                }
                if(num + day[num] > n+1){
                    continue;
                }
                money += pay[num];
                for(int k = num; k < num + day[num]; k++){
                    if(work[k] == 1){
                        flag = false;
                        break;
                    }else{
                        work[k] = 1;
                    }
                }
                if(j == workList.size()-1){
                    System.out.println(workList);
                    answer = Integer.max(answer, money);
                }
            }
        }
        System.out.println(answer);
    }
}
