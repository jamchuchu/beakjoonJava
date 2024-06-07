import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q1755 {
    /*
    * 1. 숫자를 입력 받는다
    * 2. 변환해서 String으로 입력한다
    * 3. 정렬한다
    * 4. 숫자로 다시 변환한다
    * */

    static String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static PriorityQueue<String> list = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = start; i <= end; i++) {
            list.add(Arrays.stream(String.valueOf(i).split(""))//쪼개기
                    .map(Integer::parseInt)//integer로 바꾸기
                    .map(Q1755::change)//"one"으로 바꾸기
                    .collect(Collectors.joining(" ")));//한꺼번에 뭉치기
        }
        int i = 0;
        while(!list.isEmpty()){
            System.out.print(
                    Arrays.stream(list.poll().split(" "))//쪼개기
                            .map(Q1755::changeInt)//숫자로 바꾸기
                            .map(String::valueOf)//join위해 String
                            .collect(Collectors.joining())+ " "
            );
            i++;
            if(i % 10 ==0){
                System.out.println();
            }
        }
    }

    static String change(int i){
        return nums[i];
    }

    static int changeInt(String s){
        return Arrays.asList(nums).indexOf(s);
    }

}
