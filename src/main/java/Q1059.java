import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1059 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] num = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = Integer.parseInt(reader.readLine());

        Arrays.sort(num);


        int target = 0;
        for(int i = 0; i < n ; i++){
            if(num[i] > s){
                target = i;
                break;
            } else{
                target = -1;
            }
        }



        if(target == -1){
            answer = 0;
        }else {
            int left = 0;
            int right = 0;
            if (target == 0) {
                left = 0;
                right = num[0] ;
            } else {
                left = num[target - 1];
                right = num[target];
            }


            List<Integer> list = new ArrayList<>();
            for (int i = left + 1; i < right; i++) {
                list.add(i);
            }


            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) <= s && list.get(j) >= s) {
                        answer++;
                    }
                }
            }
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
