import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2470A {

    /*
    * 0과 제일 가까운 수 찾기
    * 위 아래 idx v 판단해서 작은거 target
    * 부호 반대로 해서
    * 가장 가까운수 찾기
    *
    * 앞 뒤 합 판단 answer reset
    * */

    static int answerA, answerB, n ;
    static List<Integer> plus = new ArrayList<Integer>();
    static List<Integer> minus = new ArrayList<Integer>();
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for(int i = 0 ; i< n;i++){
            if(nums[i] > 0){
                plus.add(nums[i]);
            }else{
                minus.add(nums[i]);
            }
        }
        Collections.sort(minus);

        answerA = Integer.MAX_VALUE;
        answerB = Integer.MAX_VALUE;
        int minusSize = minus.size();

        for(int i = 0 ; i< plus.size() ; i++){
            int target = plus.get(i);
            int minusIdx = binarySearch(target * (-1));

            int a = Math.abs(target + minus.get(minusIdx));
            if(minusIdx+1 < minusSize){
                int b = Math.abs(target + minus.get(minusIdx+1));
                if(Math.abs(answerA + answerB) > Math.min(a ,b)){
                    answerB = target;
                    if(a > b){
                        answerA = minus.get(minusIdx+1);
                    }else{
                        answerA = minus.get(minusIdx);
                    }
                }
            }else{
                if(Math.abs(answerA + answerB) > a){
                    answerB = target;
                    answerA = minus.get(minusIdx);
                }
            }
        }

        //위 아래 반띵

        writer.write(answerA + " " + answerB);
        writer.flush();
        writer.close();
    }


    public static int binarySearch(int stand){
        int start = 0;
        int end = minus.size();
        int mid = (start + end)/2;

        while(start < end){
//            System.out.println(start + " " + mid + " " + end);
            mid = (start + end) /2;

            if(minus.get(mid) == stand){
                return mid;
            }

            if(minus.get(mid) < stand){
                start = mid +1 ;
            }else if(minus.get(mid) > stand){
                end = mid;
            }
        }
        return mid;
    }


}
