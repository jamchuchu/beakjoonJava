import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q13335 {
    //	16324	184
    static ArrayDeque<Integer> bridge  =new ArrayDeque<>();
    static ArrayDeque<Integer> ques  =new ArrayDeque<>();
    static int answer ,n,w,l, nowWeight, time;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);//트럭 대수
        l = Integer.parseInt(str[1]);//길이
        w = Integer.parseInt(str[2]);//최대 무게
        ques =new ArrayDeque<>(Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList()));

        for(int i = 0 ; i < l; i++){
            bridge.add(0);
        }

        while(!ques.isEmpty()){
//            reader.readLine();
            nowWeight -= bridge.peek();
            bridge.poll();

            if(nowWeight + ques.peek() <= w){
                nowWeight += ques.peek();
                bridge.add(ques.poll());
            }else{
                bridge.add(0);
            }
//            System.out.println(bridge);
            time++;
        }
        time += l;

        writer.write(time + " ");
        writer.flush();
        writer.close();
    }



}
