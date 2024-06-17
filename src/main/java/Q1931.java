import java.io.*;
import java.util.Arrays;

public class Q1931 {

    /*
    74140	908
    * 끝나는 순으로 정렬
    * 시작하는 순으로 정렬
    * 이전 끝나는 타임보다 지금 시작 시간이 같거나 크면 count++;
    * */
    static int answer, n;
    static int[][] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        nums = new int[n][2];
        for(int  i = 0 ; i< n; i++){
            nums[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(nums, (o1, o2)-> {
            if(o1[1] == o2[1]){return o1[0] - o2[0];}
            return o1[1] - o2[1];
        });
        int preEndTime = nums[0][1];
        answer = 1;

        for(int  i = 1 ; i< n; i++){
            if(nums[i][0] >= preEndTime){
                answer++;
                preEndTime = nums[i][1];
            }
        }
        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }
}
