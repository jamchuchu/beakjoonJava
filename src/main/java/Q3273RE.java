import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3273RE {
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

        int a = 0;
        int b = num-1;

        while(true){
            if(a >= b){
                break;
            }
            if(list.get(a) > target){
                break;
            }

            int temp = list.get(a) + list.get(b);

            if(temp == target){
                count++;
                a++;
            }else if(temp < target){
                a++;
            } else if (temp > target) {
                b--;
            }
            //1,2,3,4,5

        }

        System.out.println(count);
    }


}
