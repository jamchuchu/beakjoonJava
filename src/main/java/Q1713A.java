import java.io.*;
import java.util.*;

public class Q1713A {

    //	15252	164
    static int n, m;
    static String[] nums;

    static List<String> list = new ArrayList<>();
    static Map<String ,Integer> candi = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        nums = reader.readLine().split(" ");

        list.add(nums[0]);
        candi.put(nums[0] , 1);


        for(int i= 1; i< m; i++){
            if(candi.containsKey(nums[i])){
                int count = candi.get(nums[i]);
                candi.put(nums[i], count+1);
                continue;
            }
            // 없으면
            if(candi.size() < n){
                candi.put(nums[i], 1);
                list.add(nums[i]);
            }else{
                //마지막에 들어온것 삭제
                // 최솟값 구하기
                int min = candi.values().stream().min(Integer::compareTo).get();
                //맵 돌면서 일치하면 지우기
                for(int j= 0 ; j< list.size() ; j++){
                    if(candi.get(list.get(j)) == min){
                        candi.remove(list.get(j));
                        list.remove(j);
                        break;
                    }
                }
                // 자리나면 추가
                candi.put(nums[i], 1);
                list.add(nums[i]);
            }
        }

        Collections.sort(list);
        for(String s : list){
            writer.write(Integer.parseInt(s) + " ");
        }

        writer.flush();
        writer.close();
    }
}
