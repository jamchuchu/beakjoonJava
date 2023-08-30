import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2503 {
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(sc.readLine());
        int[][] list =  new int[num][3];

        for(int i = 0 ; i< num; i++) {
            String[] str = sc.readLine().split(" ");

            list[i][0] =  Integer.parseInt(str[0]);
            list[i][1] = Integer.parseInt(str[1]);// 스트라이크
            list[i][2] = Integer.parseInt(str[2]);// 볼
        }


        List<Integer> answer = new ArrayList<>();
        for(int i = 123; i<988; i++){
            if(i % 10 == 0){//120
                continue;
            }else if(i % 100 < 10){//102
                continue;
            }else if(i/ 100 == (i/10)% 10){//112
                continue;
            }else if(i/ 100 == i % 10){//131
                continue;
            }else if((i/10)% 10 == i % 10){
                continue;
            }
            answer.add(i);
            System.out.print(i+" ");
        }

        for(int i = 0 ; i<answer.size(); i++){
            int temp = answer.get(i);//123
            for(int j =0; j < num; j++){

            }
        }


    }


}
