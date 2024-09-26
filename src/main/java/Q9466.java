import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q9466 {
    static int t, n, answer;
    static int[] nums;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++){

            answer = 0;

            n = Integer.parseInt(reader.readLine());
            nums = new int[n+1];
            visit = new boolean[n+1];

            String[] temp = reader.readLine().split(" ");
            for(int j = 0 ; j < n; j++){
                nums[j+1] = Integer.parseInt(temp[j]);

                //한바퀴 돌면서 1인 팀 픽
                if(nums[j+1] == j+1){
                    visit[j+1] = true;
                }
            }

            for(int j = 1; j <= n; j++){
                if(!visit[j]){
                    func(j);
                }
//                System.out.println(j);
//                for(int l = 1 ; l<= n; l++){
//                    System.out.print(visit[l] + " ");
//                }
//                System.out.println();
            }

           for(int j = 0 ; j < n; j++){
               if(!visit[j]){
                   answer++;
               }
           }

            writer.write(answer+"\n");
        }

        writer.flush();
        writer.close();
    }


    static void func(int start){
        List<Integer> list =  new ArrayList<>();
        int next = nums[start];
        if(visit[next]){return;}

        list.add(start);

        while(true){
            if(visit[next]){
                break;
            }
            list.add(next);
            next = nums[next];

            if(nums[next] == start){
                list.add(next);

                for(int i: list){
                    visit[i] = true;
                }
                break;
            }
        }
    }
}
