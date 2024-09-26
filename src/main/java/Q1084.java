import java.io.*;
import java.util.Arrays;

public class Q1084 {
    static int answer, n, t;
    static int[] nums;
    static int[] factorial = new int[50];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = Integer.parseInt(reader.readLine());

        // 일단 앞부터 바꿔봐야 하지 않나?
        /*
        * 개수가 많을 수록 앞부터 바꿔봐야 하는 것 같은데..
        * 앞에서 가면서 i-1이 i 보다 작을 때만 교환 하는듯?
        * 크거나 같으면 통과
        *  1 -2 교환, 2-3 교환 -> 다시 1,2로 갈 것 인가 3,4 로 갈것인가
        * 어차피 앞은 정렬된 상태라고 생각하고
        * a, b, c
        * a는 어차피 b보다 큼
        * b - c 변경 시 ==  c > b 임  -> a,c 비교 필요
        * b - c 변경 x 시 ==  b > c 이면 변경할 필요 자체가 없지
        *
        *
        * 결론
        * idx = 0 이면 무조건 비교
        * idx > 1 이면 뒤랑 비교해보고
        * 바꿀 꺼면 바꾸고 나서 idx를 -1
        * 안 바꿀꺼면 idx + 1
        *
        * 만약에 최대라면 얼마일까?
        * 딱 역순으로 되어있다면
        * 1 2 3 4
        * 2 1 3 4
        * 2 3 1 4
        * 3 2 1 4
        * -> 바로 1 4 로 갔으면 하는데 아쉽네 -> 시간 초과의 원인
        * 그럼 0을 찍으면 바로 최대 치로 가는건?
        *
        * 3 2 4 1
        * 3 4 2 1
        * 4 3 2 1
        *
        * 총 6회
        * 딱 3 2 1 인듯 3!
        * t가 n-1!보다 크면 바로 역순 프린트
        * */


//        factorial[1] = 1;
//        for(int i = 2; i < n; i++){
//            factorial[i] = factorial[i-1] + i;
//        }
////
//        boolean flag = false;
//
//        int time  = 0;
//        int idx = 0;
//        int max = 0;
//        while(time < t){
////            if(factorial[n-1] < t){
////                Arrays.sort(nums);
////                flag = true;
////                break;
////            }
////            System.out.println("idx : " + idx + " " + max);
////            for (int num : nums) {
////                System.out.print(num + " ");
////            }
////            System.out.println();
//
//
//            if(idx+1 >= n){
//                break;
//            }
//
//            if(idx == 0){
////                max = Math.max(max, idx);
//
//                if(nums[0] < nums[1]) {
//                    int temp = nums[0];
//                    nums[0] = nums[1];
//                    nums[1] = temp;
//                    time++;
//                }
//                if (max == 0) {
//                    max++;
//                }
//                idx = max;
//            }else{
//                if(nums[idx] < nums[idx+1]){
//                    int temp = nums[idx];
//                    nums[idx] = nums[idx+1];
//                    nums[idx+1] = temp;
//                    time++;
//                    max = Math.max(max, idx+1);
//                    idx--;
//                }else{
//                    if(idx == max){
//                        max++;
//                    }
//                    idx = max;
//                }
//            }
//        }
//
//        if(flag){
//            for(int i = 0; i< n; i++){
//                writer.write(nums[n -1 -i] + " ");
//            }
//        }else{
//            for (int num : nums) {
//                writer.write(num+" ");
//            }
//        }
//
//
////        for (int num : nums) {
////            writer.write(num+" ");
////        }

        /*
        * 전략을 바꾸자
        * 차라리 앞에서 부터 자기 보다 큰거 발견하면 바로 바꿈으로 하자
        *
        * */

//        for(int i = 0 ; i< t; i++){
//            for(int j = 0 ; j < n-1; j++){
//                if(nums[j] < nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                    break;
//                }
//            }
//        }

        while(t > 0){
            int max = 0;
            int idx = 0;
            for(int j = 0; j < (Math.min(t+1, n)); j++){
                max = Math.max(max, nums[j]);
                if(max == nums[j]){
                    idx = j;
                }
            }
            if(idx == 0){
                break;
            }
            t -= idx;
            for(int j = idx; j > 0; j--) {
                int temp = nums[j];
                nums[j]  = nums[j-1];
                nums[j-1] = temp;
            }
        }

        for (int num : nums) {
            writer.write(num+" ");
        }

        writer.flush();
        writer.close();
    }


}
