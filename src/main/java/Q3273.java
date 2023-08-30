import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3273 {
    public static void main(String[] args)throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(sc.readLine());
        String[] str = sc.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for(int i=0; i< num; i++){
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);

        int target = Integer.parseInt(sc.readLine());
        int count = 0;

        for(int i =0;i < num; i++){
            for(int j = i+1; j< num; j++){
                if(list.get(i) + list.get(j) == target){
                    count++;
                    break;
                }else if(list.get(i) + list.get(j) >  target){
                    break;
                }
            }
        }





        System.out.println(count);
    }


}
