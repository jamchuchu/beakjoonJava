import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q2002 {

    /*
    * 순서가 당겨지면 추월? --x
    *
    * deq 써서
    * 넣은대로 안나오는 애들은 다 추월?
    * 먼저 나간애들 판단 -- 시간초과
     *
     * 뒤에 있음 -- 추월함 인증
     * out 중 남은것에 in 없으면 -> 이미나감 다시 넣고 break;
     *
     *
    * 14400	148
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;

        Deque<String> cars = new LinkedList<>();
        Deque<String> outCars = new LinkedList<>();
        for(int i = 0 ; i< n; i++){
            cars.add(reader.readLine());
        }
        for(int i = 0 ; i< n; i++){
            outCars.add(reader.readLine());
        }

        while(!outCars.isEmpty()){
            String in = cars.poll();

            while(!outCars.isEmpty()){
                String out = outCars.poll();
//                System.out.println(in + " " + out);

                if(in.equals(out)){
                    break;
                }
                if(!outCars.contains(in)){
                    outCars.addFirst(out);
                    break;
                }
                count++;
            }
        }


        System.out.println(count);
    }
}
