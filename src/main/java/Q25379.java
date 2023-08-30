import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Q25379 {
    /*
     * 받자마자 0 이랑 1로 바꿔서 넣자
     * 처음이랑 끝을 기준으로 짝이 나오는 길이 판단
     * 0,1 -> 각각 밀어버리고
     * 0,0 -> 더빨리 1 나오는쪽으로 1 밀어버리고
     * 1,1 -> 더 빨리 0 나오는 쪽으로 0 밀어버리자
     *
     * 아예 판단 하지말고 2개다해서 빠른쪽으로 ㄱㄱ 해도 좋을지도
     *
     * 0/1
     * 0/1 둘을 안바꾼다
     * 1/0 바꾼다
     * 1/1 넘어간다
     * 0/0 넘어간다
     * */


    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(sc.readLine());
        int[] nums =  new int[num];

        String[] str = sc.readLine().split(" ");
        for(int j =0; j< num; j++){
            nums[j] = Integer.parseInt(str[j].split("")[str[j].length()-1])%2;
        }

//        for(int j = 0; j< num; j++){
//            System.out.print(nums[j]);
//        }
//        System.out.println();

        int[] nums01 = nums.clone();
        int[] nums10 = nums.clone();
        int count01 = 0;
        int count10 = 0;

        boolean flag = false;

        while(!flag) {
            for (int i = 0; i < num - 1; i++) {
                if (nums01[i] == 1 & nums01[i + 1] == 0) {//  바꿈
                    int temp = nums01[i + 1];
                    nums01[i + 1] = nums01[i];
                    nums01[i] = temp;
                    count01++;
                    for(int j = 0; j< num; j++){
                        System.out.print(nums01[j]);
                    }
                    System.out.println();
                }
            }
            int tempCount = 0;
            for (int i = 0; i < num - 1; i++) {
                if (nums01[i] != nums01[i + 1]) {
                    tempCount++;
                }
            }
            if(tempCount < 2){
                flag = true;
            }
        }

//        System.out.println(count01);
//        System.out.println();


        flag = false;

        while(!flag) {
            for(int i = 0; i< num-1; i++) {
                if (nums10[i] == 0 & nums10[i + 1] == 1) {//  바꿈
                    int temp = nums10[i + 1];
                    nums10[i + 1] = nums10[i];
                    nums10[i] = temp;
                    count10++;
//                    for(int j = 0; j< num; j++){
//                        System.out.print(nums10[j]);
//                    }
//                    System.out.println();
                }
            }
            int tempCount = 0;
            for (int i = 0; i < num - 1; i++) {
                if (nums10[i] != nums10[i + 1]) {
                    tempCount++;
                }
            }
            if(tempCount < 2){
                flag = true;
            }
        }

//        System.out.println(count10);
//        System.out.println();
        System.out.println(Math.min(count10, count01));


    }
}
