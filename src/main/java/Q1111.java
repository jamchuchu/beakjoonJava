import java.io.*;
import java.util.Arrays;

public class Q1111 {

    static int n ;
    static String answer;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());

        //규칙 찾기
        /*
        * i -(i-1)
        * i%(i-1) = 0 --> 몫 바로 구하기
        * 아니면 몫 구해서 계산
        * */

        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ruleNum = 0;
        int rule1 = 0;// 더하기
        int rule2 = 0;// 곱하기
        int rule3 = 0;// 나머지
        int count = 0;
        for(int i = 1 ; i< n; i++){
            int sub = nums[i] - nums[i-1];
            int div = nums[i] / nums[i-1];
            int re = nums[i] % nums[i-1];
            if(i == 1){
                rule1 = sub;
                rule2 = div;
                rule3 = re;
//                continue;
            }
            count = 0;
            if(rule1 == sub){
                count++;
                ruleNum = 1;
            }
            if(div == rule2 && re == rule3){
                count++;
                ruleNum = 2;
            }
            if(count == 0){
                answer = "B";
                break;
            }
        }

//        System.out.println(count);

        if(count == 1){
            int temp = 0;
            if(ruleNum == 1){
                temp = 2 * nums[n-1] - nums[n-2];
            }else{
                int div = nums[n-1] / nums[n-2];
                int re = nums[n-1] % nums[n-2];
                temp = nums[n-1] * div + re;

            }
            answer = String.valueOf(temp);
        }else if(count == 2){
            answer = "A";
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
